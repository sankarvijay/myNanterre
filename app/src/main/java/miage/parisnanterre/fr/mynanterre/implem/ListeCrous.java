package miage.parisnanterre.fr.mynanterre.implem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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


public class ListeCrous   extends AppCompatActivity {

    Context context;
    private Intent intent;

    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<Crous> liste = new ArrayList<>();

    private final static int IDENTIFIANT_BOITE_UN  = 0;

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
                CharSequence ventes=(CharSequence)((Crous) o).getVentes();

                //On instancie notre layout en tant que View
                LayoutInflater factory = LayoutInflater.from(ListeCrous.this);
                final View alertDialogView = factory.inflate(R.layout.dialog_box_frequentation, null);


                AlertDialog.Builder alertDialogBuilder;
                alertDialogBuilder = new AlertDialog.Builder(ListeCrous.this);
                alertDialogBuilder.setView(alertDialogView);


                Button btn1 = (Button) alertDialogView.findViewById(R.id.buttonfaible);

                Button btn2 = (Button) alertDialogView.findViewById(R.id.buttonmoyenne);
                Button btn3 = (Button) alertDialogView.findViewById(R.id.buttonforte);

                btn1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        // btnAdd1 has been clicked
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation = 1 WHERE batiment='"+batiment+"';";
                            System.out.println(sqliD);
                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);

                            preparedStatement.executeUpdate();


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(ListeCrous.this, ListeCrous.class));

                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        // btnAdd2 has been clicked
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation = 2 WHERE batiment='"+batiment+"';";

                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);

                            System.out.println(sqliD);

                            preparedStatement.executeUpdate();
                            //startActivity(new Intent(ListeCrous.this, ListeCrous.class));

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(ListeCrous.this, ListeCrous.class));

                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        // btnAdd3 has been clicked
                        try {
                            conn = DriverManager.getConnection(url, user, psw);
                            String sqliD = "UPDATE Crous SET frequentation = 3 WHERE batiment='"+batiment+"';";

                            PreparedStatement preparedStatement = conn.prepareStatement(sqliD);

                            System.out.println(sqliD);

                            preparedStatement.executeUpdate();
                            //startActivity(new Intent(ListeCrous.this, ListeCrous.class));

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(ListeCrous.this, ListeCrous.class));

                    }
                });

                alertDialogBuilder.create().show();
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
                String batiment = rst.getString("batiment");
                String lieu = rst.getString("lieu");
                int frequentation=rst.getInt("frequentation");
                int id=rst.getInt("id_bat");
                Crous crous = new Crous(id,batiment, lieu,frequentation);
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




}