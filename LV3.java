import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] V=new int[10]; //Velicinu arraya(vektora) prvo postavljamo na maksimalnu dozvoljenu
        int[][] matrica=new int[5][5];
        int odabir = 0,n,m;

        Scanner input=new Scanner(System.in); // za unos sa tipkovnice

        do{
            System.out.println("Unesite broj elemenata vektora V (između 2 i 10): ");
            n=input.nextInt(); // sljedeci sto se unese je n
        }while(n <2 || n >10);

        do{
            System.out.println("Unesite dimenziju kvadratne matrice (između 1 i 5): ");
            m=input.nextInt();
        }while(m <1 || m >5);
        //For petlja za vektor
        for(int i=0;i<n;i++){
            try {
                Scanner scan = new Scanner(System.in);
                //Vec je inicijaliziran scanner
                System.out.println("Unesite "+(i+1)+". element vektora: ");
                V[i] = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Niste unijeli broj,molimo ponovite unos: ");
            }
        }
        //FOR petlja za popunjavanje matrice
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++) {
                try {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Unesite element za matricu["+i+"]"+"["+j+"]");
                    matrica[i][j] = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Niste unijeli broj,molimo ponovite unos: ");
                }
            }
        }
        while(odabir!=-1){//Infinite while loop za switch
            System.out.println("//////////////////////////");
            System.out.println("1.Aritmeticka sredina sporedne dijagonale");
            System.out.println("2.Suma neparnih elemenata prvog retka i stupca matrice");
            System.out.println("3.Ispis svih brojeva na parnim indeksima vektora");
            System.out.println("4.Izlaz");
            System.out.println("/////////////////////////");
            odabir= input.nextInt();
            switch(odabir){
                case 1:
                    System.out.println("1.\n");
                    int brojac = 0;
                    int suma=0;
                    float aritmetickaSredina=0;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            if ((i + j) == (m - 1)) {
                                suma += matrica[i][j];
                                brojac++;
                            }
                        }
                    }
                    aritmetickaSredina=suma/brojac;
                    System.out.println("Aritmeticka sredina sporedne dijagonale iznosi: "+aritmetickaSredina+"\n");
                    break;
                case 2:
                    int sum=0;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i==0 || j==0) {
                                if(matrica[i][j]%2!=0){
                                    sum+=matrica[i][j];
                                }
                            }

                        }
                    }
                    System.out.println("Suma neparnih elemenata iznosi:"+sum);
                    break;
                case 3:
                    System.out.println("\n");
                    for (int i = 0; i <n; i++) {

                        if (i%2==0) {
                            continue;
                        }
                        System.out.println(V[i]);
                    }
                    break;
                case 4:
                    odabir=-1;
                    break;
                default:
                    break;

            }
        }



    }
}