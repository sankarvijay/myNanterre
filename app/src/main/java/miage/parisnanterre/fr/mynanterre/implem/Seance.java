package miage.parisnanterre.fr.mynanterre.implem;


import android.app.Activity;
import android.os.Bundle;

import java.sql.Time;

import miage.parisnanterre.fr.mynanterre.R;

public class Seance extends Activity {

    String nom, prenom, sport, lieu;
    Time heure_d, heure_f;


    public Seance() {

    }

    public Seance(String nom, String prenom, Time heure_d, Time heure_f, String sport, String lieu) {
        this.nom = nom;
        this.prenom = prenom;
        this.heure_d = heure_d;
        this.heure_f = heure_f;
        this.sport = sport;
        this.lieu = lieu;

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Time getHeure_d() {
        return heure_d;
    }

    public void setHeure_d(Time heure_d) {
        this.heure_d = heure_d;
    }

    public Time getHeure_f() {
        return heure_f;
    }

    public void setHeure_f(Time heure_f) {
        this.heure_f = heure_f;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_seances);


    }

    @Override
    public String toString() {
        return "Seance{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sport='" + sport + '\'' +
                ", lieu='" + lieu + '\'' +
                ", heure_d=" + heure_d +
                ", heure_f=" + heure_f +
                '}';
    }
}
