package miage.parisnanterre.fr.mynanterre;

/**
 * Created by Sankar Vijay on 19/01/2019.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BonPlanAdapter extends RecyclerView.Adapter<BonPlanAdapter.MyViewHolder> {


    private List<BonPlan> listeBonPlans;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre, dateFin, enseigne, codePromo;
        private ImageView logo;

        public MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.titre);
            dateFin = (TextView) view.findViewById(R.id.dateFin);
            logo = (ImageView) view.findViewById(R.id.logo);
            //enseigne = (TextView) view.findViewById(R.id.enseigne);
            //codePromo = (TextView) view.findViewById(R.id.codePromo);

        }
    }


    public BonPlanAdapter(List<BonPlan> listeBonPlans) {
        this.listeBonPlans = listeBonPlans;
    }

    @Override
    public BonPlanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_bonplans, parent, false);

        return new BonPlanAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BonPlanAdapter.MyViewHolder holder, int position) {
        BonPlan bonplan = listeBonPlans.get(position);
        holder.titre.setText(bonplan.getTitre());

        holder.dateFin.setText(bonplan.getDateFin());
        //holder.enseigne.setText(bonplan.getEnseigne());
        //holder.codePromo.setText(bonplan.getCodePromo());
        holder.logo.setImageResource(bonplan.getLogo());
    }

    @Override
    public int getItemCount() {
        return listeBonPlans.size();
    }
}
