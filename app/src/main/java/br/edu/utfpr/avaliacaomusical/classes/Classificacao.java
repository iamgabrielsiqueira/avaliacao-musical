package br.edu.utfpr.avaliacaomusical.classes;

import androidx.annotation.NonNull;

public final class Classificacao {
    private int nota;
    private String comentario;

    public Classificacao(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @NonNull
    @Override
    public String toString() {
        return "Classificacao{" +
                "nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
