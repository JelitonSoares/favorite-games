package br.com.jeli.favoritegame;

import br.com.jeli.favoritegame.domain.usuario.UsuarioService;

import java.util.Scanner;

public class FavoriteGamesApplication {

    private static UsuarioService service = new UsuarioService();
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        Integer opcao = exibirMenu();
        while(opcao != 3) {
            switch (opcao){
                case 1:
                    entrar();
                    break;
                case 2:
                    cadastrar();
                    break;
            }
            opcao = exibirMenu();
        }

        System.out.println("Obrigado por usar o FavoriteGames! Volte sempre:)");
        System.out.println("Finalizando...");
    }

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
