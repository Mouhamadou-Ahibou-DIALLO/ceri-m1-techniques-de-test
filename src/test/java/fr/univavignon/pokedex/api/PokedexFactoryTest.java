package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokedex iPokedex;

    @BeforeEach
    public void setup() {
        pokemonFactory = PokedexObjectFactory.createMockPokemonFactory();
        pokemonMetadataProvider = PokedexObjectFactory.createMockMetadataProvider();
        iPokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = new PokedexFactory().createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertEquals(iPokedex.getPokemonMetadataProvider(), pokedex.getPokemonMetadataProvider());
        assertEquals(iPokedex.getPokemonFactory(), pokedex.getPokemonFactory());
    }
}
