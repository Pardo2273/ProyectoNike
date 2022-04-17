package com.nikeT.Controller;

import com.nikeT.Entity.Pais;
import com.nikeT.Entity.Usuario;
import com.nikeT.Service.IPaisService;
import com.nikeT.Service.IUsuarioService;
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
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IPaisService paisService;

    @GetMapping("/verUsuarios")
    public String Read(Model model) {
        List<Usuario> listaUsuario = usuarioService.getAllUsers();
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuario", listaUsuario);
        return "VerUsuario";
    }

    @GetMapping("/crearUsuario")
    public String Create(Model model) {
        model.addAttribute("usuario", new Usuario());
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("paises", listaPais);
        return "Registrarse";
    }

    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUser(usuario);
        return "redirect:/verUsuarios";
    }

    @GetMapping("/nuevoUsuario")
    public String nuevaPerson(Usuario Usuario) {
        return "modificarUsuario";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect:/verUsuarios";
    }

   @GetMapping("/editUsuario/{id}")
    public String Update(@PathVariable("id") Long idUsuario, Model model) {
        Usuario s = usuarioService.getUserById(idUsuario);
        List<Pais> listaPais = paisService.listCountry(); 
        model.addAttribute("usuario", s);
        model.addAttribute("paises", listaPais);
        return "Registrarse";
    }
    //aqui acaba el Crud del usuario, costo pero se logro xd
    
     // empiezan controladores donde van a tener permitido ingresar los usuarios y admin......
    @GetMapping("/car")
    public String Carrito() {
        return "Carrito";
    }

    @GetMapping("/hombre")
    public String Hombre() {
        return "hombre";
    }

    @GetMapping("/mujer")
    public String Mujer() {
        return "Mujer";
    }

    @GetMapping("/acce")
    public String Acces() {
        return "Accesorios";
    }

    @GetMapping("/pCompra")
    public String Comprapunto() {
        return "PuntosCompra";
    }

    @GetMapping("/ofe")
    public String Oferts() {
        return "ofertas";
    }

    @GetMapping("/cont")
    public String contacto() {
        return "Contactenos";
    }
}
