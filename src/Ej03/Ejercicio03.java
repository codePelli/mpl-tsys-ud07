package Ej03;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ejercicio03 {
	
	static Hashtable<String, Double> productos = new Hashtable<>();
	
	public static void main(String[] args) {
		
		stockinicial();
		
		while(true) {
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(
					
					"Selecciona: \n" + 
					"1. Anadir stock \n" + 
					"2. Consultar stock \n" + 
					"3. Listar stock \n" ));
		
			switch (opcion) {
			
				case 1:
					
					addStock();
					break;
					
				case 2:
					
					checkStock();
					break;
					
				case 3:
					
					listStock();
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Elige una opcion");
					break;
					
			}
			
		}
		
	}

	private static void stockinicial() {
		
		productos.put("galletas", 5.0);
		productos.put("cervezas", 5.0);
		productos.put("pan", 5.0);
		productos.put("agua", 5.0);
		productos.put("leche", 5.0);
		productos.put("sal", 5.0);
		productos.put("azucar", 5.0);
		productos.put("cola", 5.0);
		productos.put("pizza", 5.0);
		productos.put("pasta", 5.0);
		
	}

	static void listStock() {

		if (productos.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "No hay stock");
			
		} else {
			
			String stock = "Stock: ";
			Enumeration<String> lista = productos.keys();
			
			while (lista.hasMoreElements()) {
				
				String producto = lista.nextElement();
				stock = stock +	producto + ": " + productos.get(producto);	
			
			}
			
			JOptionPane.showMessageDialog(null, stock);

		}
		
	}

	static void checkStock() {

		String nombre = JOptionPane.showInputDialog(null, "Nombre del producto a buscar");
	
		if (productos.containsKey(nombre)) {
			JOptionPane.showMessageDialog(null, "Producto: " +	nombre + "Precio: " + productos.get(nombre));
		} else {
			JOptionPane.showMessageDialog(null, "No existe");
		}
		
	}

	static void addStock() {
		
		String nombre = JOptionPane.showInputDialog(null, "Nombre del producto");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto"));
		
		productos.put(nombre, precio);
		JOptionPane.showMessageDialog(null, "Producto anadido");
	}
		
}