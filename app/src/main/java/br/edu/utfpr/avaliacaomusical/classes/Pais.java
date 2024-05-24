package br.edu.utfpr.avaliacaomusical.classes;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public final class Pais {
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NonNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
