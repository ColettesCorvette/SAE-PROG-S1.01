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
    public boolean etrePosasble(Carte c) {
        boolean posable = false;
        if ((this.croissant && c.etrePlusGrand(paquet.getDerniereCarte())) || 
            (! this.croissant && ! c.etrePlusGrand(paquet.getDerniereCarte()))) {
                posable = true;
        }
        return posable;
    }

    
}
