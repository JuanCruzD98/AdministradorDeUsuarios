package com.springproyect.ProyectoWeb.controllers;

import com.springproyect.ProyectoWeb.dao.UsuarioDao;
import com.springproyect.ProyectoWeb.models.Usuario;
import com.springproyect.ProyectoWeb.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    //Utilizo JWT para crear sesion usuario;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogeado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogeado != null){

           String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getEmail());


             return tokenJwt ;
        }
        return "Fail";
    }
}
