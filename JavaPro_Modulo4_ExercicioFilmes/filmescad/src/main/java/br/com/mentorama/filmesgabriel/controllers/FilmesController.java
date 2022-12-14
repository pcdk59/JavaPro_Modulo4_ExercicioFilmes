package br.com.mentorama.filmesgabriel.controllers;

import br.com.mentorama.filmesgabriel.services.FilmesService;
import br.com.mentorama.filmesgabriel.entities.Filmes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/filmes")
    public class FilmesController {

    @Autowired
    private FilmesService filmesService;


    @GetMapping
    public ResponseEntity<List<Filmes>> findAll() {
        return new ResponseEntity<>(filmesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Filmes findById(@PathVariable("id") Integer id) {
        return filmesService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody Filmes filmes) {

        if (filmesService.findAll().stream().anyMatch(f-> f.getNda()
                .equalsIgnoreCase(filmes.getNda()))){

            throw new ResponseStatusException(HttpStatus.CONFLICT ,
                    "Filme já cadastrado!");
           }
        if (filmes.getNota()<1 || filmes.getNota()>5){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "As notas só podem ser de 1 a 5.");
        }

            Integer id = filmesService.post(filmes);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }

}
