/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Chatjava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa el cliente.
 * 
 */
public class Cliente extends javax.swing.JFrame implements Runnable{

    Socket socket;
    /**
     * Crea un hilo al construir la clase.
     */
    public Cliente() {
        initComponents();
        Thread hilo = new Thread(this);
        hilo.start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre_cliente = new javax.swing.JLabel();
        txt_mensaje = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Campos_textoC = new javax.swing.JTextArea();
        emoji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre_cliente.setText("CLIENTE");

        txt_mensaje.setText(" ");
        txt_mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mensajeActionPerformed(evt);
            }
        });

        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        Campos_textoC.setEditable(false);
        Campos_textoC.setColumns(20);
        Campos_textoC.setRows(5);
        jScrollPane1.setViewportView(Campos_textoC);

        emoji.setText("emoji");
        emoji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emojiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emoji, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(nombre_cliente)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(nombre_cliente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emoji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mensajeActionPerformed
    /**
     * Botton de enviar. Crea un socket que se conecta al servidor, y envia el 
     * texto que esta en el JTextField, y luego cierra el socket.
     * 
     */
    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        try {
            
            Socket socket = new Socket("127.0.0.1",5000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(nombre_cliente.getText()+": "+txt_mensaje.getText());
            socket.close();
            
           
        }
        catch(Exception ex){
            System.out.println(ex);
        
        }
    }//GEN-LAST:event_btn_enviarActionPerformed
    /**
     * Boton de emoji. Crea un socket que se conecta al servidor, envia una carita feliz,
     * y luego cierra el socket.
     * @param evt parte de interfaz, ignorar
     * @throws IOException
     */
    private void emojiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emojiActionPerformed
        try {
            Socket socket = new Socket("127.0.0.1",5000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("cliente: "+"😀");
            socket.close();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_emojiActionPerformed

    /**
     * Funcion main. Invoka el resto del codigo para inicializar la interfaz
     * @param args
     * 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Campos_textoC;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton emoji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre_cliente;
    private javax.swing.JTextField txt_mensaje;
    // End of variables declaration//GEN-END:variables
    /**
     * Funcion principal. Le asigna un numero aleatoreo al cliente para diferenciarlo, y 
     * abre un socket conectado al servidor para leer los mensajes que le manden y mostrarlos en pantallas.
     * @throws Exception
     */
    @Override
    public void run() {
        
        try {
            Random random = new Random();
            int numero_cliente = random.nextInt(100) + 1;
            nombre_cliente.setText("cliente: "+numero_cliente);
            int numero_port =  random.nextInt(5000) + 5000;
            ServerSocket server =new ServerSocket(numero_port);
             
            String numero_mensaje = String.valueOf("0"+numero_port);
            
            Socket socket = new Socket("127.0.0.1",5000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF( numero_mensaje);
            socket.close();
            
            
            while(true){
                Socket serversocker =  server.accept();
                DataInputStream datos = new DataInputStream(serversocker.getInputStream());
                String mensajes = datos.readUTF();
                Campos_textoC.append("\n"+"servidor: "+mensajes);
            
            
            }
            
        } catch (Exception e) {
        
        
        System.out.println(e);}
        
    }
}
