/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import jpa_ibreria.entidades.Libro1;

/**
 *
 * @author lucia
 */
public class LibroDAO extends DAO<Libro1> {

    @Override
    public List<Libro1> consulta(String query) {
        return super.consulta(query); 
    }
    
    public List<Libro1> consultaTitulo(String titulo){
        return em.createQuery("SELECT a FROM Libro1 a WHERE a.titulo LIKE :tituloLibro").setParameter("tituloLibro",titulo).getResultList();
    }
    
    public Libro1 consultaISBN(long id){
        return (Libro1) em.createQuery("SELECT a FROM Libro1 a WHERE a.id = :idLibro").setParameter("idLibro", id).getSingleResult();
    }
     public List<Libro1> consultaAutor(Object nombre){
        return em.createQuery("SELECT a FROM Libro1 a WHERE a.autor.nombre LIKE :autor").setParameter("autor", nombre).getResultList();
    }
     
     public List<Libro1> consultaEditorial (Object nombre){
        List<Libro1> lista = em.createQuery("SELECT a FROM Libro1 a WHERE a.editorial.nombre LIKE :editorial").setParameter("editorial",nombre).getResultList();
        return lista;
    }

    @Override
    public void eliminar(Libro1 objeto) {
        super.eliminar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void modificar(Libro1 objeto) {
        super.modificar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void guardar(Libro1 objeto) {
        super.guardar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
