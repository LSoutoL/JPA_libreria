/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import jpa_ibreria.entidades.Cliente;
import jpa_ibreria.entidades.Libro1;
import jpa_ibreria.entidades.Prestamo1;
import jpa_ibreria.persistencia.LibroDAO;
import jpa_ibreria.persistencia.PrestamoDAO;

/**
 *
 * @author lucia
 */
public class PrestamoServicio {
    PrestamoDAO dao;
    ClienteServicio cs;
    LibroService ls;
    Scanner leer; 

    public PrestamoServicio() {
        this.dao=new PrestamoDAO();
        this.cs=new ClienteServicio();
        this.ls=new LibroService();
        this.leer= new Scanner(System.in).useDelimiter("\n");
    }
    
    public void crearPrestamo() throws Exception{
        try{
        Prestamo1 prestamo = new Prestamo1();
        System.out.println("Indique el id del cliente");
        Integer id = leer.nextInt();
        Cliente clientes = cs.buscarCliente(id);
        if (clientes==null){
             prestamo.setCliente(cs.crearCliente());
        } else prestamo.setCliente(clientes);
        Libro1 libros = ls.buscarISBN();
        if(libros==null){
            throw new Exception("El libro no fue encontrado. Verifique la ISBN aportada.");
        }
        prestamo.setLibro(libros);
        prestamo.setFechaPrestamo(new Date());
        dao.guardar(prestamo);
        System.out.println("El id de su prestamo es:" + prestamo.getId());
        } catch (Exception e){
            throw e;
        }    
    }
    
    public void devolucion() throws Exception{
        try{
        System.out.println("Indique el id de su prestamo");
        Integer id = leer.nextInt();
        Prestamo1 prestamos = dao.consultaId(id);
        if (prestamos==null){
        throw new Exception("El id del prestamo no fue encontrado.");    
        }
        prestamos.setFechaDevolucion(new Date());
        } catch (Exception e){
            throw e;
        }
    }
    
    public void buscarCliente() throws Exception{
        try{
       System.out.println("Indique el id del cliente cuyos prestamos desea consultar");
        Integer id = leer.nextInt();
        List<Prestamo1> prestamos = dao.consulta(id);
        if(prestamos.isEmpty()){
            throw new Exception("No existen prestamos en relacion al id indicado");
        }
            System.out.println("ID Prestamo | Fecha de prestamo | Fecha de devolucion | Libro         | Cliente        ");
        for (Prestamo1 prestamo : prestamos) {
            if (prestamo.getFechaDevolucion()==null){
                System.out.println(prestamo.getId() + " | " + prestamo.getFechaPrestamo() + " |          | " + prestamo.getLibro().getTitulo() + " | " + prestamo.getCliente().getNombre() + " " + prestamo.getCliente().getApellido());
            } else  System.out.println(prestamo.getId() + " | " + prestamo.getFechaPrestamo() + " | " + prestamo.getFechaDevolucion() + " | " + prestamo.getLibro().getTitulo() + " | " + prestamo.getCliente().getNombre() + " " + prestamo.getCliente().getApellido());
        }
        } catch (Exception e){
            throw e;
        }
    }
}
