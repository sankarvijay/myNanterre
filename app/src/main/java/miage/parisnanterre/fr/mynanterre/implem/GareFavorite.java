package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 23/02/2019.
 */
public class GareFavorite extends AppCompatActivity {
    public static TextView horaires;
    public static TextView direction;
    public static TextView theure;
    public static TextView code;
    public static TextView destination;
    public static TextView heureT;
    public static TextView info;
    public static TextView title;
    ImageView refresh;
    ImageView exchange;
    String gareFavori = "";
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_horaires_favoris);

        this.horaires = (TextView) findViewById(R.id.horaire2);
        this.direction = (TextView) findViewById(R.id.direction2);
        this.code = (TextView) findViewById(R.id.code2);
        this.heureT = (TextView) findViewById(R.id.heureT2);
        this.destination = (TextView) findViewById(R.id.destination2);
        this.info = (TextView) findViewById(R.id.info_message);
        this.title = (TextView) findViewById(R.id.info_titre);
        this.refresh = (ImageView) findViewById(R.id.refresh2);
        this.exchange = (ImageView) findViewById(R.id.echange2);
        this.click = (Button) findViewById(R.id.button2);


        Bundle extras = getIntent().getExtras();
        gareFavori = extras.getString("favori");

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchDataFav process = new FetchDataFav(gareFavori);
                process.execute();
            }
        });

        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Train.class);
                startActivity(myIntent);
            }
        });


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchTraffic process = new FetchTraffic();
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
                                theure = (TextView) findViewById(R.id.heure2);
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


    }
}
