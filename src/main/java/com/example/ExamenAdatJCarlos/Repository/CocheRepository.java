package com.example.ExamenAdatJCarlos.Repository;

import com.example.ExamenAdatJCarlos.Model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CocheRepository extends JpaRepository<Coche, Long> {
    List<Coche> findByBrandAndModel(String brand, String model);
    List<Coche> findByAvailableTrue();

}