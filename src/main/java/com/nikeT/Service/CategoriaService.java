package com.nikeT.Service;

import com.nikeT.Entity.Categoria;
import com.nikeT.Repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {

    // se supone que era con el repositorio del cliente pero no tendria sentido para mi es con el propio repositorio de categoria 
    //sino paraa que creo unaa interfaz como tal de Icategoria
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaRepository.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

    public void setCategoriaRepository(CategoriaRepository categoriaRepository) { //opcional y prueba
        this.categoriaRepository = categoriaRepository;
    }

}
