public class Livre {

    private String titre;
    private String auteur;
    private String resume;
    private String colonne;
    private String rangee;
    private String parution;
    private Object[] objLivre;

    public Livre(String titre, String auteur, String resume, String colonne, String rangee, String parution) {
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

    public String getColonne() {
        return colonne;
    }

    public void setColonne(String colonne) {
        this.colonne = colonne;
    }

    public String getRangee() {
        return rangee;
    }

    public void setRangee(String rangee) {
        this.rangee = rangee;
    }

    public String getParution() {
        return parution;
    }

    public void setParution(String parution) {
        this.parution = parution;
    }

    public Object[] getObjLivre() {
        return objLivre;
    }
}
