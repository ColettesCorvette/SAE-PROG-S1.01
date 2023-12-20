import java.util.Random;

public class PaquetCartes {
    private Carte[] cartes;

    public PaquetCartes() {
        this.cartes = new Carte[0];
    }

    public PaquetCartes(Carte[] paquet) {
        this.cartes = paquet;
    }

    public int getNbCartes() {
        return this.cartes.length;
    }

    public Carte getCarte(int place) {
        if (place < 0 || place > this.getNbCartes() - 1) {
            return null;
        } else {
            return this.cartes[place];
        }
    }

    public Carte getDerniereCarte() {
        if (this.etreVide()) {
            return null;
        } else {
            return this.cartes[getNbCartes() - 1];
        }
    }

    public boolean etreVide() {
        return (getNbCartes() == 0);
    }

    public void ajouterCarteFin(Carte nvlCarte) {
        int n = this.getNbCartes();
        Carte[] tempCartes = new Carte[n+1];
        for (int i = 0; i < n; i++) {
            tempCartes[i] = this.cartes[i];
        }
        tempCartes[n] = nvlCarte;
        this.cartes = tempCartes;
    }

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

    public String toString() {
        String res = "";
        for (int i = 0; i < this.getNbCartes(); i++) {
            res += i + "-" + this.cartes[i] + "\n";
        }
        return res;
    }

    public void remplir(int max) {
        Carte[] tab = new Carte[max - 2];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Carte(i + 2);
        }
        this.cartes = tab;
    }

    private Carte piocherHasard() {
        Random r = new Random();
        int i = r.nextInt(getNbCartes());
        return this.retirerCarte(i);
    }

    public void melangerPaquet() {
        Carte[] tab = new Carte[this.getNbCartes()];
        for (int i = 0; i < this.getNbCartes(); i++) {
            tab[i] = piocherHasard();
        }
        this.cartes = tab;
    }

    public Carte prendreCarteDessus() {
        if (etreVide()) {
            return null;
        } else {
            return this.retirerCarte(0);
        }
    }

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
