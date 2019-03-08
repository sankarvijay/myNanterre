package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.fragment.SeancesFragment;
import miage.parisnanterre.fr.mynanterre.fragment.SportFragment;

/**
 * Created by Sankar Vijay on 01/02/2019.
 */
public class Plannification extends Activity {
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private EditText numero;
    private EditText heureD;
    private EditText heureF;
    Button planifier;
    private Spinner spinnerSport;
    private Spinner spinnerLieu;

    private List<String> sports = new ArrayList<>();
    private List<String> batiments = new ArrayList<>();

    private DatePickerDialog.OnDateSetListener mDateSetListnener;
    private TextView mDisplayDate;
    private static final String TAG = "Plannification";
    Calendar c;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formrdv);

        numero = (EditText) findViewById(R.id.numId);
        heureD = (EditText) findViewById(R.id.heureD);
        heureF = (EditText) findViewById(R.id.heureF);
        spinnerSport = (Spinner) findViewById(R.id.sport);

        spinnerLieu = (Spinner) findViewById(R.id.lieu);
        planifier = (Button) findViewById(R.id.planifier);

        mDisplayDate = (TextView) findViewById(R.id.date);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int jour = c.get(Calendar.DAY_OF_MONTH);
                int mois = c.get(Calendar.MONTH);
                int annee = c.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(Plannification.this,
                        android.R.style.Theme_Material_DialogWhenLarge_NoActionBar,
                        mDateSetListnener,
                        annee, mois, jour);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
                dialog.show();
            }
        });
        mDateSetListnener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int annee, int mois, int jour) {
                mois = mois + 1;
                Log.d(TAG, "OndateSet: dd/mm/aaaa" + jour + "/" + mois + "/" + annee);
                String date = jour + "/" + mois + "/" + annee;
                mDisplayDate.setText(date);
            }
        };

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //on récupere l'id de la categorie du sport issu de ListeSport pour l'utliser dans la requete
        Intent intent = getIntent();
        final Integer idCategorie = intent.getIntExtra("ID_CATEGORIE", 1);
        //on va recup la liste des sports en fonction de la catégorie choisie pour les placer dans le spinner des sports
        try {
            conn = DriverManager.getConnection(url, user, psw);


            String sqliD = "SELECT * FROM sports where categorie ='" + idCategorie + "';";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);
            while (rst.next()) {
                String nomSport = rst.getString("sport");
                sports.add(nomSport);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sports);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //on va récupérer la liste des batiments pour le lieu du rdv dans le spinner lieu
        try {
            conn = DriverManager.getConnection(url, user, psw);

            String sqlBatiment = "SELECT * FROM batiments;";
            Statement st2 = conn.createStatement();
            ResultSet rst2 = st2.executeQuery(sqlBatiment);

            while (rst2.next()) {
                String batiment = rst2.getString("nomBatiment");
                batiments.add(batiment);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, batiments);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerLieu.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        planifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "insert into plannification_sport (numero,heured,heuref,dateRdv,sport,lieu,categorie) values (?,?,?,?,?,?,?) ;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sqliD);

                    preparedStatement.setString(1, numero.getText().toString());
                    preparedStatement.setString(2, heureD.getText().toString());
                    preparedStatement.setString(3, heureF.getText().toString());
                    preparedStatement.setString(4, mDisplayDate.getText().toString());
                    preparedStatement.setString(5, spinnerSport.getSelectedItem().toString());
                    preparedStatement.setString(6, spinnerLieu.getSelectedItem().toString());
                    preparedStatement.setInt(7, idCategorie);
                    preparedStatement.executeUpdate();
                    Toast.makeText(getApplicationContext(), "Votre séance a bien été planifié !", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), SportFragment.class));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}