package miage.parisnanterre.fr.mynanterre;

/**
 * Created by Sankar Vijay on 11/01/2019.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OffreAdapter extends RecyclerView.Adapter<OffreAdapter.MyViewHolder> {

    private List<Offre> listeOffres;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre, entreprise, datePublication, localisation, descriptif;
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_offres, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Offre offre = listeOffres.get(position);
        holder.titre.setText(offre.getTitre());
        holder.entreprise.setText(offre.getEntreprise());
        holder.datePublication.setText(offre.getDatePublication());
        holder.localisation.setText(offre.getLocalisation());
        holder.descriptif.setText(offre.getDescriptif());
        holder.logo.setImageResource(offre.getLogo());
    }

    @Override
    public int getItemCount() {
        return listeOffres.size();
    }
}