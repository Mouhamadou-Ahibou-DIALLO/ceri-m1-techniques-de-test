package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    @Test
    public void testCreateValidPokemon() throws PokedexException  {
        IPokemonFactory iPokemonFactory = PokedexObjectFactory.createMockPokemonFactory();
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 0.85);

        when(iPokemonFactory.createPokemon(25, 50, 60, 3000, 3)).thenReturn(pokemon);

        assertEquals(pokemon, iPokemonFactory.createPokemon(25, 50, 60, 3000, 3));
        assertEquals("Bulbasaur", iPokemonFactory.createPokemon(25, 50, 60, 3000, 3).getName());
    }

    @Test
    public void testCreateInvalidPokemon() throws PokedexException {
        IPokemonFactory iPokemonFactory = PokedexObjectFactory.createMockPokemonFactory();

        when(iPokemonFactory.createPokemon(25, 50, 60, 3000, 3)).thenReturn(null);

        assertNull(iPokemonFactory.createPokemon(25, 50, 60, 3000, 3));
    }
}
