package miage.parisnanterre.fr.mynanterre.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.Entreprise;
import miage.parisnanterre.fr.mynanterre.R;

public class EntrepriseAdapter extends RecyclerView.Adapter<EntrepriseAdapter.MyViewHolder> {

    private List<Entreprise> listeEntreprises;

    private Integer[] tab_images_pour_la_liste = {
            R.drawable.orange,
            R.drawable.aviva,
            R.drawable.edf,
            R.drawable.societegenerale,
            R.drawable.cgi

    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        private ImageView logo;
        public TextView commentaire;
        private RatingBar note;

        public MyViewHolder(View view) {
            super(view);
            nom = (TextView) view.findViewById(R.id.nom);
            logo = (ImageView) view.findViewById(R.id.logo);
            /*commentaire=(TextView) view.findViewById(R.id.commentaire);
            note =(RatingBar) view.findViewById(R.id.note);*/
        }
    }


    public EntrepriseAdapter(List<Entreprise> listeEntreprises) {
        this.listeEntreprises = listeEntreprises;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_entreprises, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Entreprise entreprise = listeEntreprises.get(position);
        holder.nom.setText(entreprise.getNom());
        holder.logo.setImageResource(tab_images_pour_la_liste[position]);
        //holder.commentaire.setText(entreprise.getCommentaire());
        //holder.note.setRating(entreprise.getNote());
    }

    @Override
    public int getItemCount() {
        return listeEntreprises.size();
    }
}