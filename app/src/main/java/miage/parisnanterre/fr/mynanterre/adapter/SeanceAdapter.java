package miage.parisnanterre.fr.mynanterre.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;

import miage.parisnanterre.fr.mynanterre.implem.Seance;

public class SeanceAdapter extends RecyclerView.Adapter<SeanceAdapter.MyViewHolder> {

    private List<Seance> listeSeances;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView prenom;
        public TextView heure_d;
        public TextView heure_f;
        public TextView sport;
        public TextView lieu;

        public MyViewHolder(View view) {
            super(view);
            nom = (TextView) view.findViewById(R.id.nom);
            prenom = (TextView) view.findViewById(R.id.prenom);
            heure_d = (TextView) view.findViewById(R.id.heured);
            heure_f = (TextView) view.findViewById(R.id.heuref);
            sport = (TextView) view.findViewById(R.id.sport);
            lieu = (TextView) view.findViewById(R.id.lieu);

        }
    }

    public SeanceAdapter(List<Seance> listeSeances) {
        this.listeSeances = listeSeances;
    }


    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_seance, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Seance seance = listeSeances.get(position);
        //System.out.println(seance.toString());
        holder.nom.setText(seance.getNom());
        holder.prenom.setText(seance.getPrenom());
        holder.sport.setText(seance.getSport());
        holder.lieu.setText(seance.getLieu());
        holder.heure_d.setText(seance.getHeure_d().toString());
        holder.heure_f.setText(seance.getHeure_f().toString());

    }

    @Override
    public int getItemCount() {
        return listeSeances.size();
    }
}
