package com.example.ExamenAdatJCarlos.Service;

import com.example.ExamenAdatJCarlos.Model.Alquiler;
import com.example.ExamenAdatJCarlos.Model.Coche;
import com.example.ExamenAdatJCarlos.Model.EstadoAlquiler;
import com.example.ExamenAdatJCarlos.Model.Usuario;
import com.example.ExamenAdatJCarlos.Repository.AlquilerRepository;
import com.example.ExamenAdatJCarlos.Repository.CocheRepository;
import com.example.ExamenAdatJCarlos.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlquilerService {
    private final AlquilerRepository alquilerRepository;
    private final CocheRepository cocheRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AlquilerService(AlquilerRepository ar, CocheRepository cr, UsuarioRepository ur) {
        this.alquilerRepository = ar;
        this.cocheRepository = cr;
        this.usuarioRepository = ur;
    }

    public Alquiler rentar(Long userId, Long carId) {
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow();
        Coche coche = cocheRepository.findById(carId).orElseThrow();

        if(!coche.isAvalible()) throw new RuntimeException("Coche no disponible.");

        coche.setAvalible(false);
        cocheRepository.save(coche);

        Alquiler alquiler = new Alquiler();
        alquiler.setUsuario(usuario);
        alquiler.setCoche(coche);
        alquiler.setRentalDate(LocalDateTime.now());
        alquiler.setStatus(EstadoAlquiler.ACTIVE);

        return alquilerRepository.save(alquiler);
    }

    public void devolver(Long id) {
        Alquiler alquiler = alquilerRepository.findById(id).orElseThrow();
        alquiler.setReturnDate(LocalDateTime.now());
        alquiler.setStatus(EstadoAlquiler.COMPLETED);

        Coche coche = alquiler.getCoche();
        coche.setAvalible(true);
        cocheRepository.save(coche);

        alquilerRepository.save(alquiler);
    }

    public List<Alquiler> historial(Long userId) {
        return alquilerRepository.findByUsuarioId(userId);
    }
}