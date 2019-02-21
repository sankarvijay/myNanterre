package miage.parisnanterre.fr.mynanterre.implem;


import android.app.Activity;
import android.os.Bundle;

import java.sql.Time;

import miage.parisnanterre.fr.mynanterre.R;

public class Seance extends Activity {

    String sport, lieu;
    Time heured, heuref;
    int numero;

    public Seance() {

    }

    public Seance(Integer numero, Time heured, Time heuref, String sport, String lieu) {
        this.numero = numero;
        this.heured = this.heured;
        this.heuref = heuref;
        this.sport = sport;
        this.lieu = lieu;

    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Time getHeured() {
        return heured;
    }

    public void setHeured(Time heured) {
        this.heured = heured;
    }

    public Time getHeuref() {
        return heuref;
    }

    public void setHeuref(Time heuref) {
        this.heuref = heuref;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_seances);


    }

    @Override
    public String toString() {
        return "Seance{" +
                "numero='" + numero + '\'' +
                ", sport='" + sport + '\'' +
                ", lieu='" + lieu + '\'' +
                ", heured=" + heured +
                ", heuref=" + heuref +
                '}';
    }
}
