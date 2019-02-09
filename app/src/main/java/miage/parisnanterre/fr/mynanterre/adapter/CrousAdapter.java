package miage.parisnanterre.fr.mynanterre.adapter;


import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.Crous;

import miage.parisnanterre.fr.mynanterre.R;


public  class CrousAdapter extends RecyclerView.Adapter<CrousAdapter.MyViewHolder> {

    private List<Crous> listeCrous;




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView batiment;
        private TextView lieu;


        public MyViewHolder(View view) {
            super(view);
            batiment = (TextView) view.findViewById(R.id.batiment);
            lieu = (TextView) view.findViewById(R.id.lieu);

        }
    }


    public CrousAdapter(List<Crous> listeCrous) {
        this.listeCrous = listeCrous;
    }

    @Override
    @NonNull
    public CrousAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_crous, parent, false);


        return new CrousAdapter.MyViewHolder(itemView);
    }

    public Crous getItem(int position) {
        return listeCrous.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull CrousAdapter.MyViewHolder holder, int position) {
        Crous crous = listeCrous.get(position);
        holder.batiment.setText(crous.getBatiment());
        holder.lieu.setText(crous.getLieu());
        System.out.println("la frequentation est de : "+ crous.getFrequentation());
        if (crous.getFrequentation() == 3) {
            holder.itemView.setBackgroundColor(Color.rgb(255, 99, 85));
        } else if (crous.getFrequentation() == 2)  {
            holder.itemView.setBackgroundColor(Color.rgb(255,255,110));
        }
        else{
            holder.itemView.setBackgroundColor(Color.rgb(140,255,110));
        }

    }

    @Override
    public int getItemCount() {
        return listeCrous.size();
    }



    public long getItemId(int position) {
        return position;
    }
}