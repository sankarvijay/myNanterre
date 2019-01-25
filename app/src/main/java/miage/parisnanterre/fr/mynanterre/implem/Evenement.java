package miage.parisnanterre.fr.mynanterre.implem;

public class Evenement {

    private String titre, descriptif, datePublication;
    private int logo;

    public Evenement(){
    }

    public Evenement(int logo, String titre, String descriptif, String datePublication) {
        this.logo = logo;
        this.titre = titre;
        this.descriptif = descriptif;
        this.datePublication = datePublication;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
