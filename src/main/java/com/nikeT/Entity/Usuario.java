package com.nikeT.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String pripellido;
    private String segpellido;
    private String email;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "paises_id")
    private Pais pais;
    
    // ojo aca con esto siguiente no se si sirva    
    @ManyToOne
    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    private Credito credito;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPripellido() {
        return pripellido;
    }

    public void setPripellido(String pripellido) {
        this.pripellido = pripellido;
    }

    public String getSegpellido() {
        return segpellido;
    }

    public void setSegpellido(String segpellido) {
        this.segpellido = segpellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //lo de pais
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

//lo de credito
    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

}
