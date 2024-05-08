package org.antonio;

import org.junit.Test;

import static org.junit.Assert.*;

import org.antonio.Model.Heroe;

public class TestHeroes {

    @Test
    public void testHeroeGet() {
        Heroe ironMan = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo","");
        assertNotNull(ironMan.getNombre());
        assertTrue(ironMan.getSuperpoderes().equals("Traje de alta tecnología"));
        assertEquals("Iron Man", ironMan.getNombre());
    }

    @Test
    public void testHeroeSet() {
        Heroe spiderman = new Heroe(null, null, null,null);
        spiderman.setNombre("Spider-Man");;
        assertEquals(spiderman.getNombre(), "Spider-Man");
    }
}

