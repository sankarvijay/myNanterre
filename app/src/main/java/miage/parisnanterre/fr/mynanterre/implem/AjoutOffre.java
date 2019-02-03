package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 01/02/2019.
 */
public class AjoutOffre extends Activity {
    private static final String url = "jdbc:mysql://10.0.2.2:3306/my_nanterre";
    private static final String user = "root";
    private static final String psw = "";
    private static Connection conn;
    private EditText titre, localisation, descriptif, datePublication, entreprise, siteWeb;
    private RadioGroup contrat;
    private Button ajouterOffre;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_add_offre);

        titre = (EditText) findViewById(R.id.titre);
        contrat = (RadioGroup) findViewById(R.id.contrat);//radioGroupe qui contient pls id
        localisation = (EditText) findViewById(R.id.localisation);
        descriptif = (EditText) findViewById(R.id.descriptif);
        datePublication = (EditText) findViewById(R.id.datePublication);
        entreprise = (EditText) findViewById(R.id.entreprise);
        siteWeb = (EditText) findViewById(R.id.siteWeb);
        ajouterOffre = (Button) findViewById(R.id.ajouterOffre);


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ajouterOffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "insert into jobs (titre,contrat,localisation,descriptif,date_publication,entreprise,site_web,image) values (?,?,?,?,?,?,?,NULL) ;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sqliD);

                    preparedStatement.setString(1, titre.getText().toString());
                    preparedStatement.setString(2, ((RadioButton)findViewById(contrat.getCheckedRadioButtonId())).getText().toString());
                    preparedStatement.setString(3, localisation.getText().toString());
                    preparedStatement.setString(4, descriptif.getText().toString());
                    preparedStatement.setString(5, datePublication.getText().toString());
                    preparedStatement.setString(6, entreprise.getText().toString());
                    preparedStatement.setString(7, siteWeb.getText().toString());
                    preparedStatement.executeUpdate();
                    Toast.makeText(getApplicationContext(), "Votre offre a été ajouté !", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(AjoutOffre.this, ListeJobs.class));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}