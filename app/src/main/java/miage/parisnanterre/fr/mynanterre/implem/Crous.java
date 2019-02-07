package miage.parisnanterre.fr.mynanterre.implem;

public class Crous {

    private String batiment;
    private String lieu;
    private String horaire;
    private String ventes;
    private String frequentation;

    public Crous(String batiment, String lieu) {
        this.batiment = batiment;
        this.lieu = lieu;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getVentes() {
        return ventes;
    }

    public void setVentes(String ventes) {
        this.ventes = ventes;
    }

    public String getFrequentation() {
        return frequentation;
    }

    public void setFrequentation(String frequentation) {
        this.frequentation = frequentation;
    }
}
