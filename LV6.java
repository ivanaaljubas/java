//2. zadatak

package Zadatak2;
import java.lang.*;

public class Direktor extends Zaposlenik {

    public void radi(){
        System.out.println("Odlucujem");
    }

    public Direktor(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }


}

package Zadatak2;

public class Tajnica extends Zaposlenik {
    public void radi(){
        System.out.println("Dogovaram");
    }

    public Tajnica(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }

}

package Zadatak2;


public class Test {
    public static void main(String[] args) {
        Zaposlenik D=new Direktor("Petar","Magdic","1");
        Zaposlenik T=new Tajnica("Marija","Horvat","2");
        Zaposlenik V=new Vozac("Ivan","Ivanovic","3");

        D.predstaviSe(D);
        D.radi();
        System.out.println("\n");

        T.predstaviSe(T);
        T.radi();
        System.out.println("\n");

        V.predstaviSe(V);
        V.radi();

    }
}
package Zadatak2;

public class Vozac extends Zaposlenik{

    public void radi(){
        System.out.println("Vozim");
    }

    public Vozac(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }

}
package Zadatak2;

public abstract class Zaposlenik {
    private String ID;
    private String Ime;
    private String Prezime;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public void predstaviSe(Zaposlenik objekt){

        String name= objekt.getClass().getSimpleName();
        System.out.println(name);
        System.out.println(Ime+" "+Prezime+" "+ID);
    }

    public abstract void radi();


}


//3. zad
package Zadatak3;

public class Direktor implements Zaposlenik {

    private String ID;
    private String Ime;
    private String Prezime;

    public Direktor(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    @Override
    public void predstaviSe(){
        String name= this.getClass().getSimpleName();
        System.out.println(name);
        System.out.println(Ime+" "+Prezime+" "+ID);
    }

    public void radi(){
        System.out.println("Odlucujem");
    }

}

package Zadatak3;

class Tajnica implements Zaposlenik {

    private String ID;
    private String Ime;
    private String Prezime;

    public Tajnica(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    @Override
    public void predstaviSe(){
        String name= this.getClass().getSimpleName();
        System.out.println(name);
        System.out.println(Ime+" "+Prezime+" "+ID);
    }

    public void radi() {
        System.out.println("Dogovaram");
    }

}
package Zadatak3;


public class Test {
    public static void main(String[] args) {

        Direktor D=new Direktor("Petar","Magdic","1");
        Tajnica T=new Tajnica("Marija","Horvat","2");
        Vozac V=new Vozac("Ivan","Ivanovic","3");

        D.predstaviSe();
        D.radi();
        System.out.println("\n");

        T.predstaviSe();
        T.radi();
        System.out.println("\n");

        V.predstaviSe();
        V.radi();
        System.out.println("\n");
    }
}
package Zadatak3;

public class Vozac implements Zaposlenik {

    private String ID;
    private String Ime;
    private String Prezime;

    public Vozac(String ime,String prezime,String ID) {
        setIme(ime);
        setPrezime(prezime);
        setID(ID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    @Override
    public void predstaviSe(){
        String name= this.getClass().getSimpleName();
        System.out.println(name);
        System.out.println(Ime+" "+Prezime+" "+ID);
    }

    public void radi(){
        System.out.println("Vozim");
    }

}
package Zadatak3;

public interface Zaposlenik {

    void predstaviSe();
    void radi();

}