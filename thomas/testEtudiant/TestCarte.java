import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;

public class TestCarte {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        Carte c = new Carte(10);
        Carte c2 = new Carte(20);

        int v = c.getValeur();
        String s = c.toString();

        boolean res = c.etrePlusGrand(c2);
        boolean diff = c.avoirDiffDe10(c2);
    }

    public void test_1_verifiePlusGrand(){

        /*
         * Preparation des donnees
         */
    
        Carte c = new Carte(10);
        Carte c1 = new Carte(5);

        boolean res = c.etrePlusGrand(c1);

        /*
         * On teste si la valeur de c est bien superieur a la carte c1 passee en parametre
         */

        assertEquals("la carte this doit être plus grande", true, res);

    }

    public void test_2_verifiePlusPetit(){

        /*
         * Preparation des donnees
         */

        Carte c = new Carte(5);
        Carte c1 = new Carte(10);

        boolean res = c.etrePlusGrand(c1);

        /*
         * On teste si la valeur de c est bien inferieure a la carte c1 passee en parametre
         */

         assertEquals("la carte this doit être plus petite", false, res);

    }

    public void test_3_verifieMoins10_1(){

        /*
         * Preparation des donnees
         */

        Carte c = new Carte(1);
        Carte c1 = new Carte(10);

        boolean res = c.avoirDiffDe10(c1);

        /*
         * On verifie s'il y a un ecart de 10 par rapport a la carte c
         */
        assertEquals("La difference n'est pas de 10", false, res);

    }

    public void test_4_verifieMoins10_2(){

        /*
         * Preparation des donnees
         */

        Carte c = new Carte(10);
        Carte c1 = new Carte(1);

        boolean res = c.avoirDiffDe10(c1);

        assertEquals("La difference n'est pas de 10", false, res);

    }

     public void test_5_verifiePlus10(){

        /*
         * Preparation des donnees
         */

        Carte c = new Carte(0);
        Carte c1 = new Carte(10);

        boolean res = c.avoirDiffDe10(c1);

        assertEquals("La difference n'est pas de 10", true, res);

    }

     public void test_6_verifieMoins10(){

        /*
         * Preparation des donnees
         */

        Carte c = new Carte(20);
        Carte c1 = new Carte(10);

        boolean res = c.avoirDiffDe10(c1);

        assertEquals("La difference n'est pas de 10", true, res);

    }

    public void test_7_String(){
        Carte c = new Carte(2);

        assertEquals("n'affiche pas le bon format","c2",c.toString());
        
    }


    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestCarte(),args);
    }
}
