package miage.parisnanterre.fr.mynanterre;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Accueil extends AppCompatActivity {
    private List<Offre> listeOffre = new ArrayList<>();
    private RecyclerView recyclerView;
    private OffreAdapter oAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        oAdapter = new OffreAdapter(listeOffre);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(oAdapter);
        prepareOffreData();
    }

    private void prepareOffreData() {
        Offre offre = new Offre(R.drawable.sopra,"Développeur Web H/F","Stage","Paris","\n" +
                "Dans le cadre de son évolution et pour répondre à des besoins techniques la société recherche un développeur ..."
        ,"10/01/2019","Sopra Steria");
        listeOffre.add(offre);

        offre = new Offre(R.drawable.total,"Ingénieur d'études et développement Java J2EE H/F","CDI","Paris La Défense","\n" +
                "Dans le cadre du développement des activités de la branche Gas & Power, la société recherche un ...\n"
                ,"05/01/2019","Total");
        listeOffre.add(offre);

        offre = new Offre(R.drawable.sopra,"Ingénieur d'études et développement .Net H/F","Stage","Paris","\n" +
                "Dans le cadre du développement des activités de la branche Gas & Power, la société recherche ...\n"
                ,"08/01/2019","Sopra Steria");
        listeOffre.add(offre);

        offre = new Offre(R.drawable.thales,"Développeur J2EE H/F","Stage","Genevilliers","\n" +
                "Pour réaliser une nouvelle solution, Thalès recherche de nombreux stagiaires dans le ...\n"
                ,"06/01/2019","Thales");
        listeOffre.add(offre);

        offre = new Offre(R.drawable.dassault,"Refonte d'un outil de gestion H/F","Stage","Paris","\n" +
                "Dans le cadre du projet de refonte de l'outil de gestion des demandes d'accès au système d'information, il est envisagé de mettre en place une gestion ...\n"
                ,"01/01/2019","Dassault Aviation");
        listeOffre.add(offre);

        oAdapter.notifyDataSetChanged();
    }
}

