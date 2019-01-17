package miage.parisnanterre.fr.mynanterre;

/**
 * Created by Sankar Vijay on 17/01/2019.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class JobsFragment extends Fragment {

    // private static  final  String url = "jdbc:mysql://localhost/my_nanterre";
    // private static  final String user = "root";
    // private static final String psw = "root";
    //private static Connection conn;
    private List<Offre> liste = new ArrayList<>();
    private OffreAdapter oAdapter;

    public JobsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_offre, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        oAdapter = new OffreAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(oAdapter);
         /*try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/
        prepareOffreData();


    }

    private void prepareOffreData() {

      /*  try{

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM jobs ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            String titre=  rst.getString("titre");
            String entreprise=  rst.getString("entreprise");
            String localisation=  rst.getString("localisation");
            Date datePublicaton=  rst.getDate("date_publication");
            String descriptif=  rst.getString("descriptif");
            String siteWeb=  rst.getString("site_web");
            System.out.println("titre"+titre);
            while(rst.next()){
                Offre offre = new Offre(R.drawable.sopra,titre,"Stage",localisation,descriptif
                        ,"10/01/2019",entreprise);
                listeOffre.add(offre);
            }
            oAdapter.notifyDataSetChanged();

        }catch (SQLException e){
            e.printStackTrace();
        }*/
        Offre offre = new Offre(R.drawable.sopra, "Développeur Web H/F", "Stage", "Paris", "\n" +
                "Dans le cadre de son évolution et pour répondre à des besoins techniques la société recherche un développeur ..."
                , "10/01/2019", "Sopra Steria");
        liste.add(offre);

        offre = new Offre(R.drawable.total, "Ingénieur d'études et développement Java J2EE H/F", "CDI", "Paris La Défense", "\n" +
                "Dans le cadre du développement des activités de la branche Gas & Power, la société recherche un ...\n"
                , "05/01/2019", "Total");
        liste.add(offre);

        offre = new Offre(R.drawable.sopra, "Ingénieur d'études et développement .Net H/F", "Stage", "Paris", "\n" +
                "Dans le cadre du développement des activités de la branche Gas & Power, la société recherche ...\n"
                , "08/01/2019", "Sopra Steria");
        liste.add(offre);

        offre = new Offre(R.drawable.thales, "Développeur J2EE H/F", "Stage", "Genevilliers", "\n" +
                "Pour réaliser une nouvelle solution, Thalès recherche de nombreux stagiaires dans le ...\n"
                , "06/01/2019", "Thales");
        liste.add(offre);

        offre = new Offre(R.drawable.dassault, "Refonte d'un outil de gestion H/F", "Stage", "Paris", "\n" +
                "Dans le cadre du projet de refonte de l'outil de gestion des demandes d'accès au système d'information, il est envisagé de mettre en place une gestion ...\n"
                , "01/01/2019", "Dassault Aviation");
        liste.add(offre);

        oAdapter.notifyDataSetChanged();
    }
}