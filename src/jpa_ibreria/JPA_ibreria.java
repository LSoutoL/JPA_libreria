/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa_ibreria;

import jpa_ibreria.persistencia.AutorDAO;
import jpa_ibreria.persistencia.LibroDAO;
import jpa_ibreria.servicios.LibreriaService;




/**
 *
 * @author lucia
 */
public class JPA_ibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LibreriaService ls = new LibreriaService();
        ls.menu();
    }
    
}
