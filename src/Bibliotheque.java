import java.util.ArrayList;

public class Bibliotheque {

    private ArrayList<Object[]> listLivre = new ArrayList<Object[]>();

    private Object[][] donnee = {};


    public Bibliotheque() {
    }

    /**
     * Déclaration de la méthode add, comme c'est une méthode, elle ne renvoie rien => d'où le pot clef : void
     * @param name
     * @param auteur
     * @param resume
     * @param colonne
     * @param rangee
     * @param parution
     */
    public void add(String name, String auteur, String resume, String colonne, String rangee, String parution){
        listLivre.add(new Livre(name, auteur, resume, colonne, rangee, parution).getObjLivre());
    }

    /**
     * Création d'un getter
     * @return la liste des livres
     */
    public ArrayList<Object[]> getListLivre() {
        return listLivre;
    }

    /**
     * Création d'un getter
     * @return le tableau d'objets donnee;
     */
    public Object[][] getDonnee() {
        return donnee;
    }
}
