package br.com.mentorama.filmesgabriel.repositories;

import br.com.mentorama.filmesgabriel.entities.Filmes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmesRepository {


    private Filmes filmes;

    private List<Filmes> filmeslst;

    public FilmesRepository (){
        this.filmeslst = new ArrayList<>();

        Filmes filme1 = new Filmes(1, "Titanic", "James Cameron",
                "1997", 10, "TitanicJamesCameronV1997");

        filmeslst.add(filme1);

        Filmes filme2 = new Filmes(2, "Até o Ultimo Homem", "Mel Gibson",
                "2016", 10, "AtéoUltimoHomemMelGibsonV2016");

        filmeslst.add(filme2);
    }

    public List<Filmes> findAll(){
        return filmeslst;
    }

    public Filmes findById(Integer id) {
        return filmeslst.stream()
                .filter(fil -> fil.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void post(Filmes filmes){
        this.filmeslst.add(filmes);
    }
    public Integer count(){
        return filmeslst.size();
    }

}


