//1. 
package paket;

public class Zarulja {

    private boolean Stanje;

    public Zarulja(){  // konstruktor koji postavlja stanje u FALSE
        Stanje = false;
    }

    public void pritisniPrekidac() { //provjera stanja
        Stanje = !Stanje;
    }

    public void provjeri(){
        if(Stanje){
            System.out.println("Svijetli.");
        }else{
            System.out.println("Mrak je.");
        }
    }

    public static void main(String[] args) {

        Zarulja osram = new Zarulja();

        osram.pritisniPrekidac();
        osram.provjeri();

        osram.pritisniPrekidac();
        osram.provjeri();

        osram.pritisniPrekidac();
        osram.provjeri();

    }

}

//2. 
package paket;

public class Zaposlenik {  // klasa

    private int staz;
    private int starost;
    private int placa;

    public Zaposlenik(int staz, int starost, int placa){ //konstruktor

        this.staz = staz;
        this.starost = starost;
        this.placa = placa;

    }

    public int getStaz(){ // pristupne metode
        return staz;
    }

    public int getStarost(){
        return starost;
    }
    public int getPlaca() {
        return placa;
    }

    public void setStaz(int staz){ // metode s kojima se mogu promijeniti podatkovni clanovi
        this.staz = staz;
    }

    public void setStarost(int starost){
        this.starost = starost;
    }


    public void setPlaca(int placa) {
        this.placa = placa;
    }

    //metoda 1
    public double izracunajZaradu(){ //ne prima nikakve parametre
        return staz * placa * 12;
    }

    //metoda 2
    public static double izracunajZaradu(Zaposlenik ivana) {
        return ivana.getStaz() * ivana.getPlaca() * 12;
    }

    public static void main(String[] args) {
        Zaposlenik ivana = new Zaposlenik(3, 24, 5200);

        System.out.println("Ukupna zarada zaposlenika (izračun unutar objekta): " + ivana.izracunajZaradu());
        System.out.println("Ukupna zarada zaposlenika (izračun unutar statičke metode): " + Zaposlenik.izracunajZaradu(ivana));
    }

}

//3.

package paket;

public class Test {
    public static void main(String[] args) {
        // Testiranje klase Zarulja
        Zarulja osramZarulja = new Zarulja();
        osramZarulja.pritisniPrekidac();
        osramZarulja.provjeri();

        // Testiranje klase Zaposlenik
        Zaposlenik ivana = new Zaposlenik(3, 24, 5200);
        System.out.println("Ukupna zarada zaposlenika: " + ivana.izracunajZaradu());
        System.out.println("Ukupna zarada zaposlenika: " + Zaposlenik.izracunajZaradu(ivana));
    }
}