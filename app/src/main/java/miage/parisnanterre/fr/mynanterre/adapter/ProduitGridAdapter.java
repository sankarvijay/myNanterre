package miage.parisnanterre.fr.mynanterre.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.implem.Crous;
import miage.parisnanterre.fr.mynanterre.implem.ListeProduit;
import miage.parisnanterre.fr.mynanterre.implem.ListeSport;
import miage.parisnanterre.fr.mynanterre.implem.Produit;
import miage.parisnanterre.fr.mynanterre.implem.TrainLigneL;


public class ProduitGridAdapter extends BaseAdapter {

    private List<Produit> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public ProduitGridAdapter(Context aContext, List<Produit> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProduitGridAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_produit, null);
            holder = new ProduitGridAdapter.ViewHolder();
            holder.produit = (TextView) convertView.findViewById(R.id.produit);
            convertView.setTag(holder);
        } else {
            holder = (ProduitGridAdapter.ViewHolder) convertView.getTag();
        }

        Produit produit = this.listData.get(position);
        holder.produit.setText(produit.getNomProduit());


        if (produit.getDispo() == 1) {
            convertView.setBackgroundColor(Color.rgb(147, 194, 6));
        } else if (produit.getDispo() == 2) {
            convertView.setBackgroundColor(Color.rgb(191, 10, 1));
        }




        return convertView;
    }



    static class ViewHolder {
        private TextView produit;

    }

}