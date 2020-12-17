import java.util.ArrayList;

public class Bibliotheque {

    ArrayList<Object[]> listLivre = new ArrayList<Object[]>();

    Object[][] donnee = {{"Harry Potter", "J.K Rowling", "Voldemort meurt", 5, 3, 2009}};

    public Bibliotheque() {
    }

    public void add(String name, String auteur, String resume, int colonne, int rangee, int parution){
        listLivre.add(new Livre(name, auteur, resume, colonne, rangee, parution).getObjLivre());
    }

    public ArrayList<Object[]> getListLivre() {
        return listLivre;
    }

    public Object[][] getDonnee() {
        return donnee;
    }
}
