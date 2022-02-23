package com.springproyect.ProyectoWeb.dao;

import com.springproyect.ProyectoWeb.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();


    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
