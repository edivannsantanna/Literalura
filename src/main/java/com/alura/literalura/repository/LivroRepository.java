package com.alura.literalura.repository;

import com.alura.literalura.modules.Autor;
import com.alura.literalura.modules.Livro;
import com.alura.literalura.modules.TipoIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String name);

    @Query("SELECT l FROM Autor a JOIN a.livros l")
    List<Livro> listarLivrosRegistrados();

    @Query("SELECT a FROM Autor a WHERE a.anoDeNascimento <= :ano AND a.anoDeFalecimento >= :ano")
    List<Autor> listarAutoresVivosEmUmDeterminadoAno(int ano);

    @Query("SELECT l FROM Autor a JOIN a.livros l WHERE l.tipoIdioma = :tipoIdioma")
    List<Livro> listarLivrosEmUmDeterminadoIdioma(TipoIdioma tipoIdioma);
}
