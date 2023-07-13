/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import jpa_ibreria.entidades.Editorial;

/**
 *
 * @author lucia
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public List<Editorial> consulta(String query) {
        return em.createQuery("SELECT a FROM Editorial a WHERE a.nombre LIKE :Editorialnombre").setParameter("Editorialnombre", query).getResultList();
    }
    
}
