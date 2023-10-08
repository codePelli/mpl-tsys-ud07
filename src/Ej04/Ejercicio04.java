package Ej04;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio04 {
	
	Scanner sc = new Scanner(System.in);
	static Hashtable<String, Double> productos = new Hashtable<>();
	static Hashtable<String, ArrayList<Double>> carrito = new Hashtable<>();
	
	public static void main(String[] args) {
				
		while(true) {
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(
					
					"--- Control de stock --- \n" + 
					"1. Anadir stock \n" + 
					"2. Consultar stock \n" + 
					"3. Listar stock \n \n" +
					"--- Añadir al carro --- \n" +
					"4. Si \n" +
					"5. Finalizar venta \n"
					));
					
	    	double precioTotal = 0;
	    	double cambio = 0;
	    	double pagado = 0;
		
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
					
				case 4:
					
					addCart(precioTotal);

					break;	
					
				case 5:
					
					sellCart(precioTotal);
					break;

					
				default:
					
					JOptionPane.showMessageDialog(null, "Elige una opcion");
					break;
					
			}
			
		}
		
	}

	private static void addCart(double precioTotal) {
		
		String nombre = JOptionPane.showInputDialog("Nombre producto: ");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio producto: "));
		
		double iva = precio * 0.21;
		double bruto = precio - iva;

		ArrayList<Double> cantidades = new ArrayList<>();
		cantidades.add(precio);
		cantidades.add(iva);
		cantidades.add(bruto);
		precioTotal = precioTotal + precio;
		
		carrito.put(nombre, cantidades);
	}

	private static void sellCart(double precioTotal) {
		
		double cambio;
		double pagado;
		
		System.out.println("Lista de la compra:");

		Enumeration<String> productos = carrito.keys();

		while (productos.hasMoreElements()) {

			String nombres = productos.nextElement();
			ArrayList<Double> valores = carrito.get(nombres);

			System.out.println("Producto: " + nombres);
			System.out.println("Precio: " + valores.get(0));
			System.out.println("IVA: " + valores.get(1));
			System.out.println("Bruto: " + valores.get(2));

		}
		
		System.out.println("Cantidad de productos: " + carrito.size());
		System.out.println("Precio total: " + precioTotal);
		System.out.println("Pagado: ");
		pagado = Double.parseDouble(JOptionPane.showInputDialog("Pagado: "));
		cambio = pagado - precioTotal;
		System.out.println("Cambio a devolver: " + cambio);
		
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
	
	static void sellStock() {
		
		
	}
		
}

