/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikeT.Service;

import com.nikeT.Entity.Categoria;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICategoriaService {

    public List<Categoria> getCategorias(boolean activos);

    public void save(Categoria cliente);

    public void delete(Categoria cliente);

    public Categoria getCategoria(Categoria cliente);
}
