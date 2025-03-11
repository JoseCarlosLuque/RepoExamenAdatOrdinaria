package com.example.ExamenAdatJCarlos.Service;

import com.example.ExamenAdatJCarlos.Model.Coche;
import com.example.ExamenAdatJCarlos.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {
    private final CocheRepository repository;

    @Autowired
    public CocheService(CocheRepository repository) {
        this.repository = repository;
    }

    // Listar todos los coches
    public List<Coche> listar() {
        return repository.findAll();
    }

    // Obtener un coche por ID
    public Coche obtener(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Coche no encontrado"));
    }

    // Crear un nuevo coche
    public Coche crear(Coche coche) {
        return repository.save(coche);
    }

    // Actualizar un coche existente
    public Coche actualizar(Long id, Coche coche) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Coche no encontrado");
        }
        coche.setId(id);
        return repository.save(coche);
    }

    // Eliminar un coche
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Coche no encontrado");
        }
        repository.deleteById(id);
    }

    // Buscar coches por marca y modelo
    public List<Coche> buscarPorMarcaYModelo(String brand, String model) {
        return repository.findByBrandAndModel(brand, model);
    }

    // Obtener coches disponibles
    public List<Coche> cochesDisponibles() {
        return repository.findByAvailableTrue();
    }
}