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

import miage.parisnanterre.fr.mynanterre.implem.Offre;
import miage.parisnanterre.fr.mynanterre.R;

public class OffreAdapter extends RecyclerView.Adapter<OffreAdapter.MyViewHolder> {

    private List<Offre> listeOffres;

    private Integer[] tab_images_pour_la_liste = {
            R.drawable.humensis,
            R.drawable.copytop,
            R.drawable.jellysmack,
            R.drawable.orange,
            R.drawable.bnp,
            R.drawable.accengage,
            R.drawable.armee,
            R.drawable.techvalley,
            R.drawable.stuart,
            R.drawable.lidl
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre;
        public TextView entreprise;
        public TextView datePublication;
        public TextView localisation;
        public TextView descriptif;
        private ImageView logo;

        public MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.titre);
            entreprise = (TextView) view.findViewById(R.id.entreprise);
            datePublication = (TextView) view.findViewById(R.id.datePublication);
            localisation = (TextView) view.findViewById(R.id.localisation);
            descriptif = (TextView) view.findViewById(R.id.descriptif);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }


    public OffreAdapter(List<Offre> listeOffres) {
        this.listeOffres = listeOffres;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_offres, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Offre offre = listeOffres.get(position);
        holder.titre.setText(offre.getTitre());
        holder.entreprise.setText(offre.getEntreprise());
        holder.datePublication.setText(offre.getDatePublication());
        holder.localisation.setText(offre.getLocalisation());
        holder.descriptif.setText(offre.getDescriptif());
        holder.logo.setImageResource(tab_images_pour_la_liste[position]);
    }

    @Override
    public int getItemCount() {
        return listeOffres.size();
    }
}