package miage.parisnanterre.fr.mynanterre.implem;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.EntrepriseAdapter;

public class ListeEntreprise extends AppCompatActivity {


    private List<Entreprise> liste = new ArrayList<>();
    private EntrepriseAdapter enAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_entreprise);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        enAdapter = new EntrepriseAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(enAdapter);

         /*  try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/

        prepareEntrepriseData();
    }

    private void prepareEntrepriseData() {

         /*  try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM entreprise ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String logo = rst.getString("image_entreprise");
                String nom = rst.getString("nom_entreprise");

                Entreprise entreprise = new Entreprise(logo, nom);
                liste.add(entreprise);


            }
            enAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        Entreprise entreprise =new Entreprise(R.drawable.orange,"Orange", "Bonne entreprise,un sujet pas assez important", 3);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.aviva,"AVIVA", "Bonne entreprise, j'ai pas trop aimé l'ambiance", 4);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.edf,"EDF", "Bonne entreprise", 5);
        liste.add(entreprise);

        entreprise =new Entreprise(R.drawable.societegenerale,"Societé Générale", "Trés bonne entreprise.Des sujets importants", 4);
        liste.add(entreprise);


        enAdapter.notifyDataSetChanged();
    }
}
