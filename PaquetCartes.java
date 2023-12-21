import java.util.Random;

public class PaquetCartes {
    /**
     * attributs de la classe PaquetCartes : tableau de cartes
     */
    private Carte[] cartes;

    /**
     * Constructeur par défaut d'un paquet vide. 
     */
    public PaquetCartes() {
        this.cartes = new Carte[0];
    }

    /**
     * Constructeur d'un paquet à partir d'un tableau d'entiers
     * @param paquet tableau d'entiers
     */
    public PaquetCartes(int[] paquet) {
        this.cartes = new Carte[paquet.length];
        for (int i = 0; i < paquet.length; i++) {
            this.cartes[i] = new Carte(paquet[i]);
        }
    }

    /**
     * Constructeur d'un paquet à partir d'un tableau de Cartes
     * @param paquet tableau de cartes
     */
    public PaquetCartes(Carte[] paquet) {
        this.cartes = paquet;
    }

    /**
     * Renvoie le nombre de cartes dans le paquet
     * @return int, le nombre de cartes
     */
    public int getNbCartes() {
        return this.cartes.length;
    }

    /**
     * Recupère la carte à la place donnée en paramètre
     * @param place
     * @return Carte, la carte à la place demandée
     */
    public Carte getCarte(int place) {
        if (place < 0 || place > this.getNbCartes() - 1) {
            return null;
        } else {
            return this.cartes[place];
        }
    }

    /**
     * récupère la dernière carte du paquet 
     * @return Carte, la dernière carte du paquet
     */
    public Carte getDerniereCarte() {
        if (this.etreVide()) {
            return null;
        } else {
            return this.cartes[this.getNbCartes() - 1];
        }
    }

    /**
     * teste si le paquet est vide
     * @return boolean, vrai si le paquet est vide
     */
    public boolean etreVide() {
        return (this.getNbCartes() == 0);
    }

    /**
     * Ajoute une carte à la fin du paquet
     * @param nvlCarte Carte à ajouter
     */
    public void ajouterCarteFin(Carte nvlCarte) {
        int n = this.getNbCartes();
        Carte[] tempCartes = new Carte[n+1];
        for (int i = 0; i < n; i++) {
            tempCartes[i] = this.cartes[i];
        }
        tempCartes[n] = nvlCarte;
        this.cartes = tempCartes;
    }

    /**
     * Retire la carte à la place donnée en paramètre
     * @param place
     * @return Carte retirée
     */
    public Carte retirerCarte(int place) {
        if (place < 0 || place > this.getNbCartes() - 1) {
            return null;
        } else {
            int n = this.getNbCartes();
            Carte carteSup = this.cartes[place];
            Carte[] tempCartes = new Carte[n - 1];

            for (int i = 0; i < place; i++) {
                tempCartes[i] = this.cartes[i];
            }

            for (int i = place + 1; i < n; i++) {
                tempCartes[i - 1] = this.cartes[i];
            }

            this.cartes = tempCartes;
            return carteSup;
        }
    }

    /**
     * Renvoie le paquet de cartes sous forme textuelle
     * @return String, le paquet de cartes 
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < this.getNbCartes(); i++) {
            res += i + "-" + this.cartes[i] + "  ";
        }
        return res;
    }

    /**
     * créée un paquet de cartes allant de 2 à max - 1
     * @param max le numéro de la plus grande carte (exclue)
     */
    public void remplir(int max) {
        Carte[] tab = new Carte[max - 2];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Carte(i + 2);
        }
        this.cartes = tab;
    }

    /**
     * Pioche une carte au hasard dans la pile, fonction utilisée seulement dans melangerPaquet()
     * @return Carte
     */
    private Carte piocherHasard() {
        Random r = new Random();
        int i = r.nextInt(this.getNbCartes());
        return this.retirerCarte(i);
    }

    /**
     * Mélange le paquet de manière aléatoire
     */
    public void melangerPaquet() {
        Carte[] tab = new Carte[this.getNbCartes()];
        for (int i = 0; i < this.getNbCartes(); i++) {
            tab[i] = this.piocherHasard();
        }
        this.cartes = tab;
    }

    /**
     * Prend la carte en haut du paquet et la retire de celui-ci
     * @return carte récuperée
     */
    public Carte prendreCarteDessus() {
        if (this.etreVide()) {
            return null;
        } else {
            return this.retirerCarte(0);
        }
    }

    /**
     * insère une carte au bon endroit dans un paquet trié de manière croissante. 
     * @param c
     */
    public void insererTri(Carte c) {
        Carte[] tab = new Carte[this.getNbCartes() + 1];
        boolean insere = false;
        int i = 0;
        while (! insere && i < this.getNbCartes()) {
            if (c.etrePlusGrand(this.cartes[i])) {
                tab[i] = this.cartes[i];
            } else {
                tab[i] = c;
                insere = true;
            }
            i++;
        }
        for (int j = i; j < tab.length; j++) {
            tab[j] = this.cartes[j - 1];
        }
        this.cartes = tab;
    }
}
