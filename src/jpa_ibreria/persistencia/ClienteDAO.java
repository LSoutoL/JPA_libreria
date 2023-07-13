/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import jpa_ibreria.entidades.Cliente;

/**
 *
 * @author lucia
 */
public class ClienteDAO extends DAO<Cliente> {
    
    public Cliente consultaId(Object id) { 
        return (Cliente) em.createQuery("SELECT a FROM Cliente a WHERE a.id = :idCliente").setParameter("idCliente",id).getSingleResult();
    }
}
