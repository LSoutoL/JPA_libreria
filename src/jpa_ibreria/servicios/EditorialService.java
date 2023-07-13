/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.List;
import java.util.Scanner;
import jpa_ibreria.entidades.Editorial;
import jpa_ibreria.persistencia.EditorialDAO;

/**
 *
 * @author lucia
 */
public class EditorialService {
     private EditorialDAO dao;
    private Scanner leer;

    public EditorialService() {
        this.dao=new EditorialDAO();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Editorial crearEditorial() throws Exception{
        System.out.println("Indique el nombre de la editorial");
        String nombre = leer.next();
        List<Editorial> editoriales = dao.consulta(nombre);
        Editorial editorial = new Editorial();
        if (editoriales.isEmpty()){
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            validar(editorial);
            dao.guardar(editorial); 
        } else {
            for (Editorial var : editoriales) {
                if(var.getNombre().equalsIgnoreCase(nombre)){
                    return var;
                }
            }
        }
        return editorial;
    }
    
    public void validar(Editorial editorial) throws Exception{
        try{
            if (editorial.getNombre().isEmpty()){
                 throw new Exception("Error. No ha indicado el nombre de la editorial.");
            }
            if (editorial.getAlta()==false){
                throw new Exception("Error. Una vez creada la editorial, debe ser dada de alta");
            }            
        } catch (Exception e){
            throw e;
        }
    }
    
    
}
