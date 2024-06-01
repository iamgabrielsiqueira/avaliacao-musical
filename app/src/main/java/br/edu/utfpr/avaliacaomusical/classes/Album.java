package br.edu.utfpr.avaliacaomusical.classes;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public final class Album {
    private String nome;
    private String dataLancamento; // Ver se é possivel ser classe Date
    private String artista; // Mudar para classe artista ao final do projeto
    private int classificacao; // Mudar para classe classificacao ao final do projeto

    public Album(String nome, String dataLancamento, String artista, int classificacao) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.artista = artista;
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    @NonNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return "Album{" +
                "nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", artista='" + artista + '\'' +
                ", classificacao=" + classificacao +
                '}';
    }
}
