import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;

public class TestPileCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 5.1
        PileCartes pile = new PileCartes(true,20);

        // question 5.2
        boolean res = pile.etrePosable(new Carte(15));

        // question 5.3
        boolean res2 = pile.poserCarte(new Carte(13));

        // question 5.5
        Carte c = pile.getDerniereCarte();

    }

    public void test_1_constructeur_croissant() {
        PileCartes pc = new PileCartes(true, 5);

        assertEquals("La carte devrait être 1", 1, pc.getDerniereCarte().getValeur());
    }

    public void test_2_constructeur_decroissant() {
        PileCartes pc = new PileCartes(false, 5);

        assertEquals("La carte devrait être 5", 5, pc.getDerniereCarte().getValeur());
    }

    public void test_3_etrePosable_croissant() {
        PileCartes pc = new PileCartes(true, 15);
        boolean b = pc.etrePosable(new Carte(1));
        boolean b1 = pc.etrePosable(new Carte(2));
        pc.poserCarte(new Carte(14));
        boolean b2 = pc.etrePosable(new Carte(4));

        assertEquals("La carte ne devrait pas être posable", false, b);
        assertEquals("La carte devrait être posable", true, b1);
        assertEquals("La carte devrait être posable", true, b2);
    }

    public void test_4_etrePosable_decroissant() {
        PileCartes pc = new PileCartes(false, 15);
        boolean b = pc.etrePosable(new Carte(15));
        boolean b1 = pc.etrePosable(new Carte(14));
        pc.poserCarte(new Carte(3));
        boolean b2 = pc.etrePosable(new Carte(13));

        assertEquals("La carte ne devrait pas être posable", false, b);
        assertEquals("La carte devrait être posable", true, b1);
        assertEquals("La carte devrait être posable", true, b2);
    }

    public void test_5_poserCarte_croissant() {
        PileCartes pc = new PileCartes(true, 15);
        
        boolean b = pc.poserCarte(new Carte(1));
        assertEquals("La carte 1 ne devrait pas être posable", false, b);
        assertEquals("La dernière carte ne devrait pas changer", 1, pc.getDerniereCarte().getValeur());

        boolean b1 = pc.poserCarte(new Carte(14));
        assertEquals("La carte 2 devrait être posable", true, b1);
        assertEquals("La dernière carte devrait changer", 14, pc.getDerniereCarte().getValeur());
        
        boolean b2 = pc.poserCarte(new Carte(4));
        assertEquals("La carte 11 devrait être posable", true, b2);
        assertEquals("La dernière carte devrait changer", 4, pc.getDerniereCarte().getValeur());
    }

    public void test_6_poserCarte_decroissant() {
        PileCartes pc = new PileCartes(false, 15);
        
        boolean b = pc.poserCarte(new Carte(15));
        assertEquals("La carte 15 ne devrait pas être posable", false, b);
        assertEquals("La dernière carte ne devrait pas changer", 15, pc.getDerniereCarte().getValeur());

        boolean b1 = pc.poserCarte(new Carte(3));
        assertEquals("La carte 14 devrait être posable", true, b1);
        assertEquals("La dernière carte devrait changer", 3, pc.getDerniereCarte().getValeur());
        
        boolean b2 = pc.poserCarte(new Carte(13));
        assertEquals("La carte 5 devrait être posable", true, b2);
        assertEquals("La dernière carte devrait changer", 13, pc.getDerniereCarte().getValeur());
    }

    public void test_7_toString() {
        PileCartes pc = new PileCartes(true, 15);
        boolean b1 = pc.poserCarte(new Carte(14));
        boolean b2 = pc.poserCarte(new Carte(4));
        String res = pc.toString();

        assertEquals("Le resultat ne correspond pas ", "c-c4-(3)", res);
    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }
}
