/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikeT.Service;

import com.nikeT.Entity.Articulo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IArticuloService {

    public List<Articulo> getArticulos(boolean activos);

    public void save(Articulo cliente);

    public void delete(Articulo cliente);

    public Articulo getArticulo(Articulo cliente);
}
