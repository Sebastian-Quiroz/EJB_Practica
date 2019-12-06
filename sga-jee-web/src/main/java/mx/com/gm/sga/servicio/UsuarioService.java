/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ADMIN
 */

//Indicar que la interface sera un ejb local
@Local
public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    public Usuario encontrarUsuarioPorEmail(Usuario usuario);
    
    public void registraUsuario(Usuario usuario);
    public void modificarUusario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
}
