import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;

public class TestPaquetCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes() {
        // Question 4.1
        Carte[] tabC = {new Carte(10), new Carte(20)};
        PaquetCartes paq = new PaquetCartes(tabC);
        paq.ajouterCarteFin(new Carte(25));
        paq.retirerCarte(0);

        // Question 4.2
        PaquetCartes paq2 = new PaquetCartes();

        // Question 4.3
        paq2.remplir(20);

        // Question 4.4
        int tabInt[] = {10,20,30,40,50};
        PaquetCartes paq3 = new PaquetCartes(tabInt);

        // Question 4.5
        Carte c = paq.getCarte(0);
        Carte c2 = paq.getDerniereCarte();
        int nb = paq.getNbCartes();
        boolean vide = paq.etreVide();

        // question 4.7
        paq.melangerPaquet();

        // question  4.8
        paq.insererTri(new Carte(23));

        // question  4.9
        Carte c3 = paq.prendreCarteDessus();

    }

    public void test_1_verifieConstructeurVide(){
        
        PaquetCartes paq1 = new PaquetCartes();

        int l = paq1.getNbCartes();

        //On teste si le constructeur instancie bien un tableau vide
        assertEquals("Le paquet de carte doit être vide par défaut",0,l);

    }

    public void test_2_verifieConstructeurParam(){
        Carte[] tabC = new Carte[2];
        tabC[0]= new Carte(1);
        tabC[1]= new Carte(2);

        PaquetCartes paq1 = new PaquetCartes(tabC);

        int l = paq1.getNbCartes();

        //On verifie le constructeur avec parametre
        assertEquals("Le paquet devrait avoir 2 cartes",2,l);
    }

    
    public void test_3_ajouterCarteFin(){

        Carte[] tabC = new Carte[2];
        tabC[0]= new Carte(2);
        tabC[1]= new Carte(4);
        PaquetCartes paq1 = new PaquetCartes(tabC);

        Carte c = new Carte(6);

        paq1.ajouterCarteFin(c);

        // On verifie que le paquet a ete agrandi et que la carte a bien ete ajoutee a la fin
        assertEquals("La carte doit être à la fin",c,paq1.getDerniereCarte());
        assertEquals("le paquet devrait etre plus grand de 1",3, paq1.getNbCartes());


    }

    public void test_4_ajouterCarteFin_vide(){

        Carte[] tabC = new Carte[0];

        PaquetCartes paq1 = new PaquetCartes(tabC);

        Carte c = new Carte(1);

        paq1.ajouterCarteFin(c);

        //On verifie si la taille du paquet augmente et que la carte ajoutee est la bonne
        assertEquals("La taille devrait etre de 1",1, paq1.getNbCartes());
        assertEquals("La carte inseree devrait la premier",c, paq1.getDerniereCarte());



    }

    public void test_5_retirerCarte(){

        Carte[] tabC = new Carte[2];
        tabC[0]=new Carte(1);
        tabC[1]= new Carte(2);
        PaquetCartes pq1 = new PaquetCartes(tabC);

        pq1.retirerCarte(1);

        //On teste si la taille du paquet est reduite de 1 et que la carte retiree est la bonne
        assertEquals("La doit du paquet devrait être 1",1,pq1.getNbCartes());
        assertEquals("La carte retiree n'est pas la bonne",tabC[0],pq1.getDerniereCarte() );

    }

    public void test_6_toString(){

        Carte[] tabC = {new Carte(1),new Carte(2),new Carte(3),new Carte(4)};

        PaquetCartes paq1 = new PaquetCartes(tabC);

        //On verifie que la methode toString renvoie le format attendu
        assertEquals("la methode n'affiche le bon resultat","0-c1 1-c2 2-c3 3-c4",paq1.toString());
    

    }

    public void test_7_melangerPaquet(){
        
        Carte[] tabC = new Carte[5];
        tabC[0]= new Carte(1);
        tabC[1]= new Carte(2);
        tabC[2]= new Carte(3);
        tabC[3]= new Carte(4);
        tabC[4]= new Carte(5);

        PaquetCartes paq1 = new PaquetCartes(tabC);

        paq1.melangerPaquet();

        //On a teste si la taille du paquet demeurre le meme apres avoir melange le paquet de cartes
        //A noter que si l'assertEquals (pas fourni ici) qui verifie l'egalite de l'indice avec la valeur changee echoue, 
        //c'est le signe que la methode fontion
        assertEquals("la taille n'est pas la meme",5, paq1.getNbCartes());



    }

    public void test_8_insererTri(){

        Carte[] tabC = new Carte[3];
        tabC[0]= new Carte(12);
        tabC[1]= new Carte(32);
        tabC[2]= new Carte(45);

    
        PaquetCartes paq1 = new PaquetCartes(tabC);
        Carte c = new Carte(23);

        paq1.insererTri(c);

        //On teste si la methode de tri a l'insertion fonctionne, en verifiant si la taille augmente et la valeur
        assertEquals("Le paquet devrait etre plus grand 1",4,paq1.getNbCartes());
        assertEquals("La carte n'est pas bien placee",c,paq1.getCarte(1));


    }

    public void test_9_prendreCarteDessus(){

        Carte[] tabC = new Carte[3];
        tabC[0]= new Carte(1);
        tabC[1]= new Carte(2);
        tabC[2]= new Carte(3);

        PaquetCartes paq1 = new PaquetCartes(tabC);

        paq1.prendreCarteDessus();

        //On verifie que la carte a l'indice 0 est retiree du paquet et que sa taille diminue 
        assertEquals("La carte n'a pas ete retiree",2,paq1.getNbCartes());
        assertEquals("La premiere carte n'a pas ete retiree",tabC[1], paq1.getCarte(0));


    }

    public void test_10_prendreCarteDessus_vide(){

        Carte[] tabC = new Carte[0];

        PaquetCartes paq1 = new PaquetCartes(tabC);

        paq1.prendreCarteDessus();

        //On verifie que rien ne se passe lorsque le paquet est deja vide
        assertEquals("Il ne devrait pas y avoir de carte a prendre",null, paq1.getCarte(0));
        assertEquals("La taille devrait etre de 0",0, paq1.getNbCartes());

    }

    public void test_11_insererTri_Debut(){
        Carte[] tabC = new Carte[3];
        tabC[0]= new Carte(12);
        tabC[1]= new Carte(32);
        tabC[2]= new Carte(45);

    
        PaquetCartes paq1 = new PaquetCartes(tabC);
        Carte c = new Carte(5);

        paq1.insererTri(c);

        //On verifie l'insertion d'une carte au debut
        assertEquals("Le paquet devrait etre plus grand 1",4,paq1.getNbCartes());
        assertEquals("La carte n'est pas bien placee",c,paq1.getCarte(0));


    }

    public void test_12_insererTri_Fin(){
        Carte[] tabC = new Carte[3];
        tabC[0]= new Carte(12);
        tabC[1]= new Carte(32);
        tabC[2]= new Carte(45);

    
        PaquetCartes paq1 = new PaquetCartes(tabC);
        Carte c = new Carte(56);

        paq1.insererTri(c);

        //On verifie l'insertion d'une carte a la fin
        assertEquals("Le paquet devrait etre plus grand 1",4,paq1.getNbCartes());
        assertEquals("La carte n'est pas bien placee",c,paq1.getCarte(3));


    }

    public void test_13_insererTri_Vide(){

        Carte[] tabC = new Carte[0];
        
    
        PaquetCartes paq1 = new PaquetCartes(tabC);
        Carte c = new Carte(4);

        paq1.insererTri(c);

        //On verifie l'insertion d'une carte lorsque le paquet est vide
        assertEquals("Le paquet devrait etre plus grand 1",1,paq1.getNbCartes());
        assertEquals("La carte n'est pas bien placee",c,paq1.getCarte(0));


    }
    

    /**
     * lancement des tests
     */
    public static void main(String args[]) {
        lancer(new TestPaquetCartes(), args);
    }
}
