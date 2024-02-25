package br.com.jeli.favoritegame;

import br.com.jeli.favoritegame.domain.DomainException;
import br.com.jeli.favoritegame.domain.usuario.UsuarioService;

import java.util.Scanner;

public class FavoriteGamesApplication {

    //---Classe que representa o menu da aplicação---


    private static UsuarioService service = new UsuarioService();
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

        Boolean entrou = service.entrar(id, senha);
        menuEntrar(entrou);
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

    //Menu secundário da aplicação
    private static void menuEntrar(Boolean entrou) {
        System.out.println("*-*-*-*-*-*-*-Bem vindo Fulando*-*-*-*-*-*-*-");
        System.out.println("Pressione enter para ir ao menu principal");
        scanner.next();
        while(entrou){
            Integer opcao = exibirMenuEntrar();
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

        }

    }

    //Método que exibe o menu secundário
    private static int exibirMenuEntrar() {
        String menu = """
                1 - Listar jogos favoritos
                2 - Cadastrar jogos favoritos
                3 - Excluir jogo favorito
                4 - Atualizar jogo favorito
                5 - Sair
                """;

        System.out.println(menu);
        return scanner.nextInt();
    }

    private static void listarJogos() {

    }

    private static void cadastrarJogos(){

    }

    private static void excluirJogos(){

    }

    private static void atualizarJogos(){

    }



    //Método que permite o cadastro de um usuario
    private static void cadastrar(){
        System.out.println("Digite o ID da seu usuario: (Ele deve conter 5 digitos): ");
        String id = scanner.next();

        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite sua senha: (Ela deve conter 8 dígitos): ");
        String senha = scanner.next();

        service.cadastrar(id, nome, senha);

        System.out.println("Cadastro realizado com sucesso!!");
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

}
