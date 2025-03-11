package com.example.ExamenAdatJCarlos.Repository;

import com.example.ExamenAdatJCarlos.Model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findByUsuarioId(Long userId);
}
