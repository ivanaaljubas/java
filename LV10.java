package Zadatak1;


import java.util.Scanner;

public class Test {
    public static final int Number = 5;
    public static void main(String args[]){

        int brojac = 0;
        int inputNumber;
        System.out.println("Unesite broj: ");

        do {
            Scanner s = new Scanner(System.in);

            inputNumber = s.nextInt();

            if (inputNumber > Number) {
                System.out.println("Uneseni broj je veci, pokusaj ponovo: ");
                brojac++;
            } else if (inputNumber < Number) {
                System.out.println("Uneseni broj je manji, pokusaj ponovo: ");
                brojac++;
            }
        }
        while (inputNumber != Number) ;

        System.out.println("Bravo, pogodio si zadani broj. Trebalo ti je: " + (brojac+1) + " pokusaja.");
    }
}

package Zadatak2i3;

public class Lastavica extends Ptica {

    @Override
    public void glasajSe(){
        System.out.println(ime+" = Ovako se glasa lastavica");
    }
}
package Zadatak2i3;
public class Ptica implements Zivotinja{

    String ime;

    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime= ime;
    }

    @Override
    public void glasajSe() {
        System.out.println(ime+" = Ovako se glasa ptica");
    }
}
package Zadatak2i3;

public class Test {

    public static void main(String args[]) {

        Ptica []pticaArray;
        Lastavica []lastavicaArray;

        Ptica ptica = new Ptica();
        Lastavica lastavica = new Lastavica();

        ptica.setIme("Pticica");
        ptica.glasajSe();
        lastavica.setIme("lasta");
        lastavica.glasajSe();
        System.out.println("");

        pticaArray= new Ptica[2];
        lastavicaArray = new Lastavica[2];

        for (int i = 0; i<2; i++){
            pticaArray [i] = new Ptica();
            lastavicaArray [i] = new Lastavica();
            pticaArray [i].setIme("ptica"+(i+1));
            lastavicaArray [i].setIme("lastavica"+(i+1));
            pticaArray [i].glasajSe();
            lastavicaArray [i].glasajSe();
        }
    }
}
package Zadatak2i3;

interface Zivotinja{

    void setIme(String ime);
    String getIme();
    void glasajSe();

}
package Zadatak4;

import java.util.Scanner;

public class TestAutomobila {

    private String naziv;
    private float potrosioGoriva;
    private float prijedeniPut;

    public TestAutomobila(String naziv, float potrosioGoriva, float prijedeniPut){
        this.naziv = naziv;
        this.potrosioGoriva = potrosioGoriva;
        this.prijedeniPut = prijedeniPut;
    }

    public String getNaziv(){
        return naziv;
    }

    public float izracunajPotrosnju(){

        return potrosioGoriva/(prijedeniPut/100);
    }

}

package Zadatak4;

public class UsporedbaPotrosnje {

    public static void main(String args[]) {

        TestAutomobila auto1 = new TestAutomobila("Folcika", 45.3f, 570.1f);
        TestAutomobila auto2 = new TestAutomobila("Reno", 50.1f, 560.7f);

        usporedi(auto1, auto2);
    }

    public static void usporedi(TestAutomobila auto1, TestAutomobila auto2) {

        float potrosnjaNa100km1 = auto1.izracunajPotrosnju();
        float potrosnjaNa100km2 = auto2.izracunajPotrosnju();

        System.out.println(auto1.getNaziv()+" ima potrosnju: "+ potrosnjaNa100km1+" l/100km");
        System.out.println(auto2.getNaziv()+" ima potrosnju: "+ potrosnjaNa100km2+" l/100km");

        if (auto1.izracunajPotrosnju() < auto2.izracunajPotrosnju()) {
            System.out.println(auto1.getNaziv()+" je stedljiviji :)");
        } else {
            System.out.println(auto2.getNaziv()+" je stedljiviji :)");
        }


    }
}
package Zadatak5;

import java.util.Scanner;

public class Matrica {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int M;

        System.out.println("Unesite broj u intervalu [2,10]:");
        do {
            M = s.nextInt();
        } while (M < 2 || M > 10);
        //System.out.println("Uneseni broj je: "+M);

        //Scanner sc = new Scanner(System.in);
        int [][]matrica = new int[M][M];
        System.out.println("Unesite brojeve u matricu: ");
        for(int i=0; i<M; i++) {
            for (int j = 0; j < M; j++) {
                matrica[i][j] = s.nextInt();
            }
        }

        for(int i=0; i<M; i++){
            Nit n = new Nit(matrica[i], i);
            n.start();
        }


        for(int i=0; i<M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrica[i][j] + "");
            }
            System.out.println();
        }
    }

}
package Zadatak5;

public class Nit extends Thread {

    private int[] redak;
    int brojPokrenuteNiti;
    public Nit(int[] redak, int brojPokrenuteNiti) {

        this.redak = redak;
        this.brojPokrenuteNiti=brojPokrenuteNiti;

    }


    public void run() {

        int najveciBroj = redak[0];
        for (int i = 1; i < redak.length; i++) {
            if (redak[i] > najveciBroj) {
                najveciBroj = redak[i];
            }
        }
        System.out.println("Nit: "+brojPokrenuteNiti+" je zavrsila s radom, najveci broj retka je: " + najveciBroj);
    }

}