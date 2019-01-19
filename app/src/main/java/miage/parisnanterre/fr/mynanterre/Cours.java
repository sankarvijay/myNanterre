package miage.parisnanterre.fr.mynanterre;

public class Cours {
    private String titre,description,matiere,niveau;

    public Cours() {
    }
    //constructeur
    public Cours(String titre, String description, String matiere, String niveau) {
        this.titre = titre;
        this.description = description;
        this.matiere = matiere;
        this.niveau=niveau;

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

}


