package classes;
import java.io.Serializable;
public  abstract class Piece implements Serializable {
    private int couleur;
    private String nom;
    private int id;
    public Piece(int laCouleur, String  leNom, int nouvelleId)
    {
        couleur = laCouleur;
        nom = leNom;
        id = nouvelleId;
    }

    public int getCouleur()
    {
        return couleur;
    }

    public String getNom()
    {
        return nom;
    }
    public int getId() {
        return id;
    }
}
