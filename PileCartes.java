public class PileCartes {
    /**
     * attributs de la classe PileCartes :
     *  - croissant (booléen vrai si la pile est croissante)
     *  - paquet (PaquetCartes)
     */
    private boolean croissant;
    private PaquetCartes paquet;

    public PileCartes(boolean pCroissant, int max) {
        this.croissant = pCroissant;
        Carte[] pCartes = new Carte[max - 2];
        if (pCroissant) {
            pCartes[0] = new Carte(1);
        } else {
            pCartes[0] = new Carte(max);
        }
        this.paquet = new PaquetCartes(pCartes);
    }
}
