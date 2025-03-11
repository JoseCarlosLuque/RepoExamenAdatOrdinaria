package com.example.ExamenAdatJCarlos.Repository;

import com.example.ExamenAdatJCarlos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
