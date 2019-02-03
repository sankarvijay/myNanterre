package miage.parisnanterre.fr.mynanterre.fragment;

/*
 * Created by Sankar Vijay on 18/01/2019.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
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

import miage.parisnanterre.fr.mynanterre.implem.Cours;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CoursAdapter;


public class CoursFragment extends Fragment {
    private List<Cours> listec = new ArrayList<>();
    private CoursAdapter cAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_cours, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        cAdapter = new CoursAdapter(listec);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);

         /*try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/
        prepareCoursData();


    }

    private void prepareCoursData() {

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
        Cours cours = new Cours("Triggers partie 1", "Les triggers (ou déclencheurs) sont des objets de la base de données. Attachés à une table, ils vont déclencher l'exécution d'une instruction, ou d'un bloc d'instructions, lorsqu'une ou plusieurs lignes sont insérées, supprimées ou modifiées dans la table à laquelle ils sont attachés.",
                "SGBD" ,"L3");
        listec.add(cours);

        cours = new Cours("Sockets et threads", "Une socket est une interface logicielle avec les services du système d’exploitation, grâce à laquelle un développeur exploitera facilement et de manière uniforme les services d’un protocole réseau.",
                "Système et réseaux" ,"M1");
        listec.add(cours);

        cours = new Cours("Code de procédure pénal", "L'infraction est une violation d'une loi de l'État, résultant d'un acte externe de l'homme, positif ou négatif, socialement imputable, ne se justifiant pas par l'accomplissement d'un devoir ou l'exercice d'un droit et qui est frappé d'une peine prévue par la loi ",
                "Economie-Droit" ,"L2");
        listec.add(cours);

        cours = new Cours("Rappels marketing Mix", "Le marketing mix ou mix marketing ou mix est, en marketing management opérationnel, l'ensemble des domaines opérationnels dans lesquels il faut élaborer des stratégies.",
                "Marketing","M2");
        listec.add(cours);

        cours = new Cours("Le past simple Anglais", "Notions simple de l'utilisation du past simple en anglais avec différents exemple.",
                "LV-Anglais","L1");
        listec.add(cours);

        cours = new Cours("Espagnol et sa culture", "Petit cours sur la culture espagnol, ses valeurs, sa pilitique, son regime éco et social.",
                "LV Culture1","L2");
        listec.add(cours);


        cAdapter.notifyDataSetChanged();
    }
}
