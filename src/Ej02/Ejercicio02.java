package Ej02;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
    	Hashtable<String, ArrayList<Double>> carrito = new Hashtable<>();
    	
    	double precioTotal = 0;
    	double cambio = 0;
    	double pagado = 0;
    	
		System.out.println("---- Supermercado ----");
		
		while(true) {
			
			System.out.println("--- Añadir al carro ---");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			int opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {

			case 1:
				System.out.println("Nombre producto: ");
				String nombre = sc.nextLine();

				System.out.println("Precio producto: ");
				double precio = sc.nextDouble();
				sc.nextLine();
				double iva = precio * 0.21;
				double bruto = precio - iva;

				ArrayList<Double> cantidades = new ArrayList<>();
				cantidades.add(precio);
				cantidades.add(iva);
				cantidades.add(bruto);
				precioTotal = precioTotal + precio;
				
				carrito.put(nombre, cantidades);

				break;

			case 2:

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
				pagado = sc.nextDouble();
				sc.nextLine();
				cambio = pagado - precioTotal;
				System.out.println("Cambio a devolver: " + cambio);

				break;

			default:
				System.out.println("Elige una opcion");
				break;

			}
		}
				
	}

}
