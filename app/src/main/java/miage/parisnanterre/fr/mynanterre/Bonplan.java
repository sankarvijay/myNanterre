package miage.parisnanterre.fr.mynanterre;

/**
 * Created by Sankar Vijay on 19/01/2019.
 */

public class BonPlan {
    private String titre, dateFin, enseigne, codePromo;
    private int logo;

    public BonPlan() {
    }

    //constructeur
    public BonPlan(int logo, String titre, String dateFin, String enseigne, String codePromo) {
        this.logo = logo;
        this.titre = titre;

        this.enseigne = enseigne;
        this.codePromo = codePromo;

        this.dateFin = dateFin;

    }

    //constructeur
    public BonPlan(int logo, String titre, String dateFin) {
        this.logo = logo;
        this.titre = titre;

        this.dateFin = dateFin;


    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
