import java.util.ArrayList;

public class Bibliotheque {

    ArrayList<Object[]> listLivre = new ArrayList<Object[]>();

    Object[][] donnee = {
            {"Coucou", "Coucou", "Hello", 5, 2, "2009"}
    };

    public Bibliotheque() {
        /*Array myBooks[][] = {};*/

    }
    void add(String name, String auteur, String resume, int colonne, int rangee, String parution){
        listLivre.add(new Livres(name, auteur, resume, colonne, rangee, parution).getObjLivre());
    }

    public ArrayList<Object[]> getListLivre() {
        return listLivre;
    }

    public Object[][] getDonnee() {
        return donnee;
    }
}
