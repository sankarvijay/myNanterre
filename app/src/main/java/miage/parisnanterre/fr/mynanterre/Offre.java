package miage.parisnanterre.fr.mynanterre;

/**
 * Created by Sankar Vijay on 09/01/2019.
 */
public class Offre {
    private String titre,contrat,localisation,descriptif,datePublication,entreprise;
    private int logo;
    public Offre() {
    }

    public Offre(int logo, String titre, String contrat, String localisation, String descriptif, String datePublication,String entreprise) {
        this.logo = logo;
        this.titre = titre;
        this.contrat = contrat;
        this.localisation = localisation;
        this.descriptif = descriptif;
        this.datePublication = datePublication;
        this.entreprise=entreprise;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
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
}