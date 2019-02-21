package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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

        List<Crous> donnees = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CrousGridAdapter(this, donnees));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                String batiment = ((Crous) o).getBatiment();
                showDialog(IDENTIFIANT_BOITE_UN);



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

                Crous crous = new Crous(batiment, lieu,frequentation);
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


    @Override
    public Dialog onCreateDialog(int identifiant) {
        Dialog box = null;
        //En fonction de l'identifiant de la boîte qu'on veut créer
        switch(identifiant) {
            case IDENTIFIANT_BOITE_UN :
                // On construit la première boîte de dialogue, que l'on insère dans « box »
               box=new Dialog(this);

                box.setContentView(R.layout.dialog_box_frequentation);
                box.setTitle("DIALOG BOX");
                break;

        }
        return box;
    }


}
