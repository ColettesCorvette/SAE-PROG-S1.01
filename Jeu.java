import java.util.Scanner;


public class Jeu {
    /**
     * attributs de la classe jeu
     */
    //main du joueur et pioche des cartes restantes
    private PaquetCartes main, pioche;
    //Quatre piles du jeu
    private PileCartes[] piles;

    /**
     * Constructeur d'un objet jeu à partir du maximum
     * @param max int, valeur de la carte max
     */
    public Jeu(int max){
        
        this.piles = new PileCartes[4];

        for (int i = 0; i < 2; i++) {
            this.piles[i] = new PileCartes(true, max);
        }
        for (int i = 2; i < 4; i++) {
            this.piles[i] = new PileCartes(false, max);
        }

        this.pioche = new PaquetCartes();
        this.pioche.remplir(max);        
        this.pioche.melangerPaquet();

        this.main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            this.main.insererTri(this.pioche.prendreCarteDessus());
        }
    }

    /**
     * @param paq
     * 
     * Constructeur d'un objet jeu à partir d'un autre paquet existant
     */
    public Jeu(PaquetCartes paq){
        
        for (int i = 0; i < 2; i++) {
            this.piles[i] = new PileCartes(true, paq.getNbCartes() + 2);
        }
        for (int i = 2; i < 4; i++) {
            this.piles[i] = new PileCartes(false, paq.getNbCartes() + 2);
        }

        this.pioche=paq;

        this.pioche.melangerPaquet();

        this.main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            this.main.insererTri(this.pioche.prendreCarteDessus());
        }            
    }

    
    /**
     * 
     * Methodes getteurs 
     */
    public PaquetCartes getMain(){
        return this.main;
    }

    public PaquetCartes getPioche(){
        return this.pioche;
    }
    
    public PileCartes[] getPiles(){
        return this.piles;
    }

    /**
     * renvoie l'état du jeu sous la forme : 
     * ################################################
     * - PILE 0 : c-c1(1)
     * - PILE 1 : c-c1(1)
     * - PILE 2 : d-c100(1)
     * - PILE 3 : d-c100(1)
     * ################################################
     * Reste 90 cartes dans la pioche
     * ################################################
     * Main du joueur :
     * 0-c9 1-c24 2-c28 3-c42 4-c44 5-c51 6-c55 7-c60
     * ################################################
     * @return String
     */
    public String toString() {
        String res = "################################################\n";
        for (int i = 0; i < 4; i++) {
            res += "- PILE " + i + " : " + this.piles[i] + "\n";
        }
        res += "################################################\n";
        res += "Reste " + this.pioche.getNbCartes() + " cartes dans la pioche\n";
        res += "################################################\n";
        res += "Main du joueur :\n";
        res += this.main;
        res += "\n################################################";
        return res;
    }

    /**
     * Permet de jouer une carte dans une pile, si c'est possible
     * @param indice int, indice de la carte à jouer
     * @param numPile int, indice de la pile où jouer
     * @return boolean, vrai si il est possible de jouer la carte
     */
    public boolean jouerCarte(int indice, int numPile) {
        boolean b = this.piles[numPile].poserCarte(main.getCarte(indice));
        this.main.retirerCarte(indice);
        return b;
    }

    /**
     * vérifie si la partie est finie
     * @return int, 0 si on peut encore jouer, 1 si le jouer a gagné et -1 si le jouer a perdu. 
     */
    public int etreFini() {
        int res = 0;
        if ((this.pioche.etreVide() && this.main.etreVide())) {
            res = 1;
        } else {
            int nbCartePosables = 0;
            for (int i = 0; i < this.main.getNbCartes(); i++) {
                for (int j = 0; j < 4; j++) {
                    if (this.piles[j].etrePosable(this.main.getCarte(i))){
                        nbCartePosables++;
                    }
                }
            }
            if ((this.pioche.etreVide() && nbCartePosables < 1) || (! this.pioche.etreVide() && nbCartePosables < 2)) {
                res = -1;
            }
        }
        return res;
    }

    /**
     * complète la main du joueur avec une nouvelle carte insérée au bon endroit
     */
    public void completerMain() {
        this.main.insererTri(this.pioche.prendreCarteDessus());
    }

    /**
     * lance une partie
     */
    public void lancerJeu() {
        while (this.etreFini() == 0) { // Tant qu'il est possible de jouer
            Scanner sc = new Scanner(System.in);
            
            if (this.pioche.etreVide()) {
                System.out.println(this); // Afficher l'état du jeu
                System.out.print("Carte à jouer (0-7) :\n > ");
                int c = sc.nextInt(); // Le joueur entre la carte qu'il va jouer
                System.out.print("Pile où jouer (0-3) :\n > ");
                int p = sc.nextInt(); // Le joueur entre la pile où il va jouer
                if (piles[p].etrePosable(main.getCarte(c))) {
                    this.jouerCarte(c, p);
                } else {
                    System.out.println("\nImpossible de poser cette carte ici. \n");
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    System.out.println(this); // Afficher l'état du jeu
                    System.out.print("Carte à jouer (0-7) :\n > ");
                    int c = sc.nextInt(); // Le joueur entre la carte qu'il va jouer
                    System.out.print("Pile où jouer (0-3) :\n > ");
                    int p = sc.nextInt(); // Le joueur entre la pile où il va jouer
                    if (piles[p].etrePosable(main.getCarte(c))) {
                        if (this.jouerCarte(c, p)) {
                            this.completerMain();
                        } 
                    } else {
                        System.out.println("\n/!\\Impossible de poser cette carte ici. /!\\\n");
                    }
                }
            }
        }
        
        if (this.etreFini() == 1) {
            System.out.println("C'est gagné !");
        } else {
            System.out.println("C'est perdu :(");
        }

    }

}