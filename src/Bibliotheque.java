import java.util.ArrayList;

public class Bibliotheque {

    ArrayList<Object[]> listLivre = new ArrayList<Object[]>();

    Object[][] donnee = {};

    public Bibliotheque() {
    }

    public void add(String name, String auteur, String resume, String colonne, String rangee, String parution){
        listLivre.add(new Livre(name, auteur, resume, colonne, rangee, parution).getObjLivre());
    }

    public ArrayList<Object[]> getListLivre() {
        return listLivre;
    }

    public Object[][] getDonnee() {
        return donnee;
    }
}
