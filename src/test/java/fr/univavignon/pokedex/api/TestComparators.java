package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.Pokemon;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the PokemonComparators enum.
 */
public class TestComparators {

    @Test
    public void testComparatorByName() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 50, 60, 70, 500, 100, 3000, 50, 80.0);
        Pokemon pokemon2 = new Pokemon(2, "Charmander", 70, 60, 50, 600, 110, 3000, 60, 90.0);
        Pokemon pokemon3 = new Pokemon(3, "Squirtle", 40, 50, 60, 450, 90, 2500, 40, 75.0);

        List<Pokemon> pokemonList = Arrays.asList(pokemon3, pokemon2, pokemon1);
        pokemonList.sort(PokemonComparators.NAME);

        assertEquals("Bulbasaur", pokemonList.get(0).getName());
        assertEquals("Charmander", pokemonList.get(1).getName());
        assertEquals("Squirtle", pokemonList.get(2).getName());
    }

    @Test
    public void testComparatorByIndex() {
        Pokemon pokemon1 = new Pokemon(3, "Bulbasaur", 50, 60, 70, 500, 100, 3000, 50, 80.0);
        Pokemon pokemon2 = new Pokemon(1, "Charmander", 70, 60, 50, 600, 110, 3000, 60, 90.0);
        Pokemon pokemon3 = new Pokemon(2, "Squirtle", 40, 50, 60, 450, 90, 2500, 40, 75.0);

        List<Pokemon> pokemonList = Arrays.asList(pokemon1, pokemon3, pokemon2);
        pokemonList.sort(PokemonComparators.INDEX);

        assertEquals(1, pokemonList.get(0).getIndex());
        assertEquals(2, pokemonList.get(1).getIndex());
        assertEquals(3, pokemonList.get(2).getIndex());
    }

    @Test
    public void testComparatorByCp() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 50, 60, 70, 700, 100, 3000, 50, 80.0);
        Pokemon pokemon2 = new Pokemon(2, "Charmander", 70, 60, 50, 500, 110, 3000, 60, 90.0);
        Pokemon pokemon3 = new Pokemon(3, "Squirtle", 40, 50, 60, 600, 90, 2500, 40, 75.0);

        List<Pokemon> pokemonList = Arrays.asList(pokemon1, pokemon2, pokemon3);
        pokemonList.sort(PokemonComparators.CP);

        assertEquals(500, pokemonList.get(0).getCp());
        assertEquals(600, pokemonList.get(1).getCp());
        assertEquals(700, pokemonList.get(2).getCp());
    }

    @Test
    public void testCompareMethod() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 50, 60, 70, 500, 100, 3000, 50, 80.0);
        Pokemon pokemon2 = new Pokemon(2, "Charmander", 70, 60, 50, 600, 110, 3000, 60, 90.0);

        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) > 0);

        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1) > 0);

        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1) > 0);
    }
}
