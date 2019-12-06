/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author ADMIN
 */
public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        //1. Creamos nuevo Objeto
        //Objeto en estado Transitivo
        Persona persona = new Persona("Paola", "Pirazan", "pio@gmail", "444-444-44");
        
        //2. Inicia transaccion
        tx.begin();
        
        //3. Ejecuta SQL
        em.persist(persona);
        log.debug("Objeto Persistido- aun sin commit"+ persona);
        
        //4. Commit//rollback
        tx.commit();
        
        //objeto en estado Separado
        log.debug("Objeto Persistido - Estado separado "+ persona);
        
        //cerramos el entity Manager
    }
}
