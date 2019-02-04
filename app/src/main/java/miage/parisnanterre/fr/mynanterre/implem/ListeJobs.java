package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.JobsGridAdapter;


public class ListeJobs extends AppCompatActivity {

    Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Jobs> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new JobsGridAdapter(this, image_details));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //Lorsqu'on souhaite rediriger/afficher/faire qq chose apres un clique sur un element du gridView
                switch(position)
                {
                    case 0: //Stage
                        intent = new Intent(v.getContext(), ListeJobs.class);
                        break;
                    case 1: //Alternance
                        intent = new Intent(v.getContext(), ListeJobs.class);
                        break;
                    case 2: //CDI
                        intent = new Intent(v.getContext(), ListeJobs.class);
                        break;
                    case 3: //CDD
                        intent = new Intent(v.getContext(), ListeJobs.class);
                        break;
                    case 4: // INTERIM
                        intent = new Intent(v.getContext(), ListeJobs.class);
                        break;
                    case 5: // ENTREPRISES //si on clique sur le bouton entreprises
                        //intent =  new Intent(context, EntrepriseFragment.class);
                        intent = new Intent(v.getContext(), ListeEntreprise.class);
                        break;
                    default:
                        Toast.makeText(ListeJobs.this, "Vous êtes devez choisir une catégorie " + position, Toast.LENGTH_SHORT).show();
                        break;
                }
                //startActivity(intent);
                startActivityForResult(intent, 0);

            }
        });

        //quand on clique sur le bouton ajouter une offre dans la vue activty_main2 (categories des jobs)
        Button btnAddOffre = (Button) findViewById(R.id.buttonAjoutOffres);
        btnAddOffre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AjoutOffre.class);
                startActivityForResult(myIntent, 0);
            }

        });

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

}
