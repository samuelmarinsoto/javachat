
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;

        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;

        try {

            servidor = new ServerSocket(PORT);
            System .out.println("servidor iniciado");


            while (true){
                socket = servidor.accept();
                System.out.println("conectado");
                System.out.println("--------------------------------------------");

                in = new DataInputStream(socket.getInputStream());
                out=  new DataOutputStream(socket.getOutputStream());


                String mensaje = in.readUTF();
                new Interfaz_servidor(mensaje,in,out);

                System.out.println(mensaje);



//                out.writeUTF("pregunta");
                System.out.println("--------------------------------------------");
                System.out.println("desconetado");




//                socket.close();


            }


        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);


        }


    }




}

