/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author ADMIN
 */
@Stateless
public class PersonaDaoImpl implements PersonaDAO{
    
    //Relacion entre el EJB gracias a @Entity y @EntityManagery la configuracion de la persistencia en el archivo persistence.xml
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        /*Gracias a que la clase Persona.java es un EJB y tiene la inyeccion
        @Entity y se le dio una anotacion adicional de @namedQuerties
        cuyo nombre se le asigno como "Persona.findAll" y su respectivo QUERY
        se puede hacer un llamado mediante el metodo getResultList
        */
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        //no se usa em.find con el fin de mostrar tambien como crear un Query
        Query query = em.createQuery("From Personas p WHERE p.email =: email");
        query.setParameter("email", persona.getEmail());
        
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        //Verificar si funciona correctamente si no corregir v 28
        em.merge(persona);
        em.remove(persona);
    }
    
    
}
