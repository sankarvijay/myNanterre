package miage.parisnanterre.fr.mynanterre.implem;

/**
 * Created by Sankar Vijay on 09/01/2019.
 */
public class Offre {
    private String titre;
    private String contrat;
    private String localisation;
    private String descriptif;
    private String datePublication;
    private String entreprise;
    private String logo;

    public Offre() {
    }

    public Offre(String logo, String titre, String contrat, String localisation, String descriptif, String datePublication, String entreprise) {
        this.logo = logo;
        this.titre = titre;
        this.contrat = contrat;
        this.localisation = localisation;
        this.descriptif = descriptif;
        this.datePublication = datePublication;
        this.entreprise = entreprise;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
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