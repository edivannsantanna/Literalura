package com.alura.literalura;

import com.alura.literalura.modules.*;
import com.alura.literalura.repository.LivroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConverteDados;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private LivroRepository livroRepository;
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    public Principal(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void exibeMenu() {
        System.out.println("\nBem vindo(a) ao Literalura!");

        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    
                    Escolha uma opção:
                    1- Buscar livro pelo titulo
                    2- Listar livros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos em um determinado ano
                    5- Listar livros em um determinado idioma
                    
                    0 - Sair
                    """;

            System.out.println(menu);

            try {
                opcao = leitura.nextInt();
                leitura.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida");
                leitura.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmUmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosEmUmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Digite o nome do livro que deseja buscar:");
        var nomeDoLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeDoLivro.replace(" ", "%20"));

        DadosBusca dadosBusca = conversor.obterDados(json, DadosBusca.class);

        Optional<DadosLivro> dadoslivro = dadosBusca.results().stream()
                .findFirst();

        if(dadoslivro.isPresent()){
            var livroEncontrado = dadoslivro.get();
            Livro livro = new Livro(livroEncontrado);

            DadosAutor dadosAutor = livroEncontrado.autores().stream()
                    .findFirst().get();

            Optional<Autor> buscaAutor = livroRepository.findByNome(dadosAutor.name());
            if(buscaAutor.isPresent()){
                var autorEncontrado = buscaAutor.get();
                persistirLivro(livro, autorEncontrado);
            } else {
                Autor autor = new Autor(dadosAutor);
                persistirLivro(livro, autor);
            }
        } else {
            System.out.println("Livro não encontrado");
        }

    }
    private void listarLivrosRegistrados(){
        List<Livro> livros = livroRepository.listarLivrosRegistrados();
        livros.forEach(System.out::println);
    }
    private void listarAutoresRegistrados(){
        List<Autor> autores = livroRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivosEmUmDeterminadoAno(){
        System.out.println("Digite o ano que deseja buscar:");
        var ano = leitura.nextInt();
        leitura.nextLine();
        List<Autor> autores = livroRepository.listarAutoresVivosEmUmDeterminadoAno(ano);
        autores.forEach(System.out::println);
    }

    private void listarLivrosEmUmDeterminadoIdioma(){
        System.out.println("""
                Digite o idioma que deseja buscar:
                pt - Português
                en - Inglês
                fr - Francês
                es - Espanhol
                """);
        var idioma = leitura.nextLine();
        TipoIdioma tipoIdioma = TipoIdioma.fromString(idioma);
        List<Livro> livros = livroRepository.listarLivrosEmUmDeterminadoIdioma(tipoIdioma);
        livros.forEach(System.out::println);
    }

    private void persistirLivro(Livro livro, Autor autor){
        livro.setAutor(autor);
        autor.getLivros().add(livro);
        livroRepository.save(autor);
        System.out.println("\nLivro registrado!\n" + livro);
    }

}
