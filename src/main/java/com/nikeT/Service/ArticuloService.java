package com.nikeT.Service;

import com.nikeT.Entity.Articulo;
import com.nikeT.Repository.ArticuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService implements IArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) articuloRepository.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());//anadi la negacion en ambos lados.......
        }
        return lista;
    }

    @Override
    public void save(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloRepository.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloRepository.delete(articulo);
    }

    public void setArticuloRepository(ArticuloRepository articuloRepository) { //opcional y prueba
        this.articuloRepository = articuloRepository;
    }

}
