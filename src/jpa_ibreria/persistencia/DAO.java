/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucia
 */
public abstract class DAO<T> {
    /*
    Para crear Java Controller:
    Crear un nuevo archivo en el icono. El tipo de archivo esta en la carpeta persistence y se llama Controller.
    Elegir todas las entidades pertinentes, crearlas y guardarlas en una carpeta creada previamenteal efecto.
    Una vez creadas, agregar en cada controller de cada entidad un nuevo contructor que inicialice el
    EntityManagerFactory de la forma tradicional (escrito abajo). Listo, automaticamente tiene los metodos necesarios.
    */
    
    
    
    protected EntityManagerFactory EMF=Persistence.createEntityManagerFactory("JPA_ibreriaPU");
    protected EntityManager em=EMF.createEntityManager();
    
     protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }
     
     protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar (T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }
    
    public void modificar (T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }
    
    public void eliminar (T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
    public List<T> consulta(String query){
        List<T> lista = em.createQuery(query).getResultList();
        return lista;
    }
    
}
