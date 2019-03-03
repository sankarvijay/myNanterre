package miage.parisnanterre.fr.mynanterre.implem;

/**
 * Created by Sankar Vijay on 28/02/2019.
 */
public class Produit {
    private int dispo;
    private String nomProduit;

    Produit(int dispo, String nomProduit) {
        this.dispo = dispo;
        this.nomProduit = nomProduit;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    @Override
    public String toString() {
        return "Produit : " + nomProduit +
                ", disponibilite : " + dispo;
    }
}
