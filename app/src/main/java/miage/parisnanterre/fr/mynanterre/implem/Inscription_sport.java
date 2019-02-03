package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miage.parisnanterre.fr.mynanterre.R;

public class Inscription_sport extends Activity {
    //private Spinner spinner;
    //private static final String[]paths = {"débutant", "intermédiaire", "avancé"};
    //private static final String url = "jdbc:mysql://localhost:3306/my_nanterre";
    private static final String url = "jdbc:mysql://10.0.2.2:8889/my_nanterre";
    private static final String user = "root";
    private static final String psw = "root";
    private static Connection conn;
    private EditText nom, prenom, niveau;
    private Button inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_inscription_sport);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        niveau = (EditText) findViewById(R.id.niveau);

        inscrire = (Button) findViewById(R.id.button);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "insert into reservation_sport(nom,prenom,niveau) values (?,?,?) ;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sqliD);


                    preparedStatement.setString(1, nom.getText().toString());
                    preparedStatement.setString(2, prenom.getText().toString());
                    preparedStatement.setString(3, niveau.getText().toString());

                    preparedStatement.executeUpdate();
                    Toast.makeText(getApplicationContext(), "Votre inscription à la séance à été validée!", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Inscription_sport.this, ListeSport.class));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
/*

        spinner = (Spinner)findViewById(R.id.liste_niveau);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Inscription_sport.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // lier a la bdd
                break;
            case 1:
                // lier a la bdd
                break;
            case 2:
                // lier a la bdd
                break;

        }
    }
*/
