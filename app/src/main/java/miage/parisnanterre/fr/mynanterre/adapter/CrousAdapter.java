package miage.parisnanterre.fr.mynanterre.adapter;


import android.content.Context;
import android.graphics.Color;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.Crous;

import miage.parisnanterre.fr.mynanterre.R;


public  class CrousAdapter extends ArrayAdapter<Crous> {

    private List<Crous> listeCrous;

    public CrousAdapter(Context context ,List<Crous> listeCrous) {

        super(context,0,listeCrous);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Crous crous = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_crous, parent, false);
        }

        TextView batiment = (TextView) convertView.findViewById(R.id.batiment);
        TextView lieu = (TextView) convertView.findViewById(R.id.lieu);

        batiment.setText(crous.getBatiment());
        lieu.setText(crous.getLieu());

        if (crous.getFrequentation() == 3) {
            convertView.setBackgroundColor(Color.rgb(255, 99, 85));
        } else if (crous.getFrequentation() == 2)  {
            convertView.setBackgroundColor(Color.rgb(255,255,110));
        }
        else{
            convertView.setBackgroundColor(Color.rgb(140,255,110));
        }

        return convertView;
    }









}