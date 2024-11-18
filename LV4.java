//1.
import java.io.File;

public class MainZad1
{
    public static void main(String[] args)
    {
        File sysDisc = new File("C:\\Users\\student\\Desktop"); // unos oznake sistemskog diska
        for (File f : sysDisc.listFiles())
        {
            String type = "datoteka";
            if (f.isDirectory())
            {
                type = "direktorij";
            }
            System.out.println(f.getName() + " -> " + getConvertedName(f.getName()) + " -> " + type);
        }
    }

    private static String getConvertedName(String name)
    {
        if ((name.charAt(0) >= 'a' && name.charAt(0) <= 'n') || (name.charAt(0) >= 'A' && name.charAt(0) <= 'N'))
        {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        if ((name.charAt(0) >= 'o' && name.charAt(0) <= 'z') || (name.charAt(0) >= 'O' && name.charAt(0) <= 'Z'))
        {
            return name.toUpperCase();
        }
        return name;
    }

}

//2.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Zad2
{
    private static String filePath = "C:\\Users\\student\\Desktop\\studenti.ser";
    private static int brojStudenata = 2;

    public static void main(String[] args) throws IOException
    {
        Student[] studenti = new Student[brojStudenata];
        for (int i = 0; i < brojStudenata; i++)
        {
            studenti[i] = upisiStudenta();
        }

        serijalizirajStudente(studenti);

        Student[] deserijaliziraniStudenti = deserijalizirajStudente();

        System.out.println("Prosjek ocjena svih studenata: " + izracunajProsjekOcjena(deserijaliziraniStudenti));

    }

    private static void serijalizirajStudente(Student[] studenti)
    {
        ObjectOutputStream output = null;
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < brojStudenata; i++)
            {
                output.writeObject(studenti[i]);
            }

        }
        catch (IOException e)
        {
            System.out.println("Greška sa spremanjem u datoteku");
        }

        try
        {
            if (output != null)
            {
                output.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Greška sa zatvaranjem output-a");
        }

    }

    private static Student[] deserijalizirajStudente()
    {
        Student[] deserijaliziraniStudenti = new Student[brojStudenata];

        ObjectInputStream input = null;
        try
        {
            input = new ObjectInputStream(new FileInputStream(filePath));
            for (int i = 0; i < brojStudenata; i++)
            {
                deserijaliziraniStudenti[i] = (Student) input.readObject();
            }

        }
        catch (Exception e)
        {
            System.out.println("Greška sa ucitavanjem datoteke");
        }

        try
        {
            if (input != null)
            {
                input.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Greška sa zatvaranjem input-a");
        }

        return deserijaliziraniStudenti;
    }

    private static float izracunajProsjekOcjena(Student[] studenti)
    {
        float sumaProsjekaOcjena = 0;
        for (int i = 0; i < brojStudenata; i++)
        {
            sumaProsjekaOcjena += studenti[i].prosjecnaOcjena;
        }

        return sumaProsjekaOcjena / brojStudenata;
    }

    private static Student upisiStudenta()
    {
        Student student = new Student();
        Scanner s = new Scanner(System.in);

        System.out.println("Unesi maticni broj studenta");
        student.setMaticniBroj(s.nextInt());

        System.out.println("Unesi ime studenta");
        student.setIme(s.next());

        System.out.println("Unesi prezime studenta");
        student.setPrezime(s.next());

        System.out.println("Unesi fakultet studenta");
        student.setFakultet(s.next());

        System.out.println("Unesi smjer studenta");
        student.setSmjer(s.next());

        System.out.println("Unesi godinu studenta");
        student.setGodina(s.nextInt());

        System.out.println("Unesi prosjek ocjena studenta");
        student.setProsjecnaOcjena(s.nextFloat());

        return student;
    }
}

class Student implements Serializable
{
    int maticniBroj;
    String ime;
    String prezime;
    String fakultet;
    String smjer;
    int godina;
    float prosjecnaOcjena;

    public int getMaticniBroj()
    {
        return maticniBroj;
    }

    public void setMaticniBroj(int maticniBroj)
    {
        this.maticniBroj = maticniBroj;
    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getPrezime()
    {
        return prezime;
    }

    public void setPrezime(String prezime)
    {
        this.prezime = prezime;
    }

    public String getFakultet()
    {
        return fakultet;
    }

    public void setFakultet(String fakultet)
    {
        this.fakultet = fakultet;
    }

    public String getSmjer()
    {
        return smjer;
    }

    public void setSmjer(String smjer)
    {
        this.smjer = smjer;
    }

    public int getGodina()
    {
        return godina;
    }

    public void setGodina(int godina)
    {
        this.godina = godina;
    }

    public float getProsjecnaOcjena()
    {
        return prosjecnaOcjena;
    }

    public void setProsjecnaOcjena(float prosjecnaOcjena)
    {
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

}
