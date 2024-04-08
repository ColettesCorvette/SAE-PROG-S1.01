import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;

public class TestJeu {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 6.2
        Jeu jeu = new Jeu(50);

        // question 6.1
        PaquetCartes p = jeu.getMain();
        PaquetCartes pioche = jeu.getPioche();
        PileCartes[] piles = jeu.getPiles();

        // question 6.3
        String s = jeu.toString();

        // question 6.4
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10);
        Jeu jeu2 = new Jeu(paquet);

        // question 6.5
        boolean res = jeu.jouerCarte(0,0);

        // question 6.6
        int fin = jeu.etreFini();
    }

    public void test_1_constructeur_max() {
        Jeu j = new Jeu(20);

        PaquetCartes main = j.getMain();
        PaquetCartes pioche = j.getPioche();
        PileCartes[] piles = j.getPiles();

        assertEquals("La main devrait contenir 8 cartes", 8, main.getNbCartes());
        assertEquals("La pioche devrait contenir max - 10 cartes", 10, pioche.getNbCartes());
        assertEquals("Il devrait y avoir 4 piles", 4, piles.length);
        assertEquals("La pile doit être croissante, commencer à 1 et avoir 1 carte", "c-c1-(1)", piles[0].toString());
        assertEquals("La pile doit être croissante, commencer à 1 et avoir 1 carte", "c-c1-(1)", piles[1].toString());
        assertEquals("La pile doit être décroissante, commencer à 20 (max) et avoir 1 carte", "d-c20-(1)", piles[2].toString());
        assertEquals("La pile doit être décroissante, commencer à 20 (max) et avoir 1 carte", "d-c20-(1)", piles[3].toString());
    }

    public void test_2_constructeur_paquet() {
        PaquetCartes p = new PaquetCartes();
        p.remplir(20);
        Jeu j = new Jeu(p);

        PaquetCartes main = j.getMain();
        PaquetCartes pioche = j.getPioche();
        PileCartes[] piles = j.getPiles();

        assertEquals("La main devrait contenir 8 cartes", 8, main.getNbCartes());
        assertEquals("La pioche devrait contenir max - 10 cartes", 10, pioche.getNbCartes());
        assertEquals("Il devrait y avoir 4 piles", 4, piles.length);
        assertEquals("La pile doit être croissante, commencer à 1 et avoir 1 carte", "c-c1-(1)", piles[0].toString());
        assertEquals("La pile doit être croissante, commencer à 1 et avoir 1 carte", "c-c1-(1)", piles[1].toString());
        assertEquals("La pile doit être décroissante, commencer à 20 (max) et avoir 1 carte", "d-c20-(1)", piles[2].toString());
        assertEquals("La pile doit être décroissante, commencer à 20 (max) et avoir 1 carte", "d-c20-(1)", piles[3].toString());
    }

    public void test_3_toString() {
    /*  renvoie l'état du jeu sous la forme : 
        ################################################\n
        - PILE 0 : c-c1(1)\n
        - PILE 1 : c-c1(1)\n
        - PILE 2 : d-c100(1)\n
        - PILE 3 : d-c100(1)\n
        ################################################\n
        Reste 90 cartes dans la pioche\n
        ################################################\n
        Main du joueur :\n
        0-c9 1-c24 2-c28 3-c42 4-c44 5-c51 6-c55 7-c60\n
        ################################################*/
        
        Jeu j = new Jeu(20);

        assertEquals("L'affichage est mauvais","################################################\n" + 
                "        - PILE 0 : c-c1(1)\n" + 
                "        - PILE 1 : c-c1(1)\n" + 
                "        - PILE 2 : d-c100(1)\n" + 
                "        - PILE 3 : d-c100(1)\n" + 
                "        ################################################\n" + 
                "        Reste 90 cartes dans la pioche\n" + 
                "        ################################################\n" + 
                "        Main du joueur :\n" + 
                "        0-c9 1-c24 2-c28 3-c42 4-c44 5-c51 6-c55 7-c60\n" + 
                "        ################################################", j.toString());
    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestJeu(),args);
    }
}
