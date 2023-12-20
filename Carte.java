/**
 * represente une carte trés simple juste avec une valeur
 */
class Carte{

    /** 
     * la valeur de la carte
     */
    private int valeur;

    /**
     * constructeur de carte
     * 
     * @param val valeur de la carte
     */
    public Carte (int val){
        this.valeur = val;
    }

    /**
     * getter
     */
    public int getValeur(){
        return (this.valeur);
    }

    public String toString() {
        return "c" + this.valeur;
    }

    public boolean etrePlusGrand(Carte c) {
        if (this.valeur > c.valeur) {
            return true;
        }
        return false;
    }

    public boolean avoirDiffDe10(Carte c) {
        if (c.valeur + 10 == this.valeur || c.valeur - 10 == this.valeur) {
            return true;
        }
        return false;
    }

}
