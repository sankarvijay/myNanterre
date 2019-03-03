package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miage.parisnanterre.fr.mynanterre.R;

public class Inscription_sport extends Activity {
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private EditText nom, prenom, niveau;
    private Button inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_inscription_sport);

        nom = (EditText) findViewById(R.id.numSeance);
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