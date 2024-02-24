package br.com.jeli.favoritegame.domain;

public class DomainException extends RuntimeException{
    public DomainException(String mensagem) {
        super(mensagem);
    }
}
