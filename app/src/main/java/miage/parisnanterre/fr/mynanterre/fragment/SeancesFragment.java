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

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<Seance> liste = new ArrayList<>();
    private SeanceAdapter sAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.liste_seances, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        sAdapter = new SeanceAdapter(liste, getContext());
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
            String sqliD = "SELECT * FROM plannification_sport ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {

                int numero = rst.getInt("numero");
                Time heured = rst.getTime("heured");
                Time heuref = rst.getTime("heuref");
                String dateRdv = rst.getString("dateRdv");
                String sport = rst.getString("sport");
                String lieu = rst.getString("lieu");
                Seance seance = new Seance(numero, heured, heuref, sport, lieu, dateRdv);
                liste.add(seance);

            }
            sAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sAdapter.notifyDataSetChanged();
    }
}
