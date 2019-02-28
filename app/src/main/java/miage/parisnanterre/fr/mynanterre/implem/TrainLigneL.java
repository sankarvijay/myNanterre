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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 27/02/2019.
 */
public class TrainLigneL extends AppCompatActivity {
    public static TextView horaires;
    public static TextView direction;
    public static TextView theure;
    public static TextView destination;
    public static TextView heureT;

    Button clickP;
    ImageView plans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_horaires_ligne_l);

        this.horaires = (TextView) findViewById(R.id.horaire);
        this.direction = (TextView) findViewById(R.id.direction);
        this.heureT = (TextView) findViewById(R.id.heureT);
        this.destination = (TextView) findViewById(R.id.destination);
        this.plans = (ImageView) findViewById(R.id.plan2);

        clickP = (Button) findViewById(R.id.button2);
        clickP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchDataLigneL process = new FetchDataLigneL();
                process.execute();
            }
        });
        plans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), TrainPlanLigneL.class);
                startActivity(myIntent);
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
                                DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.FRANCE);
                                String dateString = df.format(date);
                                String[] dateS = dateString.split("G");
                                theure.setText(dateS[0]);
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