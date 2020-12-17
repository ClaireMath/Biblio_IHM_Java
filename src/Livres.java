public class Livres {

    private String titre;
    private String auteur;
    private String resume;
    private int colonne;
    private int rangee;
    private String parution;

    public Livres(String titre, String auteur, String resume, int colonne, int rangee, String parution) {
        this.titre = titre;
        this.auteur = auteur;
        this.resume = resume;
        this.colonne = colonne;
        this.rangee = rangee;
        this.parution = parution;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getRangee() {
        return rangee;
    }

    public void setRangee(int rangee) {
        this.rangee = rangee;
    }

    public String getParution() {
        return parution;
    }

    public void setParution(String parution) {
        this.parution = parution;
    }
}
