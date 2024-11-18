package Zadatak1;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {

        String ip = "127.0.0.1";
        Integer port=8000;
        System.out.println ("Pokusavam se spojiti na ip:  " + ip + ":"+port);

        PrintWriter out=null;
        BufferedReader in=null;
        Socket echoSocket=null;

        try {
            echoSocket = new Socket(ip, port);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Ip: " + ip + " nije prepoznat");
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String text;
        System.out.println("Uspjesno spojeno sa servrom!");
        System.out.println("Input:");

        while ((text = stdIn.readLine()) != null) {
            out.println(text);
            System.out.println("[SERVER]: " + in.readLine());
            System.out.print ("Input: ");

            if (text.equals("quit"))

package Zadatak1;

import java.net.*;
import java.io.*;

public class TCPServer
{
    private static String[] badwords={"Psovka1","Psovka2","Psovka3","Psovka4","Uvreda1","Uvreda2","Uvreda3","Uvreda4"};
    private static String[] ids={"User1","User2","User3"};
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = null;

        try {
            server = new ServerSocket(8000);
        }
        catch (IOException e)
        {
            System.err.println("Port je zauzet!");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println ("Waiting for connection....");

        try {
            clientSocket = server.accept();
        }
        catch (IOException e)
        {
            System.exit(1);
        }

        System.out.println ("Connection successful");
        System.out.println ("Cekanje na input..");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));

        String input;
        String userid=getRandomId();

        while ((input = in.readLine()) != null)
        {
            System.out.println (userid+":" + input);
            String check;
            check=censor(input,badwords);

            out.println(check);
            if (input.equals("quit"))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        server.close();
    }

    public static String getRandomId() {
        String id = ids[(int) (Math.random() * ids.length)];
        return id;
    }

    static String censor(String text,String[] word)
    {

        String[] word_list = text.split("\\s+");
        String result = "";
        String stars = "";
        for(int i=0;i<word_list.length;i++){
            for(int j=0;j< word.length;j++){
                if(word_list[i].equals(word[j])){
                    for(int x=0;x<word_list[i].length();x++){
                        stars += '*';
                    }
                    word_list[i]=stars;
                }
            }
        }


        for (String i : word_list)
            result += i + ' ';

        return result;
    }
}

package Zadatak2;

import java.io.*;
import java.net.*;

class DatagramClient {
    public static void main(String args[]) throws Exception {
        String ip = "127.0.0.1";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(ip);
            System.out.println("Povezivanje na: " + IPAddress + ":8000");


            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            while (true) {
                System.out.print("Input:");
                String sentence = in.readLine();
                sendData = sentence.getBytes();

                System.out.println("Slanje paketa veličine: " + sendData.length + " bytes");

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8000);

                clientSocket.send(sendPacket);

                if (sentence.contains("quit")) {
                    clientSocket.close();
                    in.close();
                    System.exit(1);
                }

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("Cekanje za povratni paket...");
                clientSocket.setSoTimeout(10000);

                try {
                    clientSocket.receive(receivePacket);
                    String stdOut = new String(receivePacket.getData());

                    InetAddress returnIPAddress = receivePacket.getAddress();

                    int port = receivePacket.getPort();

                    System.out.println("Server: " + returnIPAddress + ":" + port);

                    System.out.println("[SERVER]: " + stdOut);


                } catch (SocketTimeoutException ste) {
                    System.out.println("Paket izgubljen!");
                }

            }
        } catch (UnknownHostException e) {
            System.err.println("Ip: " + ip + " nije prepoznat");
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}

package Zadatak2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class DatagramServer {

    private static String[] badwords = {"Psovka1", "Psovka2", "Psovka3", "Psovka4", "Uvreda1", "Uvreda2", "Uvreda3", "Uvreda4"};
    private static String[] ids = {"User1", "User2", "User3"};

    public static void main(String args[]) throws Exception {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8000);

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            String userid = getRandomId();

            while (true) {

                receiveData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("Cekanje na paket...");

                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());

                if (sentence.contains("quit")) {
                    serverSocket.close();
                    System.exit(1);
                }

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                String check;
                check = censor(sentence, badwords);

                System.out.println(userid + ": " + check);
                sendData = check.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);


            }

        } catch (SocketException ex) {
            System.out.println("Port 8000 je zauzet.");
            System.exit(1);
        }

    }

    public static String getRandomId() {
        String id = ids[(int) (Math.random() * ids.length)];
        return id;
    }

    static String censor(String text, String[] word) {

        char[] test1=text.toCharArray();
        String result = "";
        String stars = "";
        int flag=0;
        for(int i=0;i<text.length();i++){
            if(test1[i]!='\0'){
                flag=i;
            }
        };
        String testnew=text.substring(0,1024+flag+1-1024);
        String[] word_list = testnew.split("\\s+");

        for (int i = 0; i < word_list.length; i++) {
            for (int j = 0; j < word.length; j++) {
                if (word_list[i].contains(word[j])) {
                    for (int x = 0; x < word_list[i].length(); x++) {
                        stars += '*';
                    }
                    word_list[i] = stars;
                }
            }
        }


        for (String i : word_list)
            result += i + ' ';
        return result;
    }
}
