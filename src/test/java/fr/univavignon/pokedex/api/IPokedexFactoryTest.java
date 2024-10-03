package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {

    @Test
    public void testCreateValidPokedex() {
        IPokedexFactory iPokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        IPokemonMetadataProvider iPokemonMetadataProvider = PokedexObjectFactory.createMockMetadataProvider();
        IPokemonFactory ipokemonFactory = PokedexObjectFactory.createMockPokemonFactory();
        IPokedex iPokedex = PokedexObjectFactory.createMockPokedex();

        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory)).thenReturn(iPokedex);

        assertEquals(iPokedex, iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory));
        assertEquals(iPokedex.getPokemons(), iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory).getPokemons());
    }

    @Test
    public void testCreateInvalidPokedex() {
        IPokedexFactory iPokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        IPokemonFactory ipokemonFactory = PokedexObjectFactory.createMockPokemonFactory();

        when(iPokedexFactory.createPokedex(null, ipokemonFactory)).thenThrow(new IllegalArgumentException("MetadataProvider is null"));

        assertThrows(IllegalArgumentException.class, () -> {
            iPokedexFactory.createPokedex(null, ipokemonFactory);
        });
    }

    @Test
    public void testCreatePokedexWithNullPokemonFactory() {
        IPokedexFactory iPokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        IPokemonMetadataProvider iPokemonMetadataProvider = PokedexObjectFactory.createMockMetadataProvider();

        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, null)).thenThrow(new IllegalArgumentException("PokemonFactory is null"));

        assertThrows(IllegalArgumentException.class, () -> {
            iPokedexFactory.createPokedex(iPokemonMetadataProvider, null);
        });
    }

    @Test
    public void testCreateEmptyPokedex() {
        IPokedexFactory iPokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        IPokemonMetadataProvider iPokemonMetadataProvider = PokedexObjectFactory.createMockMetadataProvider();
        IPokemonFactory ipokemonFactory = PokedexObjectFactory.createMockPokemonFactory();
        IPokedex iPokedex = PokedexObjectFactory.createMockPokedex();

        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory)).thenReturn(iPokedex);
        when(iPokedex.getPokemons()).thenReturn(Collections.emptyList());

        IPokedex createdPokedex = iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory);
        assertTrue(createdPokedex.getPokemons().isEmpty(), "Le Pokedex devrait être vide au départ.");
    }
}
