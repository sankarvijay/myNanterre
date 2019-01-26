package miage.parisnanterre.fr.mynanterre.implem;

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
                Sport sport = (Sport) o;
                String nom= o.getTexte();
                String horaire = null;

                try {
                    conn = DriverManager.getConnection(url, user, psw);

                    Statement st = conn.createStatement();

                    String sqliD = "SELECT * FROM Sports WHERE //sport='nom'// "
                    Statement st = conn.createStatement();
                    ResultSet rst = st.executeQuery(sqliD);
                    { String horaire = rst.getString("horaire");
                        String lieu = rst.getString("lieu"); }
                    } catch (SQLException e) {
                        e.printStackTrace(); }

                customDialog("Horaires",horaire,lieu);


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



    public void customDialog(String title, String message){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.mipmap.ic_notification);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);




        builderSingle.show();
    }
}