test
import Pas_Macka.Macka;
import Pas_Macka.Pas;

public class Test {
    public static void main(String[] args) {
        Macka Macka=new Macka(1,3.1,"Sijamska macka");  // parametri
        Pas Pas=new Pas(2,6.8,"Njemacki ovcar");

        Macka.OpisMacka();  // pozivi
        Pas.OpisPas();
    }
}


package Sisavac;

public class Sisavac{

    private int dob;   // dva privatna parametra
    private double tezina;

    public Sisavac() { //default konstruktor
        dob = 0;
        tezina = 0;
    }



     public int getDob() {
        return dob;
    } //get set metode

    public void setDob(int dob) {
        this.dob = dob;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }
}


package Pas_Macka;
import Sisavac.Sisavac;

public class Macka extends Sisavac {
    private String vrsta;

    public Macka(int dob, double tezina, String vrsta) {
        this.setDob(dob);
        this.setTezina(tezina);
        this.vrsta = vrsta;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public void OpisMacka() {
        System.out.println("Macka ima " +getDob()+  " godina , teska je " + getTezina()+ " kilograma i pasmina joj je "+vrsta);
    }
}


package Pas_Macka;
import Sisavac.Sisavac;

public class Pas extends Sisavac {
    private String vrsta;

    public Pas(int dob, double tezina, String vrsta) {
        this.setDob(dob);
        this.setTezina(tezina);
        this.vrsta = vrsta;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public void OpisPas() {
        System.out.println("Pas ima " +getDob()+ " godina, tezak je " + getTezina()+" kilograma i pasmina mu je "+vrsta);
    }

}
