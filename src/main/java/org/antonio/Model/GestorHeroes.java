package org.antonio.Model;

import org.antonio.Exception.HeroeNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class GestorHeroes {
    private List<Heroe> heroes;

    public GestorHeroes() {
        this.heroes = new ArrayList<>();
    }

    public void agregarHeroe(Heroe heroe) {
        this.heroes.add(heroe);
    }

    public Heroe buscarHeroe(String nombre) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getNombre().equals(nombre)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(nombre);
    }

    public Heroe buscarHeroePorSuperpoder(String superpoder) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getSuperpoderes().equals(superpoder)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(superpoder);
    }

    public List<Heroe> getHeroes() {
        return heroes;
    }

    public void eliminarHeroe (String nombre) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getNombre().equals(nombre)) {
                heroes.remove(i);
            }
        }
    }

    public void actualizarHeroe(Heroe heroeActualizado) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getNombre().equals(heroeActualizado.getNombre())) {
                heroes.get(i).setDescripcion(heroeActualizado.getDescripcion());
                heroes.get(i).setSuperpoderes(heroeActualizado.getSuperpoderes());
                heroes.get(i).setBiografia(heroeActualizado.getBiografia());
            }
        }
    }

    public String listarHeroes() {

        String listaHeroes = "";

        for (int i = 0; i < heroes.size()-1; i++) {
            listaHeroes += heroes.get(i).getNombre() + ", ";
        }

        listaHeroes += heroes.get(heroes.size() - 1).getNombre();

        return listaHeroes;
    }
}
