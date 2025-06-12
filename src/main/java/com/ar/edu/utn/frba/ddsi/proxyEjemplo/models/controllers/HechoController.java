package com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.controllers;

import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Hecho;
import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HechoController {
    @GetMapping("/hechos")
    public List<Hecho> getHechos() {
        return List.of(
                new Hecho("SOY UN TITULO", "evento", new Categoria("Evento de prueba"), null, LocalDate.of(2024, 6, 1), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Incidente simulado"), null, LocalDate.of(2024, 5, 20), null, null),
                new Hecho("SOY UN TITULO", "evento", new Categoria("Evento de prueba"), null, LocalDate.of(2024, 6, 1), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Incidente simulado"), null, LocalDate.of(2024, 5, 20), null, null),
                new Hecho("SOY UN TITULO", "evento", new Categoria("Evento de prueba"), null, LocalDate.of(2024, 6, 1), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Incidente simulado"), null, LocalDate.of(2024, 5, 20), null, null),
                new Hecho("SOY UN TITULO", "evento", new Categoria("Evento de prueba"), null, LocalDate.of(2024, 6, 1), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Incidente simulado"), null, LocalDate.of(2024, 5, 20), null, null)
        );
    }

    @GetMapping("/colecciones/{id}/hechos")
    public List<Hecho> getHechosPorColeccion(@PathVariable String id) {
        // Puedes variar los datos según el id si lo deseas
        return List.of(
                new Hecho("SOY UN TITULO", "evento", new Categoria("Hecho de la colección " + id), null, LocalDate.now(), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Hecho de la colección " + id), null, LocalDate.now(), null, null),
                new Hecho("SOY UN TITULO", "evento", new Categoria("Hecho de la colección " + id), null, LocalDate.now(), null, null),
                new Hecho("SOY UN TITULO", "incidente", new Categoria("Hecho de la colección " + id), null, LocalDate.now(), null, null)
        );
    }
}