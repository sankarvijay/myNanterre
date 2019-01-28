package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.JobsGridAdapter;
import miage.parisnanterre.fr.mynanterre.adapter.OffreAdapter;
import miage.parisnanterre.fr.mynanterre.adapter.SportGridAdapter;
import miage.parisnanterre.fr.mynanterre.fragment.OffreFragment;

public class ListeJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        List<Jobs> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new JobsGridAdapter(this, image_details));

        //inclure ici la redirection vers liste des entreprises apres clqiue sur le bouton ou dans Jobs fragment ?
        //pour le clique sur un carré en fonction du carré cliqué
        for (int i = 0; i < gridView.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            GridLayout gridLayout = (GridLayout) gridView.getChildAt(i);
            final int finalI = i;
            //si bouton entreprise car c'est le 6e alors on redirige vers les entreprises

            if(i==6) {
                gridLayout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(ListeJobs.this, OffreFragment.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);

                    }
                });
            }
        }





        // When the user clicks on the GridItem
       /* gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Sport sport = (Sport) o;
                String nom= ((Sport) o).getTexte();
                String horaire = null;

                try {
                    conn = DriverManager.getConnection(url, user, psw);

                    Statement st = conn.createStatement();

                    String sqliD = "SELECT * FROM Sports WHERE //sport='nom'// ";
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
        });*/
    }



    private List<Jobs> getListData() {
        List<Jobs> list = new ArrayList<Jobs>();
        Jobs stage = new Jobs(R.drawable.stage, "Stage");
        Jobs alternance = new Jobs(R.drawable.alternance, "Alternance");
        Jobs cdi = new Jobs(R.drawable.cdi, "CDI");
        Jobs cdd = new Jobs(R.drawable.cdd, "CDD");
        Jobs interim = new Jobs(R.drawable.interim, "Interim");
        Jobs entreprise = new Jobs(R.drawable.entreprise, "Entreprises");

        list.add(stage);
        list.add(alternance);
        list.add(cdi);
        list.add(cdd);
        list.add(interim);
        list.add(entreprise);


        return list;
    }



    public void customDialog(String title, String message){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.mipmap.ic_launcher);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);


        builderSingle.show();
    }
}
