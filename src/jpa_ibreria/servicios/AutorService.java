/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.List;
import java.util.Scanner;
import jpa_ibreria.entidades.Autor;
import jpa_ibreria.persistencia.AutorDAO;

/**
 *
 * @author lucia
 */
public class AutorService {
    private AutorDAO dao;
    private Scanner leer;

    public AutorService() {
        this.dao=new AutorDAO();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Autor crearAutor() throws Exception{
        System.out.println("Indique el nombre del autor");
        String nombre = leer.next();
        List<Autor> autores = dao.consultaNombre(nombre);
        Autor autor = new Autor();
        if (autores.isEmpty()){
            autor.setNombre(nombre);
            autor.setAlta(true);
            validar(autor);
            dao.guardar(autor);
        } else {
            for (Autor var : autores) {
                if(var.getNombre().equalsIgnoreCase(nombre)){
                    return var;
                }
            }
        }
        return autor;
    }
    
    public void validar(Autor autor) throws Exception{
        try{
            if (autor.getNombre().isEmpty()){
                 throw new Exception("Error. No ha indicado el nombre del autor.");
            }
            if (autor.getAlta()==false){
                throw new Exception("Error. Una vez creado el autor, debe ser dado de alta");
            }            
        } catch (Exception e){
            throw e;
        }
    }
    
    public void buscarNombre(){
        System.out.println("Indique el nombre del autor");
        String nombre = leer.next();
        List<Autor> autores = dao.consultaNombre(nombre);
        System.out.println("ID Autor | Nombre          ");
        for (Autor autore : autores) {
            System.out.println(autore.getId() + " | " + autore.getNombre());
        }
    }
}
