public class Carte{

    //declaration de l'attribut de la classe Carte
    private int valeur;
    
    /**
     * @param v 
     * 
     * declaration d'un contructeur qui construit une carte et prend la valeur 
     * 
     * de l'entier en parametre
     * 
     */
    public Carte(int v){

        this.valeur = v;

    }

    /**
     * 
     * @return 
     * 
     * getter qui renvoie l'entier valeur
     * 
     */
    public int getValeur(){
        return this.valeur;
    }

    /**
     * @param c
     * 
     * methode qui renvoie un booleen qui vaut true 
     * 
     * si et seulement si la valeur de la carte this est plus grande 
     * 
     * que la carte passee en parametre
     * 
     */
    public boolean etrePlusGrand(Carte c){


        if(this.valeur > c.valeur)
            return true;
        else 
            return false;
        
    }

    /**
     * 
     * @param c
     * @return
     * 
     * Methode qui retourne un booleen valant true si et seulement si
     * 
     * il y a une difference stricte de 10 entre la carte this et celle
     * 
     * passee en parametre 
     * 
     */
    public boolean avoirDiffDe10(Carte c){

    
        if(this.valeur+10 == c.valeur || this.valeur-10 == c.valeur)
            return true;
        else
            return false;

    }

    /**
     * @return
     * 
     * Methode toString permettant d'afficher la carte sous le format
     * 
     * c_num en utilisant "System.out.println(c);" et non son adresse 
     * 
     * son adresse mémoire
     * 
     */
    public String toString(){
        return "c" + this.valeur;
    }





















}