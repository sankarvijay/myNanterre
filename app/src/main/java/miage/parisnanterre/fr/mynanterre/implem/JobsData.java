package miage.parisnanterre.fr.mynanterre.implem;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Dorian Vieira on 17/02/2019.
 */
public class JobsData extends AppCompatActivity {
    public static TextView horaires;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_offre);

        this.horaires = (TextView) findViewById(R.id.horaire);

                FetchData process = new FetchData();
                process.execute();
            }
}


