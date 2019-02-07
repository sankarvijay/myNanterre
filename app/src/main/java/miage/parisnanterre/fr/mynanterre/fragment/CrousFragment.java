package miage.parisnanterre.fr.mynanterre.fragment;

/*
 * Created by Sankar Vijay on 17/01/2019.
 */

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CrousAdapter;

import miage.parisnanterre.fr.mynanterre.implem.Crous;


public class CrousFragment extends Fragment {
    // à modifier en fonction de votre localhost
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<Crous> liste = new ArrayList<>();
    private CrousAdapter crAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_batiments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        crAdapter = new CrousAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(crAdapter);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        prepareOffreData();
    }

    private void prepareOffreData() {

        try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT batiment,lieu FROM Crous ORDER BY batiment";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");




                Crous crous = new Crous(batiment,lieu);
                liste.add(crous);


            }
            crAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        crAdapter.notifyDataSetChanged();
    }
}