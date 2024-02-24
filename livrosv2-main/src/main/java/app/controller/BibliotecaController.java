package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")

public class BibliotecaController {
    
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca) {
        try {
            String mensagem = this.bibliotecaService.save(biblioteca);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<String>("ERRO! " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<List<Biblioteca>> listAll() {
        try {
            List<Biblioteca> list = this.bibliotecaService.listAll();
            return new ResponseEntity<List<Biblioteca>>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<List<Biblioteca>>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Biblioteca biblioteca) {
        try {
            String message = this.bibliotecaService.delete(biblioteca);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<String> put(@RequestBody Biblioteca biblioteca) {
        try {
            String message = this.bibliotecaService.update(biblioteca);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@RequestBody int id) {
        try {
            Biblioteca biblioteca = this.bibliotecaService.findById(id);
            if (biblioteca != null) {
                return new ResponseEntity<Biblioteca>(biblioteca, HttpStatus.OK);
            } else {
                return new ResponseEntity<Biblioteca>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<Biblioteca>(HttpStatus.BAD_REQUEST);
        }
    }
}
