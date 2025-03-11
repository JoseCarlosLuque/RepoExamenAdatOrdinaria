package com.example.ExamenAdatJCarlos.Controller;

import com.example.ExamenAdatJCarlos.Model.Usuario;
import com.example.ExamenAdatJCarlos.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/users") // Esta es la ruta base para este controlador
    public class UsuarioController {

        private final UsuarioService service;

        @Autowired
        public UsuarioController(UsuarioService service) {
            this.service = service;
        }

        @PostMapping // Ruta: /users
        public Usuario crear(@RequestBody Usuario usuario) {
            return service.crear(usuario);
        }

        @GetMapping // Ruta: /users
        public List<Usuario> listar() {
            return service.listar();
        }

        @GetMapping("/{id}") // Ruta: /users/{id}
        public Usuario obtener(@PathVariable Long id) {
            return service.obtener(id);
        }

        @PutMapping("/{id}") // Ruta: /users/{id}
        public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
            return service.actualizar(id, usuario);
        }

        @DeleteMapping("/{id}") // Ruta: /users/{id}
        public void eliminar(@PathVariable Long id) {
            service.eliminar(id);
        }
    }

