package com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.controllers;

import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.Anonimo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class HechoController {
    private static final List<Hecho> HECHOS = List.of(
        new HechoTextual(
            "SOY INSTANCIA 8082 Noticia Destacada",
            "noticia",
            new Categoria("Actualidad"),
            new Ubicacion(3.4, 5.6),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta2")),
            "Contenido del hecho textual A"
        ),
        new HechoMultimedia(
            "SOY INSTANCIA 8082 Reporte Visual",
            "reporte",
            new Categoria("Multimedia"),
            new Ubicacion(7.8, 9.0),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta3")),
            new Registrado("Juan Perez","juan@email.com",99),
            List.of("imagen1.png", "video1.mp4")
        ),
        new HechoTextual(
            "SOY INSTANCIA 8082 Curiosidad Local",
            "curiosidad",
            new Categoria("Cultura"),
            new Ubicacion(4.2, 1.9),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta4")),
            "Descripción de la curiosidad local"
        ),
        new HechoMultimedia(
            "SOY INSTANCIA 8082 Evidencia Fotográfica",
            "evidencia",
            new Categoria("Pruebas"),
            new Ubicacion(6.1, 3.3),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta5")),
            Anonimo.getInstance(),
            List.of("foto2.jpg", "audio1.mp3")
        ),
        new HechoTextual(
            "SOY INSTANCIA 8082 Relato Vecinal",
            "relato",
            new Categoria("Testimonios"),
            new Ubicacion(2.5, 8.7),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta6")),
            "Relato de un vecino sobre el evento"
        ),
        new HechoMultimedia(
            "SOY INSTANCIA 8082 Archivo Multimedia",
            "archivo",
            new Categoria("Documentos"),
            new Ubicacion(5.5, 7.7),
            LocalDateTime.now(),
            List.of(new Etiqueta("Etiqueta7")),
            new Registrado("Juan Perez","juan@email.com",99),
            List.of("documento.pdf", "grabacion.wav")
        )
        );

        private static final Coleccion COLECCION_A = new Coleccion(
            "A123",
            List.of(
                new HechoTextual(
                    "Hecho A1",
                    "noticia",
                    new Categoria("Actualidad"),
                    new Ubicacion(3.4, 5.6),
                    LocalDateTime.now(),
                    List.of(new Etiqueta("Etiqueta2")),
                    "Texto del hecho A1"
                ),
                new HechoMultimedia(
                    "Hecho A2",
                    "reporte",
                    new Categoria("Multimedia"),
                    new Ubicacion(7.8, 9.0),
                    LocalDateTime.now(),
                    List.of(new Etiqueta("Etiqueta3")),
                    Anonimo.getInstance(),
                    List.of("imagenA2.png", "videoA2.mp4")
                )
            )
        );

        private static final Coleccion COLECCION_B = new Coleccion(
            "B456",
            List.of(
                new HechoTextual(
                    "Hecho B1",
                    "curiosidad",
                    new Categoria("Cultura"),
                    new Ubicacion(4.2, 1.9),
                    LocalDateTime.now(),
                    List.of(new Etiqueta("Etiqueta4")),
                    "Texto del hecho B1"
                ),
                new HechoMultimedia(
                    "Hecho B2",
                    "evidencia",
                    new Categoria("Pruebas"),
                    new Ubicacion(6.1, 3.3),
                    LocalDateTime.now(),
                    List.of(new Etiqueta("Etiqueta5")),
                    new Registrado("Juan Perez","juan@email.com",99),
                    List.of("fotoB2.jpg", "audioB2.mp3")
                )
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