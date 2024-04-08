public class PileCartes {
    /**
     * attributs de la classe PileCartes :
     *  - croissant (booléen vrai si la pile est croissante)
     *  - paquet (PaquetCartes)
     */
    private boolean croissant;
    private PaquetCartes paquet;

    /**
     * Constructeur de PileCartes
     * @param pCroissant boolean, vrai si la pile est croissante
     * @param max int, valeur de la plus grande carte et taille max de la pile
     */
    public PileCartes(boolean pCroissant, int max) {
        this.croissant = pCroissant;
        Carte[] pCartes = new Carte[1];
        if (pCroissant) {
            pCartes[0] = new Carte(1);
        } else {
            pCartes[0] = new Carte(max);
        }
        this.paquet = new PaquetCartes(pCartes);
    }

    /**
     * vérifie si la carte passée en paramètre est posable en haut de la pile
     * @param c Carte à ajouter
     * @return boolean, vrai si il est possible d'ajouter la carte
     */
    public boolean etrePosable(Carte c) {
        boolean posable = false;
        if ((this.croissant && c.etrePlusGrand(paquet.getDerniereCarte())) || 
            (! (this.croissant) && paquet.getDerniereCarte().etrePlusGrand(c)) || 
            (c.avoirDiffDe10(this.paquet.getDerniereCarte()))) {
                posable = true;
        }
        return posable;
    }

    /**
     * Pose la carte sur la pile et renvoie vrai si c'est possible
     * @param c Carte à ajouter sur la pile
     * @return boolean, vrai si la carte a pu être ajoutée
     */
    public boolean poserCarte(Carte c) {
        boolean posee = false;
        if (etrePosable(c)) {
            this.paquet.ajouterCarteFin(c);
            posee = true;
        }
        return posee;
    }

    /**
     * Permet d'afficher la pile de manière textuelle
     * @return String, affichage de la pile
     */
    public String toString() {
        String res = "";
        if (this.croissant) {
            res += "c";
        } else {
            res += "d";
        }
        //"c-c15-(4)"
        res += "-" + this.paquet.getDerniereCarte();
        res += "-(" + this.paquet.getNbCartes() + ")";
        return res;
    }

    /**
     * renvoie la dernière carte de la pile
     * @return Carte, dernière carte de la pile
     */
    public Carte getDerniereCarte() {
        return this.paquet.getDerniereCarte();
    }
}
