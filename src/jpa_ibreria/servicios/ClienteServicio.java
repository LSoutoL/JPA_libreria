/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_ibreria.servicios;

import java.util.List;
import java.util.Scanner;
import jpa_ibreria.entidades.Cliente;
import jpa_ibreria.persistencia.ClienteDAO;

/**
 *
 * @author lucia
 */
public class ClienteServicio {
    ClienteDAO dao;
    Scanner leer;

    public ClienteServicio() {
        this.dao=new ClienteDAO();
        this.leer= new Scanner(System.in).useDelimiter("\n");
    }
      
    public Cliente crearCliente() throws Exception{
        Cliente cliente = new Cliente();
        System.out.println("Indique el nombre del cliente");
            cliente.setNombre(leer.next());
            System.out.println("Indique el apellido");
            cliente.setApellido(leer.next());
            System.out.println("Indique el numero de documento");
            cliente.setDocumento(leer.nextLong());
            System.out.println("Ingrese un numero de telefono de contacto");
            cliente.setTelefono(leer.next());
            validar(cliente);
            dao.guardar(cliente);
        return cliente;
    }
    
    public void validar(Cliente cliente) throws Exception{
        try{
            if (cliente.getNombre().isEmpty()){
                 throw new Exception("Error. No ha indicado el nombre del cliente.");
            }
            if (cliente.getApellido().isEmpty()){
                 throw new Exception("Error. No ha indicado el nombre del cliente.");
            }
            if (cliente.getDocumento()==null){
                throw new Exception("Error. No ingreso el numero documento o su formato no fue valido.");
            }
            if(cliente.getTelefono().isEmpty()){
                throw new Exception("Error. No ha ingresado un telefono");
            }
        } catch (Exception e){
            throw e;
        }
    }
    
    public Cliente buscarCliente(Integer id){
        return dao.consultaId(id);
    }
}
