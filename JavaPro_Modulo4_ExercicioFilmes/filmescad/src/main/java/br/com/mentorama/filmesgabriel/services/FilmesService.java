package br.com.mentorama.filmesgabriel.services;

import br.com.mentorama.filmesgabriel.entities.Filmes;
import br.com.mentorama.filmesgabriel.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    private Filmes filmes;

    public List<Filmes> findAll() {
        return filmesRepository.findAll();
    }

    public Filmes findById(Integer id) {
        return filmesRepository.findById(id);
    }

    public Integer post(Filmes filmes) {
        if (filmes.getId() == null) {
            filmes.setId(filmesRepository.count() + 1);
        }

        filmesRepository.post(filmes);
        return filmes.getId();
    }
}
