import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        zad6();

    }

    public static void zad1() {
        System.out.println("    J    a  v      v  a");
        System.out.println("    J   aa    v   v   a");
        System.out.println(" J  J  aaaaa   V V  aaaaa");
        System.out.println("  JJ  a     a   V  a     a");

    }

    public static void zad2() {
        System.out.println("Hello");
        System.out.println("Ivana Ljubas");

    }

    public static void zad3() {

        int a, b, rez;
        a = 74;
        b = 36;

        rez = a + b;
        System.out.println(rez);

    }

    public static void zad4() {

        int a, b, rez;
        a = 50;
        b = 3;

        rez = a / b;
        System.out.println(rez);

    }

    public static void zad5() {
        int a, b, rez;
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite 1. broj");
        a = input.nextInt();

        System.out.println("Unesite 2. broj");
        b = input.nextInt();

        rez = a * b;
        System.out.println(rez);

    }

    public static void zad6() {
        int a, b, rez;
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite 1. broj");
        a = input.nextInt();

        System.out.println("Unesite 2. broj");
        b = input.nextInt();

        rez = a + b;
        System.out.println("Rezultat zbrajanja:" + rez);
        rez = a - b;
        System.out.println("Rezultat oduzimanja:" + rez);
        rez = a * b;
        System.out.println("Rezultat mnozenja:" + rez);
        rez = a / b;
        System.out.println("Rezultat djeljenja:" + rez);
        rez = a % b;
        System.out.println("Rezultat ostatka od djeljenja:" + rez);


    }
}