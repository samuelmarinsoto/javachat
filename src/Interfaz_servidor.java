import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Interfaz_servidor extends JFrame implements ActionListener {

    JLabel label;

    String mensaje;

    String respuesta;

    JButton boton;

    JTextField texto;

    DataInputStream inS;
    DataOutputStream outS;




    Interfaz_servidor(String mesaje, DataInputStream in, DataOutputStream out){

        inS = in;
        outS = out;

        boton = new JButton("Enviar");
        boton.setBounds(100,10,200,70);
        boton.addActionListener(this);

        texto = new JTextField();
        texto.setPreferredSize(new Dimension(250,200));

        mensaje = mesaje;
        label = new JLabel();
        label.setText(mesaje);
        this.setTitle("Servidor");

        this.setLayout(new FlowLayout());
       this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this .add(label);
        this.add(texto);
        this.add(boton);







    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton){
            respuesta=texto.getText();
            try {
                outS.writeUTF(respuesta);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}



