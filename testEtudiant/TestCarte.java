import static libtest.Lanceur.lancer;

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

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestCarte(),args);
    }
}
