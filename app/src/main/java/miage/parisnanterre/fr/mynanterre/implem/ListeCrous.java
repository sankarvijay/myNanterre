package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
=======
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CrousGridAdapter;


<<<<<<< HEAD
public class ListeCrous   extends AppCompatActivity {

    Context context;
    private Intent intent;
=======
public class ListeCrous extends AppCompatActivity {
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
<<<<<<< HEAD
=======
    private static CrousFragment fragment;
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd
    private List<Crous> liste = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_batiments);

        List<Crous> donnees = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CrousGridAdapter(this, donnees));

<<<<<<< HEAD

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                String batiment = ((Crous) o).getBatiment();
=======
        ListView lView = (ListView) fragment.getView().findViewById(android.R.id.list);

        cAdapter = new CrousAdapter(this, liste);
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd

                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "SELECT ventes FROM Crous where batiment='" + batiment + "' ;";
                    Statement st = conn.createStatement();
                    ResultSet rst = st.executeQuery(sqliD);

                    while (rst.next()) {
                        String vente = rst.getString("ventes");

                        ArrayList<String> liste = new ArrayList<>();
                        liste.add(vente);

                        customDialog("Ventes", liste.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        });


<<<<<<< HEAD

=======
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


     //   prepareCrousData();
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd
    }

    private List<Crous> getListData() {

        try {
            conn = DriverManager.getConnection(url, user, psw);

            String sqliD = "SELECT * FROM Crous;";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");
                int frequentation = rst.getInt("frequentation");

                Crous crous = new Crous(batiment, lieu, frequentation);
                liste.add(crous);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
       // List<Crous> list = new ArrayList<Crous>();
        Crous stage = new Crous("bat 1", "Stage",1);
        Crous stage2 = new Crous("bat 1", "Stage",2);
        Crous stage3= new Crous("bat 1", "Stage",3);
        liste.add(stage);
        liste.add(stage2);
        liste.add(stage3);
        //return list;*/

<<<<<<< HEAD
        return liste;


    }

    public void customDialog(String title, String message) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);

        builderSingle.setTitle(title);
        builderSingle.setMessage(message);

        builderSingle.show();
=======
>>>>>>> 8ebfaaeac91797a3c367b15e4032ccf6312e23cd
    }

}
