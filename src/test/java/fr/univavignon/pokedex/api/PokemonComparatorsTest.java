package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonComparatorsTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    public void setup() {
        pokemon1 = mock(Pokemon.class);
        pokemon2 = mock(Pokemon.class);
    }

    @Test
    public void testCompareByName() {
        when(pokemon1.getName()).thenReturn("Pikachu");
        when(pokemon2.getName()).thenReturn("Bulbasaur");

        int result = PokemonComparators.NAME.compare(pokemon1, pokemon2);
        assertTrue(result > 0);

        int result1 = PokemonComparators.NAME.compare(pokemon1, pokemon1);
        assertEquals(0, result1);

        int result2 = PokemonComparators.NAME.compare(pokemon2, pokemon1);
        assertTrue(result2 < 0);
    }

    @Test
    public void testCompareByIndex() {
        when(pokemon1.getIndex()).thenReturn(1);
        when(pokemon2.getIndex()).thenReturn(2);

        int result = PokemonComparators.INDEX.compare(pokemon1, pokemon2);
        assertTrue(result < 0);

        int result1 = PokemonComparators.INDEX.compare(pokemon1, pokemon1);
        assertEquals(0, result1);

        int result2 = PokemonComparators.INDEX.compare(pokemon2, pokemon1);
        assertTrue(result2 > 0);
    }

    @Test
    public void testCompareByCp() {
        when(pokemon1.getCp()).thenReturn(1000);
        when(pokemon2.getCp()).thenReturn(2000);

        int result = PokemonComparators.CP.compare(pokemon1, pokemon2);
        assertTrue(result < 0);

        int result1 = PokemonComparators.CP.compare(pokemon1, pokemon1);
        assertEquals(0, result1);

        int result2 = PokemonComparators.CP.compare(pokemon2, pokemon1);
        assertTrue(result2 > 0);
    }
}

