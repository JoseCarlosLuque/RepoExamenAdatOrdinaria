package com.example.ExamenAdatJCarlos.Controller;


import com.example.ExamenAdatJCarlos.Model.Coche;
import com.example.ExamenAdatJCarlos.Service.CocheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars") // Ruta base para coches
public class CocheController {
    private final CocheService service;

    public CocheController(CocheService service) {
        this.service = service;
    }

    // Crear un nuevo coche
    @PostMapping
    public Coche crear(@RequestBody Coche coche) {
        return service.crear(coche);
    }

    // Obtener todos los coches
    @GetMapping
    public List<Coche> listar() {
        return service.listar();
    }

    // Obtener un coche por ID
    @GetMapping("/{id}")
    public Coche obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    // Actualizar un coche
    @PutMapping("/{id}")
    public Coche actualizar(@PathVariable Long id, @RequestBody Coche coche) {
        return service.actualizar(id, coche);
    }

    // Eliminar un coche
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Buscar coches por marca y modelo
    @GetMapping("/search")
    public List<Coche> buscar(@RequestParam String brand, @RequestParam String model) {
        return service.buscarPorMarcaYModelo(brand, model);
    }

    // Listar coches disponibles
    @GetMapping("/available")
    public List<Coche> disponibles() {
        return service.cochesDisponibles();
    }
}

