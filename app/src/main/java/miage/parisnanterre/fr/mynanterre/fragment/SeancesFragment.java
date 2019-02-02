package miage.parisnanterre.fr.mynanterre.fragment;

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

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;

import miage.parisnanterre.fr.mynanterre.adapter.SeanceAdapter;

import miage.parisnanterre.fr.mynanterre.implem.Seance;

public class SeancesFragment extends Fragment {
    // à modifier en fonction de votre localhost
    private static final String url = "jdbc:mysql://localhost:3306/my_nanterre";
    private static final String user = "root";
    private static final String psw = "root";
    private static Connection conn;
    private List<Seance> liste = new ArrayList<>();
    private SeanceAdapter sAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_seances, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        sAdapter = new SeanceAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        prepareSeanceData();
    }

    private void prepareSeanceData() {

        try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM Plannification_sport ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String nom = rst.getString("nom");
                String prenom = rst.getString("prenom");
                Time heure_d = rst.getTime("heure_d");
                Time heure_f = rst.getTime("heure_f");
                String sport = rst.getString("sport");
                String lieu = rst.getString("lieu");




                Seance seance = new Seance(nom, prenom,heure_d,heure_f,sport,lieu);
                liste.add(seance);


            }
            sAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sAdapter.notifyDataSetChanged();
    }

}
