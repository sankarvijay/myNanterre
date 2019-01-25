package miage.parisnanterre.fr.mynanterre.adapter;


import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.Evenement;
import miage.parisnanterre.fr.mynanterre.R;

public class EvenementAdapter extends RecyclerView.Adapter<EvenementAdapter.MyViewHolder> {

    private List<Evenement> listeEvenements;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre;
        public TextView datePublication;
        public TextView descriptif;
        private ImageView logo;

        MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.titre);
            datePublication = (TextView) view.findViewById(R.id.datePublication);
            descriptif = (TextView) view.findViewById(R.id.descriptif);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }

    public EvenementAdapter(List<Evenement> listeEvenements) {
        this.listeEvenements = listeEvenements;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_evenement, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Evenement evenement = listeEvenements.get(position);
        holder.titre.setText(evenement.getTitre());
        holder.datePublication.setText(evenement.getDatePublication());
        holder.descriptif.setText(evenement.getDescriptif());
        holder.logo.setImageResource(evenement.getLogo());
    }

    @Override
    public int getItemCount() {
        return listeEvenements.size();
    }

}
