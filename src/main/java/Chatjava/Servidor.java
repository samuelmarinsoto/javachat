package Chatjava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor{ 

    public static void main(String args[]){ 
        
        LinkedList<Integer> lista_puertos = new LinkedList<Integer>();
        
        try {
            ServerSocket server = new ServerSocket(5000);
            
            while(true){
                Socket serversocker =  server.accept();
                DataInputStream datos = new DataInputStream(serversocker.getInputStream());
                String mensajes = datos.readUTF();
                
                if (Objects.equals(String.valueOf(mensajes.charAt(0)), "0")){
                    mensajes = mensajes.substring(1, mensajes.length() );
                  	int puerto_final = Integer.parseInt(mensajes);
                    lista_puertos.add(puerto_final);
                    System.out.println("Conectado: " + puerto_final);
                }
                else { 
                    Socket mensajepuertos = null;
                    
                    for (int i = 0; i < lista_puertos.size(); i++) {
                    	System.out.println(lista_puertos.get(i));
                    	mensajepuertos = new Socket("127.0.0.1",lista_puertos.get(i));
                    	DataOutputStream out = new DataOutputStream(mensajepuertos.getOutputStream());
                    	out.writeUTF(mensajes);
                    	mensajepuertos.close();
                    }
                    System.out.println(mensajes);
                }   
            }   
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
