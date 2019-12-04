/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author ADMIN
 */

@Local
public interface PersonaService {

    public ArrayList<Persona> listarPersonas();
    
    public Persona encontrarPersonaPorId(Persona persona);
    public Persona encontrarPersonaPorEmail(Persona persona);
    
    public void registrarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
