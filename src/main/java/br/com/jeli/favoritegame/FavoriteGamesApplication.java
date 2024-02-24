package br.com.jeli.favoritegame;

import java.util.Scanner;

public class FavoriteGamesApplication {

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
                2 - Cadastrar conta
                3 - Sair
                """;
        System.out.println(menu);
        return scanner.nextInt();
    }

    private static void entrar(){
        System.out.println("Entrando");
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

    private static void cadastrar(){
        System.out.println("Cadastrando");
        System.out.println("Pressione qualquer tecla para voltar para o menu");
        scanner.next();
    }

}
