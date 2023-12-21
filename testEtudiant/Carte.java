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
        boolean plusGrand = false;
        if (this.valeur > c.valeur) {
            plusGrand = true;
        }
        return plusGrand;
    }

    public boolean avoirDiffDe10(Carte c) {
        boolean diff10 = false;
        if (c.valeur + 10 == this.valeur || c.valeur - 10 == this.valeur) {
            diff10 = true;
        }
        return diff10;
    }

}
