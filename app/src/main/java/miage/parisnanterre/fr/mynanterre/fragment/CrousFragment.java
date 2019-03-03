package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import miage.parisnanterre.fr.mynanterre.implem.ListeCrous;

public class CrousFragment extends ListFragment {
    //lance l'activté avec categories des crous
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Create intent
        Intent intent = new Intent(view.getContext(), ListeCrous.class);
        //Start details activity
        startActivity(intent);
    }
}
