package com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.controllers;

import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Hecho;
import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Categoria;
import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Coleccion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class HechoController {
    private static final List<Hecho> HECHOS = List.of(
            new Hecho("Evento Importante", "evento", new Categoria("General"), null, LocalDate.of(2024, 6, 1), null, null),
            new Hecho("Incidente Menor", "incidente", new Categoria("General"), null, LocalDate.of(2024, 5, 20), null, null),
            new Hecho("Evento Importante", "evento", new Categoria("General"), null, LocalDate.of(2024, 6, 2), null, null),
            new Hecho("Incidente Mayor", "incidente", new Categoria("General"), null, LocalDate.of(2024, 5, 21), null, null),
            new Hecho("Curiosidad", "curiosidad", new Categoria("General"), null, LocalDate.of(2024, 4, 15), null, null),
            new Hecho("Evento Importante", "evento", new Categoria("General"), null, LocalDate.of(2024, 6, 3), null, null)
    );

    private static final Coleccion COLECCION_A = new Coleccion(
            "A123",
            List.of(
                    new Hecho("Hecho 1", "evento", new Categoria("Categoria A"), null, LocalDate.of(2024, 6, 1), null, null),
                    new Hecho("Hecho 2", "incidente", new Categoria("Categoria A"), null, LocalDate.of(2024, 6, 2), null, null)
            )
    );

    private static final Coleccion COLECCION_B = new Coleccion(
            "B456",
            List.of(
                    new Hecho("Hecho 3", "evento", new Categoria("Categoria B"), null, LocalDate.of(2025, 6, 3), null, null),
                    new Hecho("Hecho 4", "incidente", new Categoria("Categoria B"), null, LocalDate.of(2025, 6, 4), null, null)
            )
    );
    private static final List<Coleccion> COLECCIONES = List.of(COLECCION_A, COLECCION_B);

    @GetMapping("/hechos")
    public List<Hecho> getHechos() {
        return HECHOS;
    }

    @GetMapping("/hechos/{id}")
    public Hecho getHechoPorId(@PathVariable UUID id) {
        return HECHOS.stream()
                .filter(h -> id.equals(h.getId()))
                .findFirst()
                .orElse(null);
    }


    @GetMapping("/colecciones/{id}/hechos")
    public List<Hecho> getHechosPorColeccion(@PathVariable String id) {
        return COLECCIONES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(Coleccion::getHechos)
                .orElse(List.of());
    }

}