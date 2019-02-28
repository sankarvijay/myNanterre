package miage.parisnanterre.fr.mynanterre.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

import android.view.View;

import miage.parisnanterre.fr.mynanterre.implem.ListeCrous;
import miage.parisnanterre.fr.mynanterre.implem.ListeProduit;


public class ProduitFragment extends ListFragment {


    //lance l'activté avec categories des crous
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Create intent
        Intent intent = new Intent(view.getContext(), ListeProduit.class);
        //Start details activity
        startActivity(intent);
    }
}
