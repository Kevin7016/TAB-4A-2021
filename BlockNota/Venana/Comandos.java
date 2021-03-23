package Venana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Comandos extends JFrame implements ActionListener{
    
	
        public Comandos() {
        this.init();
        this.setSize(405, 450);
        this.setVisible(true);
    }
       
	public void init(){
            //Arreglo
	    array = new ArrayList<>();
            //booleano
            presionado = false;
            
            
		//Creo 5 botones y los añado a mi objeto JFrame
		boton1 = new JButton("Aceptar");
		boton2 = new JButton("Borrar");
		boton3 = new JButton("Color");
		boton4 = new JButton("Guardar");
		boton5 = new JButton("Abrir");
                boton6 = new JButton("Comillas");
                boton7 = new JButton("Tamaño");
                boton8 = new JButton("Salir");
                //texto y area de texto
                lbl_msg = new Label("Introduzca el Texto en el campo superior de la ventana:");
                txt_in = new TextField (40);
                txt_result = new TextArea();
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
                add(boton6);
                add(boton7);
                add(boton8);
                this.setLayout(new FlowLayout());
                this.add(lbl_msg, FlowLayout.CENTER);
                this.add(txt_in, FlowLayout.CENTER);
                this.add(boton1, FlowLayout.CENTER);
                this.add(txt_result, FlowLayout.CENTER);
                this.add(boton2, FlowLayout.LEFT);
                this.add(boton3,FlowLayout.LEFT);
                this.add(boton4,FlowLayout.LEFT);
                this.add(boton5,FlowLayout.LEFT);
                this.add(boton6,FlowLayout.LEFT);
                this.add(boton7,FlowLayout.LEFT);
                this.add(boton8,FlowLayout.CENTER);
		//Añado los botones al ActionListener
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
                boton6.addActionListener(this);
                boton7.addActionListener(this);
                boton8.addActionListener(this);

        }
       public void reiniciar(){//metodo para reiniciar contador
        cont = 0;
        } 
	
       
	@Override
	public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1) {//funcion boton aceptar y eliminar 
            String texto = txt_in.getText();
            if (texto.equals("|SUMAR|")) { 
                if (array.size() > 0) {
                    Integer i = 0;
                    for(Integer n: array) {
                        i = i + n;
                    }
                    texto = txt_in.getText() + (" " + i.toString());
                }
            } else {
                try{
                    Integer i = Integer.parseInt(texto);
                    array.add(i);
                    }catch(Exception a) {}
            }
            
            txt_result.append(texto + "\n");
        }
        if (e.getSource() == boton2) {
            txt_result.setText("");
            txt_in.setText("");
            array.clear();
        }
        presionado = !presionado;
        
        if (e.getSource() == boton3){//funcion boton color
            cont++;
            if (cont<7){
            if (cont==1){
                txt_result.setForeground(Color.green);
            }
            if (cont==2){
                txt_result.setForeground(Color.orange);
            }
            if (cont==3){
                txt_result.setForeground(Color.blue);
            }
            if (cont==4){
                txt_result.setForeground(Color.black);
            }
            if (cont==5){
                txt_result.setForeground(Color.pink);
            }
            if (cont==6){
                txt_result.setForeground(Color.red);
            }
            }else{
            reiniciar();
            } 
        }//jvfbvjvv
        
        if (e.getSource() == boton4){//funcion boton 4 guardar
            try {
                 JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
                  archivo.showSaveDialog(this);
             if (archivo.getSelectedFile() != null) {
                    try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
                      guardado.write(txt_result.getText());
                 JOptionPane.showMessageDialog(rootPane, "El archivo fue guardado con éxito");
                }
            }
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
        
        if (e.getSource() == boton5){//funcion boton abrir
            String aux = "";
            String texto = "";
            String resultado = "";
        try {
        JFileChooser file = new JFileChooser(System.getProperty("user.dir"));
        file.showOpenDialog(this);
        File archivo = file.getSelectedFile();
           if (archivo != null) {
           FileReader archivos = new FileReader(archivo);
           BufferedReader leer = new BufferedReader(archivos);
           while ((aux = leer.readLine()) != null) {
           texto += aux + "\n";
          }
           leer.close();
          }
          } catch (IOException ex) {
         JOptionPane.showMessageDialog(null, "Error De Importado - " + ex);
        }
         txt_result.setText(texto);
        }
        
        if (e.getSource() == boton6) {//funcion boton comillas
            String texas, part;
        texas = txt_result.getText();
        part=(txt_result.getSelectedText());
        txt_result.setText(texas.split(part)[0]+"'"+"'"+part+"'"+"'"+texas.split(part)[1]);
        }
        
        if(e.getSource() == boton7){//Tamaño de letra (fuente)
            cont++;
            if (cont<8){
            if (cont==1){
               txt_result.setFont(new Font("CALIBRI",Font.PLAIN,12));
            }
            if (cont==2){
                txt_result.setFont(new Font("",Font.PLAIN,20));
            }
            if (cont==3){
                txt_result.setFont(new Font("",Font.PLAIN,25));
            }
            if (cont==4){
                txt_result.setFont(new Font("",Font.PLAIN,30));
            }
            if (cont==5){
                txt_result.setFont(new Font("",Font.PLAIN,35));
            }
            if (cont==6){
                txt_result.setFont(new Font("",Font.PLAIN,40));
            }
            if (cont==7){
                txt_result.setFont(new Font("",Font.PLAIN,60));
            }
            }else{
            reiniciar();
            }
            
        }
        
        if(e.getSource() == boton8){//salir
            this.dispose();
        }
        
    }
        
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
	FlowLayout miFlowLayout;
        TextField txt_in;
        Label lbl_msg;
        TextArea txt_result;
        boolean presionado;
        ArrayList<Integer> array;
        int cont = 0;
	}