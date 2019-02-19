package miage.parisnanterre.fr.mynanterre.implem;


import android.app.Activity;
import android.os.Bundle;

import java.sql.Time;

import miage.parisnanterre.fr.mynanterre.R;

public class Seance extends Activity {

    String  sport, lieu;
    Time heure_d, heure_f;
    int numero;

    public Seance() {

    }

    public Seance(Integer numero, Time heure_d, Time heure_f, String sport, String lieu) {
        this.numero=numero;
        this.heure_d = heure_d;
        this.heure_f = heure_f;
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
        return heure_d;
    }

    public void setHeured(Time heure_d) {
        this.heure_d = heure_d;
    }

    public Time getHeuref() {
        return heure_f;
    }

    public void setHeuref(Time heure_f) {
        this.heure_f = heure_f;
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
                ", heure_d=" + heure_d +
                ", heure_f=" + heure_f +
                '}';
    }
}
