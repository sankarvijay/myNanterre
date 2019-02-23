package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.CrousGridAdapter;


public class ListeCrous extends AppCompatActivity {

    Context context;
    private Intent intent;

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<Crous> liste = new ArrayList<>();

    private final static int IDENTIFIANT_BOITE_UN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_batiments);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<Crous> donnees = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CrousGridAdapter(this, donnees));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                String batiment = ((Crous) o).getBatiment();
                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "SELECT ventes FROM Crous where batiment='" + batiment + "';";
                    Statement st = conn.createStatement();
                    ResultSet rst = st.executeQuery(sqliD);

                    while (rst.next()) {
                        String ventes = rst.getString("ventes");

                        ArrayList<String> liste = new ArrayList<>();
                        liste.add(ventes);

                        customDialog("Ventes dans ce point de restauration", liste.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private List<Crous> getListData() {

        try {
            conn = DriverManager.getConnection(url, user, psw);

            String sqliD = "SELECT * FROM Crous;";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                int id = rst.getInt("id_bat");
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");
                int frequentation = rst.getInt("frequentation");

                Crous crous = new Crous(id, batiment, lieu, frequentation);
                liste.add(crous);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return liste;


    }

    public void customDialog(String title, String message) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);

        builderSingle.setTitle(title);
        builderSingle.setMessage(message);

        builderSingle.show();
    }


    public Dialog onCreateDialog(int identifiant, int i) {
        Dialog box = null;

        //En fonction de l'identifiant de la boîte qu'on veut créer
        switch (identifiant) {
            case IDENTIFIANT_BOITE_UN:
                // On construit la première boîte de dialogue, que l'on insère dans « box »
                box = new Dialog(this);
                box.setContentView(R.layout.dialog_box_frequentation);
                box.setTitle("hello");


                Button btnFa = (Button) findViewById(R.id.buttonfaible);
                btnFa.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation=1 WHERE id_bat=(id) values (?) ;";
                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);


                            preparedStatement.setInt(1, i);

                            preparedStatement.executeUpdate();


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                });


                Button btnM = (Button) findViewById(R.id.buttonmoyenne);
                btnM.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation=2 WHERE id_bat=(id) values (?) ;";
                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);


                            preparedStatement.setInt(1, i);

                            preparedStatement.executeUpdate();


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                });

                Button btnFo = (Button) findViewById(R.id.buttonforte);
                btnFo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation=3 WHERE id_bat=(id) values (?) ;";
                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);


                            preparedStatement.setInt(1, i);

                            preparedStatement.executeUpdate();


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                });


                break;

        }
        return box;
    }


}
