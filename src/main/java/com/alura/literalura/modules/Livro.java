package com.alura.literalura.modules;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String nomeAutor;
    @Enumerated(EnumType.STRING)
    private TipoIdioma tipoIdioma;
    private Integer numeroDeDownloads;

    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.nomeAutor = dadosLivro.autores().stream()
                .findFirst()
                .get()
                .name();
        this.tipoIdioma = TipoIdioma.fromString(dadosLivro.idiomas().stream()
                .findFirst()
                .get());
        this.numeroDeDownloads = dadosLivro.numeroDeDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public TipoIdioma getTipoIdioma() {
        return tipoIdioma;
    }

    public void setTipoIdioma(TipoIdioma tipoIdioma) {
        this.tipoIdioma = tipoIdioma;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n_________Livro_________" +
                "\nTitulo: " + titulo +
                "\nAutor: " + nomeAutor +
                "\nTipoIdioma: " + tipoIdioma +
                "\nNumero De Downloads: " + numeroDeDownloads;
    }
}
