/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class LibreriaService {
    LibroService ls ;
    AutorService as;
    EditorialService es;
    PrestamoServicio ps;
    ClienteServicio cs;
    Scanner leer;

    public LibreriaService() {
        this.ls= new LibroService();
        this.as= new AutorService();
        this.es= new EditorialService();
        this.ps=new PrestamoServicio();
        this.cs=new ClienteServicio();
        this.leer= new Scanner(System.in).useDelimiter("\n");
    }
    
    public void menu() throws Exception{
    int opc;
        do{
            System.out.println("Indica la accion que queres realizar:");
            System.out.println("1. Ingresar un libro.");
            System.out.println("2. Ingresar un autor.");
            System.out.println("3. Ingresar una editorial.");
            System.out.println("4. Buscar un libro por ISBN.");
            System.out.println("5. Buscar un libro por titulo.");
            System.out.println("6. Buscar un autor por nombre.");
            System.out.println("7. Buscar un libro por autor.");
            System.out.println("8. Buscar un libro por editorial.");
            System.out.println("9. Ingresar Cliente");
            System.out.println("10. Registrar nuevo prestamo");
            System.out.println("11. Registrar devolucion");
            System.out.println("12. Buscar prestamos por cliente");
            System.out.println("13. Salir.");
            opc=leer.nextInt();
            switch (opc){
                case 1: ls.guardarLibro();
                break;
                case 2: as.crearAutor();
                break;
                case 3: es.crearEditorial();
                break;
                case 4: ls.buscarISBN();
                break;
                case 5: ls.buscarTitulo();
                break;
                case 6: as.buscarNombre();
                break;
                case 7: ls.buscarAutor();
                break;
                case 8: ls.buscarEditorial();
                break;
                case 9:cs.crearCliente();
                break;
                case 10: ps.crearPrestamo();
                break;
                case 11: ps.devolucion();
                break;
                case 12: ps.buscarCliente();
                break;
            }
        } while (opc!=13);
}
}
