package miage.parisnanterre.fr.mynanterre.implem;

public class Entreprise {

    String logo , nom;

    public Entreprise(){}

    public Entreprise(String logo, String nom) {
        this.logo = logo;
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
