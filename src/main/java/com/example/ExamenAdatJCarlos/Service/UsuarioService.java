package com.example.ExamenAdatJCarlos.Service;

import com.example.ExamenAdatJCarlos.Model.Usuario;
import com.example.ExamenAdatJCarlos.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() { return repository.findAll(); }
    public Usuario obtener(Long id) { return repository.findById(id).orElseThrow(); }
    public Usuario crear(Usuario usuario) { return repository.save(usuario); }
    public Usuario actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }
    public void eliminar(Long id) { repository.deleteById(id); }
}