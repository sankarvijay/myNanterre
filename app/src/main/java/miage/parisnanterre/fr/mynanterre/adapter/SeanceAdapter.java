package miage.parisnanterre.fr.mynanterre.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;

import miage.parisnanterre.fr.mynanterre.implem.Inscription_sport;
import miage.parisnanterre.fr.mynanterre.implem.Seance;

public class SeanceAdapter extends RecyclerView.Adapter<SeanceAdapter.MyViewHolder> {

    private List<Seance> listeSeances;
    private Context mcon;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView numero;
        private TextView heure_d;
        private TextView heure_f;
        public TextView sport;
        public TextView lieu;


        public MyViewHolder(View view) {
            super(view);
            numero = (TextView) view.findViewById(R.id.numero);
            heure_d = (TextView) view.findViewById(R.id.heured);
            heure_f = (TextView) view.findViewById(R.id.heuref);
            sport = (TextView) view.findViewById(R.id.sport);
            lieu = (TextView) view.findViewById(R.id.lieu);

        }
    }

    public SeanceAdapter(List<Seance> listeSeances, Context context) {
        this.listeSeances = listeSeances;
        this.mcon = context;
    }


    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
        final String user = "u749839367_vijay";
        final String psw = "9IDCqTm8Lig2";
        Connection conn;

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ligne_seance, parent, false);

        Button insciption = (Button) itemView.findViewById(R.id.inscription);

        insciption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcon.startActivity(new Intent(mcon, Inscription_sport.class));

            }
        });

        TextView nbInscrit = (TextView) itemView.findViewById(R.id.inscrit);
        nbInscrit.setText("ok ");
        try {

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT count(*) AS rowcount FROM plannification_sport ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);
            rst.next();
            int count = rst.getInt("rowcount");
            System.out.println("Nb Inscrits : " + count);
            nbInscrit.setText(String.valueOf(count));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Seance seance = listeSeances.get(position);
        holder.numero.setText(seance.getNumero());

        holder.sport.setText(seance.getSport());
        holder.lieu.setText(seance.getLieu());
        holder.heure_d.setText(seance.getHeured().toString());
        holder.heure_f.setText(seance.getHeuref().toString());

    }

    @Override
    public int getItemCount() {
        return listeSeances.size();
    }
}
