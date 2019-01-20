package miage.parisnanterre.fr.mynanterre;

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

public class EvenementFragment extends Fragment {

    private List<Evenement> listeEv = new ArrayList<>();
    private EvenementAdapter evAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_event, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        evAdapter = new EvenementAdapter(listeEv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(evAdapter);
         /*try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/
        prepareEvenementData();

    }

    private void prepareEvenementData() {

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
        Evenement evenement = new Evenement(R.drawable.bass,"BASS CULTURE: DERRICK MAY & D'JULZ" , "pas de description \n" ,"01/01/2019" );
        listeEv.add(evenement);

        evenement = new Evenement(R.drawable.eblouissanre, "EBLOUISSANTE VENISE !","Héritière d’une tradition multiséculaire, la civilisation vénitienne brille de tous ses feux à l’aube du XVIIIe siècle... \n" , "17/12/2018" );
        listeEv.add(evenement);

        evenement = new Evenement(R.drawable.michael, "MICHAEL JACKSON : ON THE WALL", "Cette exposition explore l’impact culturel de la personnalité et de l’œuvre de Michael Jackson dans le champ de l’art contemporain des années 1980 à aujourd’hui ... \n" , "04/01/2019");
        listeEv.add(evenement);

        evenement = new Evenement(R.drawable.lecompte, "LE COMTE DE BOUDERBALA", "Impossible de ne pas connaître Le Comte de Bouderbala alias Sami Ameziane, qui fait partie de l ... \n", "15/01/2019");
        listeEv.add(evenement);


        evAdapter.notifyDataSetChanged();

    }


}

