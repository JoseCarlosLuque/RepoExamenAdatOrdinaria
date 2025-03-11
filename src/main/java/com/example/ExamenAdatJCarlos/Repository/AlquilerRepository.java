package com.example.ExamenAdatJCarlos.Repository;

import com.example.ExamenAdatJCarlos.Model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findByUsuarioId(Long userId);
}
