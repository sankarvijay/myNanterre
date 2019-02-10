package miage.parisnanterre.fr.mynanterre.implem;

import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.EntrepriseAdapter;

public class ListeEntreprise extends AppCompatActivity {


    private List<Entreprise> liste = new ArrayList<>();
    private EntrepriseAdapter enAdapter;

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_entreprise);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        enAdapter = new EntrepriseAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(enAdapter);


        prepareEntrepriseData();
    }

    private void prepareEntrepriseData() {

        try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM entreprise ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String logo = rst.getString("image_entreprise");
                String nom = rst.getString("nom_entreprise");

                logo = logo.substring(0, logo.lastIndexOf("."));
                String image = "R.drawable." + logo;

                Entreprise entreprise = new Entreprise(image, nom);
                liste.add(entreprise);


            }
            enAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* Entreprise entreprise =new Entreprise(R.drawable.orange,"Orange", "Bonne entreprise,un sujet pas assez important", 3);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.aviva,"AVIVA", "Bonne entreprise, j'ai pas trop aimé l'ambiance", 4);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.edf,"EDF", "Bonne entreprise", 5);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.societegenerale,"Societé Générale", "Trés bonne entreprise.Des sujets importants", 4);
        liste.add(entreprise);


        enAdapter.notifyDataSetChanged();
    }*/
    }
}
