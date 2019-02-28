package miage.parisnanterre.fr.mynanterre.implem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CrousGridAdapter;


/**
 * Created by Sankar Vijay on 28/02/2019.
 */
public class ListeProduit extends AppCompatActivity {
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<Produit> liste = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        ListView listeV = (ListView) findViewById(R.id.liste);


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<Produit> produit_details = getListData();
        ArrayAdapter<Produit> adapter = new ArrayAdapter<Produit>(getApplicationContext(), android.R.layout.simple_list_item_1, produit_details);
        listeV.setAdapter(adapter);
    }

    private List<Produit> getListData() {


        try {

            conn = DriverManager.getConnection(url, user, psw);
            Bundle extras = getIntent().getExtras();
            String stringVariableName = extras.getString(CrousGridAdapter.EXTRA_MESSAGE);
            int idBat = Integer.parseInt(stringVariableName);

            String sqliD = "SELECT * FROM vente where id_bat ='" + idBat + "';";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String produit = rst.getString("produit");
                int dispo = rst.getInt("dispo");

                Produit produits = new Produit(dispo, produit);
                liste.add(produits);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;

    }


}