import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Interfaz extends JFrame implements ActionListener {
    JButton button;
    JTextField texto;
    JTextArea  areamensajes;
    DataInputStream inC;
    DataOutputStream outC;
    String mensaje;

    Interfaz(DataInputStream in, DataOutputStream out){

        inC = in;
        outC = out;




        texto = new JTextField();
        texto.setPreferredSize(new Dimension(250,70));
        texto.setBounds(20,30,250,70);
        areamensajes = new JTextArea();
        areamensajes.setPreferredSize(new Dimension(250,100));
        areamensajes.setEditable(false);

        button = new JButton("Enviar");
        button.setBounds(10,10,200,70);
        button.addActionListener(this);
        this.setTitle("Cliente");
        this.setLayout(new FlowLayout());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(texto);
        this.add(areamensajes);






    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            try {
                mensaje = texto.getText();
                outC.writeUTF(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }


    }


    public  void mostras(String respuesta){
        areamensajes.append(respuesta);

    }
}



