package miage.parisnanterre.fr.mynanterre.implem;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.SportGridAdapter;


public class ListeSport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Sport> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new SportGridAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Sport sport = (Sport) o;


                Toast.makeText(ListeSport.this, "Du lundi au vendredi :" + "\n" + "08h00-21h00"
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Sport> getListData() {
        List<Sport> list = new ArrayList<Sport>();
        Sport fitness = new Sport(R.drawable.fitness, "Fitness");
        Sport muscu = new Sport(R.drawable.muscu, "Musculation");
        Sport cardio = new Sport(R.drawable.salle_cardio, "Salle Cardio");

        list.add(fitness);
        list.add(muscu);
        list.add(cardio);


        return list;
    }
}