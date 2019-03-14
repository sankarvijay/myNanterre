package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
<<<<<<< HEAD
=======

>>>>>>> 0d5c426045cdbfac39d06e35793ca00708fe819b
import miage.parisnanterre.fr.mynanterre.implem.ListeTrain;

/**
 * Created by Sankar Vijay on 09/02/2019.
 */
public class TrainFragment extends ListFragment {
    //lance l'activté avec categories des crous
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Create intent
        Intent intent = new Intent(view.getContext(), ListeTrain.class);
        //Start details activity
        startActivity(intent);
    }
}
