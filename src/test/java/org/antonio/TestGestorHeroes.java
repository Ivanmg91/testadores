package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Before;
import org.junit.Test;

public class TestGestorHeroes {
    
    Heroe ironMan = null;
    Heroe spiderman = null;
    Heroe capitanAmerica = null;
    Heroe thor = null;
    Heroe viudanegra = null;
    GestorHeroes gestorHeroes = null;

    @Before //PARA EL EXAMEN
    public void setUp() {
        ironMan = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", null);
        spiderman =new Heroe("Spiderman", "Sentido arácnido, trepador", "Tímido estudiante de secundaria", null);
        capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", null);
        thor = new Heroe("Thor", "Martillo", "Su padre creo que era el dios del trueno", null);
        viudanegra = new Heroe("Viuda Negra", "No sé me, me tengo que ver la pelicula", "Ni idea", null);


        gestorHeroes = new GestorHeroes();
        // Agregar algunos heroes
        gestorHeroes.agregarHeroe(ironMan);
        gestorHeroes.agregarHeroe(spiderman);
        //gestorHeroes.agregarHeroe(capitanAmerica);
        gestorHeroes.agregarHeroe(thor);
        gestorHeroes.agregarHeroe(viudanegra);
    }

    @Test
    public void testBuscarHeroe() throws HeroeNoEncontradoException  {
        assertEquals(gestorHeroes.buscarHeroe("Iron Man"), ironMan);
        assertTrue(gestorHeroes.buscarHeroe("Iron Man") == ironMan);
    }

    @Test
    public void agregarHeroe() {
        GestorHeroes gestorHeroes2 = new GestorHeroes();
        gestorHeroes2.agregarHeroe(capitanAmerica);
        assertTrue(gestorHeroes2.getHeroes().size() == 1);
        assertNotNull(gestorHeroes2);
    }


    @Test(expected = HeroeNoEncontradoException.class)
    public void testDivideByZero() throws HeroeNoEncontradoException {
        gestorHeroes.buscarHeroe("Capitán América"); //Capitán América no esta en gestorHeroes, por lo tanto salta la excepción y el test sale correcto.S
    }

    @Test
    public void testActualizacionHeroe() throws HeroeNoEncontradoException {
        GestorHeroes gestorheroes = new GestorHeroes();
        gestorheroes.agregarHeroe(capitanAmerica);

        capitanAmerica.setDescripcion("Héroe de varias películas de Marvel");
        assertNotNull(gestorheroes.buscarHeroe("Capitán América").getBiografia());
        assertNotEquals("", gestorheroes.buscarHeroe("Capitán América").getDescripcion());
    }

    @Test
    public void testEliminarHeroe() {
        GestorHeroes gestorHeroes3 = new GestorHeroes();
        gestorHeroes3.agregarHeroe(spiderman);
        gestorHeroes3.eliminarHeroe("Spider-Man");

        assertFalse(gestorHeroes3.getHeroes().contains(spiderman));
        assertTrue(gestorHeroes3.getHeroes().size() == 0);
    }

    @Test
    public void testAgregarVariosHeroes() {
        GestorHeroes gestorHeroes = new GestorHeroes();
        gestorHeroes.agregarHeroe(capitanAmerica);
        gestorHeroes.agregarHeroe(spiderman);

        assertTrue(gestorHeroes.getHeroes().size() > 1);
        assertFalse(gestorHeroes.getHeroes().isEmpty());
    }

    @Test
    public void testBuscarHeroePorSuperpoder() {
        assertEquals("Traje de alta tecnología", ironMan.getSuperpoderes());
        assertTrue("Sentido arácnido, trepador".equals(spiderman.getSuperpoderes()));
    }

    @Test
    public void testActualizaTodoElHeroe() throws HeroeNoEncontradoException {
        ironMan = new Heroe("Iron Man", "Traje guapisimo", "Millonario y filántropo", "Tiene un traje y puede volar con el");
        gestorHeroes.actualizarHeroe(ironMan);

        assertNotEquals("Traje de alta tecnología", gestorHeroes.buscarHeroe("Iron Man").getSuperpoderes());
        assertFalse("Traje de alta tecnología".equals(gestorHeroes.buscarHeroe("Iron Man").getSuperpoderes()));
    }

    @Test
    public void listarHeroes() {

        assertEquals(gestorHeroes.listarHeroes(), "Iron Man, Spiderman, Thor, Viuda Negra");
        assertTrue(gestorHeroes.listarHeroes().equals("Iron Man, Spiderman, Thor, Viuda Negra"));
    }
}
