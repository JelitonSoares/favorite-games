package br.com.jeli.favoritegame;

import br.com.jeli.favoritegame.domain.DomainException;
import br.com.jeli.favoritegame.domain.jogosfavoritos.JogosFavoritosService;
import br.com.jeli.favoritegame.domain.usuario.UsuarioAtual;
import br.com.jeli.favoritegame.domain.usuario.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FavoriteGamesApplication {

    //---Classe que representa o menu da aplicação---


    private static UsuarioService usuarioService = new UsuarioService();
    private static UsuarioAtual usuarioAtual = new UsuarioAtual();
    private static JogosFavoritosService jogosService = new JogosFavoritosService(usuarioAtual);
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");


    //Menu principal da aplicação onde contém as opções de entrar com um usuario ja existente ou cadastrar um usuario
    public static void main(String[] args) {
        Integer opcao = exibirMenu();
        while(opcao != 3) {
            try{
                switch (opcao){
                    case 1:
                        entrar();
                        break;
                    case 2:
                        cadastrar();
                        break;
                }
            }catch (DomainException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Pressione enter para voltar ao menu principal");
                scanner.next();
            }
            opcao = exibirMenu();
        }

        System.out.println("Obrigado por usar o FavoriteGames! Volte sempre:)");
        System.out.println("Finalizando...");
    }

    //Método que exibe o menu principal
    private static int exibirMenu() {
        String menu = """
                ------Bem vindo ao FavoriteGames------
                1 - Entrar
                2 - Cadastrar usuario
                3 - Sair
                """;
        System.out.println(menu);
        return scanner.nextInt();
    }

    //Método que permite um usuario entrar na sua conta
    private static void entrar(){
        System.out.println("Digite seu ID: ");
        String id = scanner.next();

        System.out.println("Digite sua senha: ");
        String senha = scanner.next();

        Boolean entrou = usuarioService.entrar(id, senha);
        usuarioAtual.setUsuario(usuarioService.getUsuarioAtual());
        menuEntrar(entrou);
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

    //Menu secundário da aplicação
    private static void menuEntrar(Boolean entrou) {
        System.out.println("*-*-*-*-*-*-*- Bem vindo " + nomeUsuarioAtual() + " *-*-*-*-*-*-*-");
        System.out.println("Pressione enter para ir ao menu principal");
        scanner.next();
        while(entrou){
            Integer opcao = exibirMenuEntrar();
            try {
                switch (opcao) {
                    case 1:
                        listarJogos();
                        break;
                    case 2:
                        cadastrarJogos();
                        break;
                    case 3:
                        excluirJogos();
                        break;
                    case 4:
                        atualizarJogos();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        entrou = false;
                        break;
                }
            } catch (DomainException e) {
                System.out.println("Erro:" + e.getMessage());
                System.out.println("Pressione enter para voltar ao menu principal!!");
                scanner.next();
            }

        }

    }

    //Método que exibe o menu secundário
    private static int exibirMenuEntrar() {
        String menu = """
                1 - Listar jogos favoritos
                2 - Cadastrar jogos favoritos
                3 - Excluir jogos favoritos
                4 - Atualizar jogo favorito
                5 - Sair
                """;

        System.out.println(menu);
        return scanner.nextInt();
    }

    private static void listarJogos() {
        List<String> jogos = jogosService.listar();

        jogos.forEach(System.out::println);

        System.out.println("Aperte enter para voltar ao menu!!");
        scanner.next();
    }

    private static void cadastrarJogos(){
        System.out.println("Seus Jogos ficaram em uma lista de 1 a 5");
        System.out.println("Digite seu jogo nº 1: ");
        String jogo1 = scanner.next();
        System.out.println("Digite seu jogo nº 2: ");
        String jogo2 = scanner.next();
        System.out.println("Digite seu jogo nº 3: ");
        String jogo3 = scanner.next();
        System.out.println("Digite seu jogo nº 4: ");
        String jogo4 = scanner.next();
        System.out.println("Digite seu jogo nº 5: ");
        String jogo5 = scanner.next();
        List<String> jogos = new ArrayList<>();

        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);
        jogos.add(jogo4);
        jogos.add(jogo5);

        jogosService.cadastrar(jogos);
        System.out.println("Cadastro realizado com sucesso!!");
        System.out.println("Pressione enter para voltar ao menu");
        scanner.next();
    }

    private static void excluirJogos(){
        System.out.println("Tem certeza que deseja excluir todos os seus jogos favoritos ?");
        String condicao = scanner.next();
        if(condicao.equals("s")) {
            jogosService.excluir();

            System.out.println("Exclusão realizada com sucesso!!");
        }
        System.out.println("Pressione enter para voltar ao menu");
        scanner.next();

    }

    private static void atualizarJogos(){
        System.out.println("Qual posição esta o jogo que você deseja atualizar: ");
        Integer posicao = scanner.nextInt();

        System.out.println("Qual jogo entrará nesta posicção? ");
        String novoJogo = scanner.next();

        jogosService.atualizar(posicao, novoJogo);

        System.out.println("Atualização realizada com sucesso!!");
        System.out.println("Pressione enter para voltar ao menu");
        scanner.next();
    }



    //Método que permite o cadastro de um usuario
    private static void cadastrar(){
        System.out.println("Digite o ID da seu usuario: (Ele deve conter 5 digitos): ");
        String id = scanner.next();

        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite sua senha: (Ela deve conter 8 dígitos): ");
        String senha = scanner.next();

        usuarioService.cadastrar(id, nome, senha);

        System.out.println("Cadastro realizado com sucesso!!");
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

    private static String nomeUsuarioAtual() {
        return usuarioAtual.getNomeUsuarioAtual().split(" ")[0];
    }

}
