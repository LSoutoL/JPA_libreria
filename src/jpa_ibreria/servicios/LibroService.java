/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jpa_ibreria.entidades.Autor;
import jpa_ibreria.entidades.Editorial;
import jpa_ibreria.entidades.Libro1;
import jpa_ibreria.persistencia.LibroDAO;

/**
 *
 * @author lucia
 */
public class LibroService {
    
    private LibroDAO dao;
    private Scanner leer;
    private AutorService as;
    private EditorialService es;

    public LibroService() {
        this.dao= new LibroDAO();
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.as=new AutorService();
        this.es=new EditorialService();
    }
    
    public void guardarLibro() throws Exception{
        System.out.println("Indique el titulo del libro");
        String titulo = leer.next();
        List<Libro1> libros = dao.consultaTitulo(titulo);
        Libro1 libro=new Libro1();
        libro.setTitulo(titulo);
        System.out.println("Indique el anio de publicacion");
        libro.setAnio(leer.nextInt());
        System.out.println("Indique el numero de ejemplares a ingresar");
        libro.setEjemplares( leer.nextInt());
        libro.setEjemplaresPrestados(0);
        libro.setEjemplaresRestantes(libro.getEjemplares());
        libro.setAutor( as.crearAutor());
        libro.setAlta(true);
        libro.setEditorial(es.crearEditorial());
        //podria verificarse el duplicado con un .contains
        if (libros.isEmpty()){
        validar(libro);
        dao.guardar(libro);
        } else {
            for (Libro1 var : libros) {
                if (var.getTitulo().equals(titulo)){
                    libro=var;
                    try{
                    System.out.println("El libro ya existe. Indique nuevamente cuantos ejemplares desea agregar");
                    int cant = leer.nextInt();
                    if (cant<1){
                        throw new Exception("Error. Debe ingresarse al menos un ejemplar del libro.");
                    }
                    libro.setEjemplares(libro.getEjemplares()+cant);
                    libro.setEjemplaresRestantes(libro.getEjemplaresRestantes()+cant);
                    dao.modificar(libro);
                    } catch (Exception e){
                        throw e;
                    }
                }
            }
        }
    }
    
    public void validar(Libro1 libro) throws Exception{
        try{
            if (libro.getTitulo().isEmpty()){
            throw new Exception("Error. Debe indicar el titulo del libro.");
        }
            if (libro.getAnio()<1000 | libro.getAnio()> 2023){
            throw new Exception("Anio invalido.");
        } 
             if (libro.getEjemplares()<1){
            throw new Exception("Error. Debe ingresarse al menos un ejemplar del libro.");
        }
             if (libro.getAutor()==null){
            throw new Exception("Error. El autor no fue encontrado ni se ha creado correctamente.");
        }
             if (libro.getEditorial()==null){
            throw new Exception("Error. La editorial no fue encontrada ni se ha creado correctamente.");
        }
        } catch (Exception e){
                        throw e;
    }
    }
    
    public Libro1 buscarISBN() throws Exception{
        try {
        System.out.println("Indique el ISBN del libro");
        long id = leer.nextLong();
        if (id==0){
            throw new Exception("Error. Debe ingresar un numero de ISBN valido.");
        }
        Libro1 libros = dao.consultaISBN(id);
        if(libros==null){
            throw new Exception("No se han encontrado libros con ese criterio de busqueda.");
        }
        System.out.println("ISBN | Titulo                   | Anio | Ejemplares | Prestados | Restantes | Autor | Editorial      " );
        System.out.println(libros.getId() + " | " + libros.getTitulo() + " | " + libros.getAnio() + " | " + libros.getEjemplares() + " | " + libros.getEjemplaresPrestados() + " | " + libros.getEjemplaresRestantes() + " | " + libros.getAutor().getNombre() + " | " + libros.getEditorial().getNombre());
        return libros;
        } catch (Exception e){
            throw e;
        }
    }
    
    public void buscarTitulo() throws Exception{
        try {
        System.out.println("Indique el titulo del libro");
        String titulo = leer.next();
        if (titulo.isEmpty()){
        throw new Exception("Error. No ha ingresado el titulo del libro.");
        }
        List<Libro1> libros = dao.consultaTitulo(titulo);
        if(libros.isEmpty()){
            throw new Exception("No se han encontrado libros con ese criterio de busqueda.");
        }
         System.out.println("ISBN | Titulo                   | Anio | Ejemplares | Prestados | Restantes | Autor | Editorial      " );
        for (Libro1 libro : libros) { 
        System.out.println(libro.getId() + " | " + libro.getTitulo() + " | " + libro.getAnio() + " | " + libro.getEjemplares() + " | " + libro.getEjemplaresPrestados() + " | " + libro.getEjemplaresRestantes() + " | " + libro.getAutor().getNombre() + " | " + libro.getEditorial().getNombre());
        }
        } catch (Exception e){
            throw e;
        }   
    }
    
    public void buscarAutor() throws Exception{
        try{
        System.out.println("Indique el nombre del autor cuyos libros desea encontrar");
        String nombre = leer.next();
        if (nombre.isEmpty()){
            throw new Exception("Error. No ha indicado el nombre del autor.");
        }
        List<Libro1> libros = dao.consultaAutor(nombre);
        if(libros.isEmpty()){
            throw new Exception("No se han encontrado libros con ese criterio de busqueda.");
        }
         System.out.println("ISBN | Titulo                   | Anio | Ejemplares | Prestados | Restantes | Autor | Editorial      " );
        for (Libro1 libro : libros) {
             System.out.println(libro.getId() + " | " + libro.getTitulo() + " | " + libro.getAnio() + " | " + libro.getEjemplares() + " | " + libro.getEjemplaresPrestados() + " | " + libro.getEjemplaresRestantes() + " | " + libro.getAutor().getNombre() + " | " + libro.getEditorial().getNombre());
        }
        } catch (Exception e){
            throw e;
        }
    }
    
     public void buscarEditorial() throws Exception{
        System.out.println("Indique el nombre de la editorial cuyas publicaciones desea encontrar");
        String nombre = leer.next();
        if (nombre.isEmpty()){
            throw new Exception("Error. No ha indicado el nombre de la editorial.");
        }
        List<Libro1> libros = dao.consultaEditorial(nombre);
        if(libros.isEmpty()){
            throw new Exception("No se han encontrado libros con ese criterio de busqueda.");
        }
         System.out.println("ISBN | Titulo                   | Anio | Ejemplares | Prestados | Restantes | Autor | Editorial      " );
        for (Libro1 libro : libros) {
            System.out.println(libro.getId() + " | " + libro.getTitulo() + " | " + libro.getAnio() + " | " + libro.getEjemplares() + " | " + libro.getEjemplaresPrestados() + " | " + libro.getEjemplaresRestantes() + " | " + libro.getAutor().getNombre() + " | " + libro.getEditorial().getNombre());
        }
    }
}
