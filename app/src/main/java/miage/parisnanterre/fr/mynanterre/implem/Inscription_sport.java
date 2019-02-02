package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import miage.parisnanterre.fr.mynanterre.R;

public class Inscription_sport extends Activity  {
    //private Spinner spinner;
    //private static final String[]paths = {"débutant", "intermédiaire", "avancé"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_inscription_sport);


        }
/*

        spinner = (Spinner)findViewById(R.id.liste_niveau);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Inscription_sport.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // lier a la bdd
                break;
            case 1:
                // lier a la bdd
                break;
            case 2:
                // lier a la bdd
                break;

        }
    }
*/
}