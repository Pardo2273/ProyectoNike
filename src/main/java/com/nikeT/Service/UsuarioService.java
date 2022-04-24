package com.nikeT.Service;

import com.nikeT.Entity.Credito;
import com.nikeT.Entity.Usuario;
import com.nikeT.Repository.CreditoRepository;
import com.nikeT.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private CreditoRepository creditorepository;

    @Override
    public List<Usuario> getAllUsers() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void saveUser(Usuario usuario) { //aqui anadi las lines 25,26,27
//        Credito credito = usuario.getCredito();
//        credito = creditorepository.save(credito);
//        usuario.setCredito(credito);
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUserById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) { //opcional y prueba
        this.usuarioRepository = usuarioRepository;
    }
}
