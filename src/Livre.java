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

    /**
     * Création du getter getTitre
     * @return la valeur de l'attribut titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Création du setter setTitre
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Création du getter getAuteur
     * @return la valeur de l'attribut auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Création du setter setAuteur
     * @param auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    /**
     * Création du getter getResume
     * @return la valeur de l'attribut resume
     */
    public String getResume() {
        return resume;
    }

    /**
     * Création du setter setResume
     * @param resume
     */
    public void setResume(String resume) {
        this.resume = resume;
    }
    /**
     * Création du getter getColonne
     * @return la valeur de l'attribut colonne
     */
    public String getColonne() {
        return colonne;
    }

    /**
     * Création du setter setColonne
     * @param colonne
     */
    public void setColonne(String colonne) {
        this.colonne = colonne;
    }
    /**
     * Création du getter getRangee
     * @return la valeur de l'attribut rangee
     */
    public String getRangee() {
        return rangee;
    }

    /**
     * Création du setter setRangee
     * @param rangee
     */
    public void setRangee(String rangee) {
        this.rangee = rangee;
    }
    /**
     * Création du getter getParution
     * @return la valeur de l'attribut parution
     */
    public String getParution() {
        return parution;
    }

    /**
     * Création du setter setParution
     * @param parution
     */
    public void setParution(String parution) {
        this.parution = parution;
    }
    /**
     * Création du getter getObjLivre
     * @return le tableau d'objet ObjLivre
     */
    public Object[] getObjLivre() {
        return objLivre;
    }
}
