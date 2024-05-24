package br.edu.utfpr.avaliacaomusical.classes;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import java.util.List;

public final class Artista {
    private String nome;
    private TipoArtista tipoArtista;
    private List<GeneroMusical> generosMusicais;
    private Pais pais;

    public Artista(String nome, TipoArtista tipoArtista, List<GeneroMusical> generos, Pais pais) {
        this.nome = nome;
        this.tipoArtista = tipoArtista;
        this.generosMusicais = generos;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public List<GeneroMusical> getGenerosMusicais() {
        return generosMusicais;
    }

    public void setGenerosMusicais(List<GeneroMusical> generosMusicais) {
        this.generosMusicais = generosMusicais;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @NonNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", tipoArtista=" + tipoArtista +
                ", generosMusicais=" + generosMusicais +
                ", pais=" + pais +
                '}';
    }
}
