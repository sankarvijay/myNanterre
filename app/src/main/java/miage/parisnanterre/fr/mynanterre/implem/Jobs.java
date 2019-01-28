package miage.parisnanterre.fr.mynanterre.implem;

public class Jobs {


    private int image;
    private String texte;

    public Jobs(int image, String texte) {
        this.image = image;
        this.texte = texte;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
