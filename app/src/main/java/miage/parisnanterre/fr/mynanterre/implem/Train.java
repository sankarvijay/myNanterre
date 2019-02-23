package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 09/02/2019.
 */
public class Train extends AppCompatActivity {
    public static TextView horaires;
    public static TextView direction;
    public static TextView theure;
    public static TextView code;
    public static TextView destination;
    public static TextView heureT;
    public static TextView info;
    public static TextView title;

    Button click;
    Button clickP;
    ImageView refresh;
    ImageView exchange;
    Spinner gare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_horaires);

        this.horaires = (TextView) findViewById(R.id.horaire);
        this.direction = (TextView) findViewById(R.id.direction);
        this.code = (TextView) findViewById(R.id.code);
        this.heureT = (TextView) findViewById(R.id.heureT);
        this.destination = (TextView) findViewById(R.id.destination);
        this.info = (TextView) findViewById(R.id.info_message);
        this.title = (TextView) findViewById(R.id.info_titre);
        this.refresh = (ImageView) findViewById(R.id.refresh);
        this.exchange = (ImageView) findViewById(R.id.echange);
        this.gare = (Spinner) findViewById(R.id.gare);


        click = (Button) findViewById(R.id.button);
        clickP = (Button) findViewById(R.id.button2);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchDataA process = new FetchDataA();
                process.execute();
            }
        });

        clickP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchDataR process = new FetchDataR();
                process.execute();
            }
        });
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                theure = (TextView) findViewById(R.id.heure);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                                String dateString = sdf.format(date);
                                theure.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchTraffic process = new FetchTraffic();
                process.execute();
            }
        });

        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), GareFavorite.class);
                Bundle extras = new Bundle();
                extras.putString("favori", gare.getSelectedItem().toString() + "");

                myIntent.putExtras(extras);
                startActivity(myIntent);


            }
        });


        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List listeGare = new ArrayList();
        listeGare.add("Saint-Germain-en-Laye");
        listeGare.add("Le Vesinet-Le Pecq");
        listeGare.add("Le Vesinet-Centre");

		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listeGare);


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        gare.setAdapter(adapter);


    }
}