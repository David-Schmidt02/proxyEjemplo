package com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities;

import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Contribuyente;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonTypeName("registrado")
public class Registrado extends Contribuyente {

    private UUID id;
    private String nombre;
    private String email;
    private int edad;

    public Registrado(String nombre, String email, int edad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }
}
