package miage.parisnanterre.fr.mynanterre.implem;

public class Entreprise {

    private String nom, commentaire;
    private String logo;
    private float note;

    public Entreprise() {
    }

    //entreprise mais on a  pas encore les avis
    public Entreprise(String logo, String nom) {
        this.logo = logo;
        this.nom = nom;
        this.commentaire = commentaire;
    }

    public Entreprise(String logo, String nom, String commentaire, float note) {
        this.logo = logo;
        this.nom = nom;
        this.commentaire = commentaire;
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public float getNote() {
        return note;
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
