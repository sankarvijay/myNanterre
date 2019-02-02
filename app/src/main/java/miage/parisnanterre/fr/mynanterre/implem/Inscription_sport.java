package miage.parisnanterre.fr.mynanterre.implem;

public class Inscription_sport extends Activity implements OnItemSelectedListener{

    private Spinner spinner;
    private static final String[]paths = {"débutant", "intermédiaire", "avancé"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_inscription_sport);


        }

        spinner = (Spinner)findViewById(R.id.liste_niveau);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Inscription_sport.this,
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

}