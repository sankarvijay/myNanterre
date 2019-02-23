package miage.parisnanterre.fr.mynanterre.implem;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;

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
    }
}