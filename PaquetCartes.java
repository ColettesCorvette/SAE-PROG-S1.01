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
        String res = "––––––––––––––––––––––––––––––––––\n";
        for (int i = 0; i < this.getNbCartes(); i++) {
            res += i + ". " + this.cartes[i] + "\n";
        }
        res += "––––––––––––––––––––––––––––––––––";
        return res;
    }
}
