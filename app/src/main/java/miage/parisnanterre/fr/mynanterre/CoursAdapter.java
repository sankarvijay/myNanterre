package miage.parisnanterre.fr.mynanterre;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CoursAdapter extends RecyclerView.Adapter<CoursAdapter.MyViewHolder> {

    private List<Cours> listeCours;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre ,description,matiere,niveau;

        public MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.titre);
            description = (TextView) view.findViewById(R.id.description);
            matiere = (TextView) view.findViewById(R.id.matiere);
            niveau = (TextView) view.findViewById(R.id.niveau);
        }
    }


    public CoursAdapter(List<Cours> listeCours) {
        this.listeCours = listeCours;
    }

    @Override
    public CoursAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_cours, parent, false);

        return new CoursAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CoursAdapter.MyViewHolder holder, int position) {
        Cours cours = listeCours.get(position);

        holder.titre.setText(cours.getTitre());
        holder.description.setText(cours.getDescription());
        holder.niveau.setText(cours.getNiveau());
        holder.matiere.setText(cours.getMatiere());
    }

    @Override
    public int getItemCount() {
        return listeCours.size();
    }
}


