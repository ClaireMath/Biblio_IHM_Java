public class Livre {

    private String titre;
    private String auteur;
    private String resume;
    private int colonne;
    private int rangee;
    private int parution;
    Object[] objLivre;

    public Livre(String titre, String auteur, String resume, int colonne, int rangee, int parution) {
        this.titre = titre;
        this.auteur = auteur;
        this.resume = resume;
        this.colonne = colonne;
        this.rangee = rangee;
        this.parution = parution;
        this.objLivre = new Object[] {titre, auteur, resume, colonne, rangee, parution};
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

    public int getParution() {
        return parution;
    }

    public void setParution(int parution) {
        this.parution = parution;
    }

    public Object[] getObjLivre() {
        return objLivre;
    }
}
