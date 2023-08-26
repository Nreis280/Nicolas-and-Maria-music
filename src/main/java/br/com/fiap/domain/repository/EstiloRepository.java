package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Artista;
import br.com.fiap.domain.entity.Estilo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstiloRepository implements Repository<Estilo,Long>{

    private static List<Estilo>estilos;

    static {
        estilos = new ArrayList<>();

        Estilo trap = new Estilo(1l,"Trap");
        Estilo rap = new Estilo(1l,"Rap");
        Estilo forro = new Estilo(1l,"Forro");
        Estilo funk = new Estilo(1l,"Funk");

        estilos.addAll(Arrays.asList(trap,rap,forro,funk));
    }


    public List<Estilo> findAll() {
        return estilos;
    }


    @Override
    public Estilo findById(Long id) {

        for (int i = 0; i < estilos.size(); i++) {
            if (estilos.get(i).getId().equals(id)) {
                return estilos.get(i);
            }
        }
        return null;
    }

    public List<Estilo> findByName(String texto) {
        List<Estilo> estilosEncontrados = new ArrayList<>();
        for (Estilo a : estilos) {
            if (a.getNome().equalsIgnoreCase(texto)) {
                estilosEncontrados.add(a);
            }
        }
        return estilosEncontrados;
    }

    @Override
    public Estilo persist(Estilo e) {
        e.setId(estilos.size() + 1L);
        estilos.add(e);
        return e;
    }


}
