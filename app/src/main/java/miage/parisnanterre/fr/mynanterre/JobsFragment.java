package miage.parisnanterre.fr.mynanterre;

/*
 * Created by Sankar Vijay on 17/01/2019.
 */

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobsFragment extends Fragment {

    private static  final  String url = "jdbc:mysql://10.0.2.2:3306/my_nanterre";
    private static  final String user = "root";
    private static final String psw = "";
    private static Connection conn;
    private List<Offre> liste = new ArrayList<>();
    private OffreAdapter oAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_offre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        oAdapter = new OffreAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(oAdapter);

         try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        prepareOffreData();
    }

    private void prepareOffreData() {

        try{

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM jobs ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while(rst.next()){

                String titre = rst.getString("titre");
                String entreprise = rst.getString("entreprise");
                String localisation = rst.getString("localisation");
                Date datePublicaton = rst.getDate("date_publication");
                String descriptif = rst.getString("descriptif");
                String siteWeb = rst.getString("site_web");
                System.out.println("titre" + titre);

                Offre offre = new Offre(R.drawable.sopra,titre,"Stage",localisation,descriptif
                        ,"10/01/2019",entreprise);

                liste.add(offre);
            }
            oAdapter.notifyDataSetChanged();

        }catch (SQLException e){
            e.printStackTrace();
        }

        oAdapter.notifyDataSetChanged();
    }
}