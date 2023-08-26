package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Artista;
import br.com.fiap.domain.entity.Estilo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistaRepository implements Repository<Artista, Long> {

    private static List<Artista> artistas;

    static {
        artistas = new ArrayList<>();

        Artista teto = new Artista(1L, "Teto" );
        Artista matue= new Artista(2L, "Matue" );
        Artista veigh = new Artista(3L, "Veigh" );
        Artista ryan = new Artista(4L, "Ryan SP");

        artistas.addAll(Arrays.asList(teto,matue,veigh,ryan));
    }


    public List<Artista> findAll() {
        return artistas;
    }


    @Override
    public Artista findById(Long id) {

        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getId().equals(id)) {
                return artistas.get(i);
            }
        }
        return null;
    }

    public List<Artista> findByName(String texto) {
        List<Artista> ArtistasEncontrados = new ArrayList<>();
        for (Artista a : artistas) {
            if (a.getNome().equalsIgnoreCase(texto)) {
                ArtistasEncontrados.add(a);
            }
        }
        return ArtistasEncontrados;
    }

    @Override
    public Artista persist(Artista a) {
        a.setId(artistas.size() + 1L);
        artistas.add(a);
        return a;
    }

}