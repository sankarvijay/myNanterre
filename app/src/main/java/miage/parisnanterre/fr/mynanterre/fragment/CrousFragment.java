package miage.parisnanterre.fr.mynanterre.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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

import miage.parisnanterre.fr.mynanterre.adapter.EntrepriseAdapter;
import miage.parisnanterre.fr.mynanterre.implem.Crous;
import miage.parisnanterre.fr.mynanterre.implem.Entreprise;
import miage.parisnanterre.fr.mynanterre.implem.ListeSport;


public class CrousFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;

    private List<Crous> liste = new ArrayList<>();
    private CrousAdapter cAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.liste_batiments, container, false);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            conn = DriverManager.getConnection(url, user, psw);

            String sqliD = "SELECT * FROM Crous;";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");
                int frequentation=rst.getInt("frequentation");

                Crous crous = new Crous(batiment, lieu,frequentation);
                liste.add(crous);

            }

            cAdapter = new CrousAdapter(getContext(),liste);

            setListAdapter(cAdapter);
            getListView().setOnItemClickListener(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Create intent
        Intent intent = new Intent(view.getContext(), ListeSport.class);
        //Start details activity
        startActivity(intent);
    }

}