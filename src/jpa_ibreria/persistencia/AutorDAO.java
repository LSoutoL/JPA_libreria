/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import jpa_ibreria.entidades.Autor;

/**
 *
 * @author lucia
 */
public class AutorDAO extends DAO<Autor> {
    
    
    public List<Autor> consultaNombre(String nombre){
        List<Autor> lista = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :Autornombre").setParameter("Autornombre", nombre).getResultList();
        return lista;
    }
}
