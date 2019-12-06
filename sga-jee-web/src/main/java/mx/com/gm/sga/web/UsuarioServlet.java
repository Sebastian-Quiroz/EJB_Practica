/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioService;

/**
 *
 * @author ADMIN
 */
//Convertimos la clase en servlet y le asignamos una ruta
@WebServlet("/usuariosList")
public class UsuarioServlet extends HttpServlet {

    //usaremos el CDI mediante la clase UsuarioService como nuestro puente
    @Inject
    UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("Usuarios " + usuarios);
        //se asigna el nombre "usuarios" para ser usado en el jsp listadoUusarios.jsp en la seccion de c:forEach
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }

}
