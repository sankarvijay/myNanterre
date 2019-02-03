package miage.parisnanterre.fr.mynanterre.implem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.SportGridAdapter;
import miage.parisnanterre.fr.mynanterre.fragment.SeancesFragment;


public class ListeSport extends AppCompatActivity {
    private static final String url = "jdbc:mysql://10.0.2.2:8889/my_nanterre";
    private static final String user = "root";
    private static final String psw = "root";
    private static Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<Sport> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new SportGridAdapter(this, image_details));


        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                String nom = ((Sport) o).getTexte();

                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "SELECT horaire FROM sports where sport='" + nom + "' order by categorie ASC;";
                    Statement st = conn.createStatement();
                    ResultSet rst = st.executeQuery(sqliD);

                    while (rst.next()) {
                        String horaire = rst.getString("horaire");

                        ArrayList<String> liste = new ArrayList<>();
                        liste.add(horaire);

                        customDialog("Horaires", liste.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnRdv = (Button) findViewById(R.id.buttonRdv);
        btnRdv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Plannification.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button btnSeance = (Button) findViewById(R.id.btnSeances);
        btnSeance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Intent intent = new Intent(ListeSport.this, SeancesFragment.class);
                //
                //startActivity(intent);
                getSupportFragmentManager().beginTransaction().add(R.id.myFrame, new SeancesFragment()).commit();
            }

        });
    }

    private List<Sport> getListData() {
        List<Sport> list = new ArrayList<Sport>();
        Sport fitness = new Sport(R.drawable.fitness, "Fitness");
        Sport muscu = new Sport(R.drawable.muscu, "Musculation");
        Sport cardio = new Sport(R.drawable.salle_cardio, "Salle Cardio");

        list.add(fitness);
        list.add(muscu);
        list.add(cardio);


        return list;
    }


    public void customDialog(String title, String message) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.drawable.common_google_signin_btn_icon_light);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);


        builderSingle.show();
    }
}