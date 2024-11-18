package Zadatak1;

public class Test
{
    public static void main(String[] args)
    {
        Raketa R1 = new Raketa("Raketa1", "1");
        Raketa R2 = new Raketa("Raketa2", "2");
        Raketa R3 = new Raketa("Raketa3", "3");

        R1.start();
        R2.start();
        R3.start();
    }
}
package Zadatak1;

public class LansirnaRampa
{
    public void lansiraj()
    {
        for (int i = 10; i >= 0; i--)
        {
            System.out.println(i);
        }
    }
}
package Zadatak1;

public class Raketa extends Thread
{
    public String ime;
    public String lansirnaRampa;

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getLansirnaRampa()
    {
        return lansirnaRampa;
    }

    public void setLansirnaRampa(String lansirnaRampa)
    {
        lansirnaRampa = lansirnaRampa;
    }

    public Raketa(String ime, String lansirnaRampa)
    {
        this.ime = ime;
        lansirnaRampa = lansirnaRampa;
    }
    public void run()
    {
        System.out.println("\n\n" + this.ime);
        System.out.println("Pocetak lansiranja");
        LansirnaRampa LR = new LansirnaRampa();
        LR.lansiraj();
        System.out.println(this.ime + "\nPolijetanje");
    }
}
package Zadatak2;

public class LansirnaRampa {
    public void lansiraj() {
        System.out.println("Lansiranje");
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
package Zadatak2;

public class Raketa implements Runnable {
    public String ime;
    private LansirnaRampa lrampa;

    public Raketa(String ime, LansirnaRampa lrampa) {
        this.ime = ime;
        this.lrampa = lrampa;
    }

    public void run() {
        System.out.println("\n\n" + this.ime);
        lrampa.lansiraj();
    }
}
package Zadatak2;

public class Test {
    public static void main(String[] args) {
        LansirnaRampa lrampa = new LansirnaRampa();

        Raketa R1 = new Raketa("Raketa 1 ", lrampa);
        Raketa R2 = new Raketa("Raketa 2", lrampa);
        Raketa R3 = new Raketa("Raketa 3", lrampa);

        new Thread(R1).start();
        new Thread(R2).start();
        new Thread(R3).start();
    }
}
package Zadatak3;

public class LansirnaRampa {
    public synchronized void lansiraj() {
        System.out.println("Lansiranje");
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }
    }
package Zadatak3;

public class Raketa implements Runnable {
    public String ime;
    private LansirnaRampa lrampa;

    public Raketa(String ime, LansirnaRampa lrampa) {
        this.ime = ime;
        this.lrampa = lrampa;
    }

    public void run() {
        System.out.println("\n\n" + this.ime);
        lrampa.lansiraj();
    }
}
package Zadatak3;

public class Test {
    public static void main(String[] args) {
        LansirnaRampa lrampa = new LansirnaRampa();

        Raketa R1 = new Raketa("Raketa 1 ", lrampa);
        Raketa R2 = new Raketa("Raketa 2", lrampa);
        Raketa R3 = new Raketa("Raketa 3", lrampa);

        new Thread(R1).start();
        new Thread(R2).start();
        new Thread(R3).start();
    }
}