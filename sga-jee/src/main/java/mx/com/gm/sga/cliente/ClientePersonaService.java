/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author ADMIN
 */
public class ClientePersonaService {
    
    public static void main(String[] args) {
        
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaServiceRemote = 
                    (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            ArrayList<Persona> personas = (ArrayList<Persona>) personaServiceRemote.listarPersonas();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("Fin llamda al EJB desde elcliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
