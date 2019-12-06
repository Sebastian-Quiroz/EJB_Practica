/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDAO;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ADMIN
 */
//convierte el JB a un EJB sin estado, esto permite que se comunique con JPA
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
    //Usamos CDI para inyectar desde nuestro patron de diseño DAO
    //De esta manera usamos JPA mediante la capa DAO
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDAO.findUsuarioById(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorEmail(Usuario usuario) {
        return usuarioDAO.findUsuarioByEmail(usuario);
    }

    @Override
    public void registraUsuario(Usuario usuario) {
        usuarioDAO.insertUsuario(usuario);
    }

    @Override
    public void modificarUusario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.deleteUsuario(usuario);
    }
    
}
