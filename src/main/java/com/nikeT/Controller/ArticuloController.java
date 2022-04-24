package com.nikeT.Controller;

import com.nikeT.Entity.Pais;
import com.nikeT.Entity.Articulo;
import com.nikeT.Service.IArticuloService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //esto me toco añadirlo 
public class ArticuloController {
//Crud
    @Autowired
    private IArticuloService articuloService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        List<Articulo> listaArticulo = articuloService.getArticulos(true); // sino funcion en true cambielo a false para que se muestren las articulos
        model.addAttribute("titulo", "Articulos");
        model.addAttribute("articulo", listaArticulo);
        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulo/modifica";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "articulo/modifica";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String Delete(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}
