package miage.parisnanterre.fr.mynanterre.implem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.SportGridAdapter;


public class ListeSport extends AppCompatActivity {
    private static final String url = "jdbc:mysql://10.0.2.2:8889/my_nanterre";
    private static final String user = "root";
    private static final String psw = "root";
    private static Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Sport> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new SportGridAdapter(this, image_details));


        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                String nom = ((Sport) o).getTexte();

                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "SELECT jour_semaine,horaire,lieu FROM sports where sport='"+nom+"' order by categorie ASC;";
                    System.out.println(sqliD);
                    Statement st = conn.createStatement();
                    ResultSet rst = st.executeQuery(sqliD);

                    while (rst.next()) {
                        String jour = rst.getString("jour_semaine");
                        String horaire = rst.getString("horaire");
                        String lieu = rst.getString("lieu");

                        //StringBuilder sb = new StringBuilder();
                       // sb.append(jour).append(" de ").append(horaire).append(" au ").append(lieu).toString();


                        ArrayList<String> liste = new ArrayList<>();
                        liste.add(jour);
                        liste.add(horaire);
                        liste.add(lieu);

                        customDialog("Horaires", liste.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                //Toast.makeText(ListeSport.this, "Du lundi au vendredi :" + "\n" + "08h00-21h00"
                // , Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Sport> getListData() {
        List<Sport> list = new ArrayList<Sport>();
        Sport fitness = new Sport(R.drawable.fitness, "Fitness");
        Sport muscu = new Sport(R.drawable.muscu, "Musculation");
        Sport cardio = new Sport(R.drawable.salle_cardio, "Salle Cardio");

        list.add(fitness);
        list.add(muscu);
        list.add(cardio);


        return list;
    }


    public void customDialog(String title, String message) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.drawable.common_google_signin_btn_icon_light);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);


        builderSingle.show();
    }
}