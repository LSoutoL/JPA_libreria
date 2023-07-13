/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import jpa_ibreria.entidades.Prestamo1;

/**
 *
 * @author lucia
 */
public class PrestamoDAO extends DAO<Prestamo1> {


    public List<Prestamo1> consulta(Object id) {
        return  em.createQuery("SELECT a FROM Prestamo1 a WHERE a.cliente.id = :cliente").setParameter("cliente",id).getResultList();
    }

   
    public Prestamo1 consultaId(Integer id) {
        return  (Prestamo1) em.createQuery("SELECT a FROM Prestamo1 a WHERE a.id = :idPrestamo").setParameter("idPrestamo",id).getSingleResult();
    }
    
}
