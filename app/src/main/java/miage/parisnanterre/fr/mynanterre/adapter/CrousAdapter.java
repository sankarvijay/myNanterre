package miage.parisnanterre.fr.mynanterre.adapter;

/**
 * Created by Sankar Vijay on 11/01/2019.
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.Crous;

import miage.parisnanterre.fr.mynanterre.R;

public class CrousAdapter extends RecyclerView.Adapter<CrousAdapter.MyViewHolder> {

    private List<Crous> listeCrous;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView batiment;
        public TextView lieu;


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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_crous, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Crous crous = listeCrous.get(position);
        holder.batiment.setText(crous.getBatiment());
        holder.lieu.setText(crous.getLieu());

    }

    @Override
    public int getItemCount() {
        return listeCrous.size();
    }
}