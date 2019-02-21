package miage.parisnanterre.fr.mynanterre.implem;

public class Crous {

    private String batiment;
    private String lieu;
    private String horaire;
    private String ventes;
    private int frequentation;
    private int id;

    Crous(int id, String batiment, String lieu, int frequentation) {
        this.batiment = batiment;
        this.id = id;
        this.lieu = lieu;
        this.frequentation = frequentation;
    }

    public String getBatiment() {
        return batiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFrequentation() {
        return frequentation;
    }

    public void setFrequentation(int frequentation) {
        this.frequentation = frequentation;
    }
}
