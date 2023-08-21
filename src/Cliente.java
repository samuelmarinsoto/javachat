
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {


        final String HOST = "127.0.0.1";
        final int port = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket socket = new Socket(HOST,port);

            in = new DataInputStream(socket.getInputStream());
            out=  new DataOutputStream(socket.getOutputStream());

            Interfaz interfaz_c =new Interfaz(in,out);


            String mensaje = in.readUTF();

            interfaz_c.mostras(mensaje);



//            socket.close();


        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
