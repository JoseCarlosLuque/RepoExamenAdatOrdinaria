package com.example.ExamenAdatJCarlos.Controller;

import com.example.ExamenAdatJCarlos.Model.Alquiler;
import com.example.ExamenAdatJCarlos.Service.AlquilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals") // Ruta base para los alquileres
public class AlquilerController {

    private final AlquilerService service;

    public AlquilerController(AlquilerService service) {
        this.service = service;
    }

    @PostMapping // Ruta: /rentals
    public Alquiler rentar(@RequestParam Long userId, @RequestParam Long carId) {
        return service.rentar(userId, carId);
    }

    @PutMapping("/{id}/return") // Ruta: /rentals/{id}/return
    public void devolver(@PathVariable Long id) {
        service.devolver(id);
    }

    @GetMapping("/users/{id}") // Ruta: /rentals/users/{id}
    public List<Alquiler> historial(@PathVariable Long id) {
        return service.historial(id);
    }
}