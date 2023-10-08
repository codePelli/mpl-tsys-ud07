package Ej01;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

public class Ejercicio01 {

	public static void main(String[] args) {
		
    	Hashtable<String, Double> alumnoMedia = new Hashtable<>();
    	
    	String condicion = "si";
    	
    	while(condicion.equals(condicion)) {
    		
    		String nombre = (JOptionPane.showInputDialog("Inserta el nombre del alumno: "));
    		double media = Double.parseDouble(JOptionPane.showInputDialog("Inserta la nota media: "));
    		
    		alumnoMedia.put(nombre, media);
    		
    		condicion = (JOptionPane.showInputDialog("¿Quieres añadir alumno y nota? ¿si o no? "));
   
    	}
    	
    	Enumeration<String> nombres = alumnoMedia.keys();
    	
    	while(nombres.hasMoreElements()) {
    		
        	String nombre = nombres.nextElement();
        	double nota = alumnoMedia.get(nombre);

        	JOptionPane.showMessageDialog(null, "Alumno: " + nombre + ", media: " + nota);
        	
    	}
	}

}