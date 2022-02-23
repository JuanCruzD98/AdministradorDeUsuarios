package com.springproyect.ProyectoWeb.controllers;

import com.springproyect.ProyectoWeb.dao.UsuarioDao;
import com.springproyect.ProyectoWeb.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Mateo");
        user.setApellido("Ramirez");
        user.setEmail("usuario@usuario.com");
        user.setTelefono("24589453");

        return user;
    }
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    //Seteo contraseña encriptandola con Argon2
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios45")
    public Usuario editar(){
        Usuario user = new Usuario();
        user.setNombre("Mateo");
        user.setApellido("Ramirez");
        user.setEmail("usuario@usuario.com");
        user.setTelefono("24589453");

        return user;
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);

    }

    @RequestMapping(value = "api/usuarios47")
    public Usuario buscar(){
        Usuario user = new Usuario();
        user.setNombre("Mateo");
        user.setApellido("Ramirez");
        user.setEmail("usuario@usuario.com");
        user.setTelefono("24589453");

        return user;
    }

}
