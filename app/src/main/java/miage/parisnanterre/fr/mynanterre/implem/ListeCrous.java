package miage.parisnanterre.fr.mynanterre.implem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CrousAdapter;


public class ListeCrous  extends AppCompatActivity {

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;

    private List<Crous> liste = new ArrayList<>();
    private CrousAdapter cAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_batiments);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        cAdapter = new CrousAdapter(liste);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);

         /*  try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/

        prepareCrousData();
    }

    private void prepareCrousData() {

          try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM Crous ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");
                int frequentation=rst.getInt("frequentation");

                Crous crous = new Crous(batiment, lieu,frequentation);
                liste.add(crous);


            }
            cAdapter.notifyDataSetChanged();


        } catch (SQLException e) {
              e.printStackTrace();
          }





    }
}
