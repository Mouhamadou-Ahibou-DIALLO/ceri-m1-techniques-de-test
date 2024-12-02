package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = PokedexObjectFactory.createMockMetadataProvider();
        PokemonMetadata metadata = PokedexObjectFactory.createPokemonMetadata(1, "Bulbasaur", 126, 126, 90);

        when(metadataProvider.getPokemonMetadata(1)).thenReturn(metadata);

        assertEquals("Bulbasaur", metadataProvider.getPokemonMetadata(1).getName());
        assertEquals(126, metadataProvider.getPokemonMetadata(1).getDefense());
        assertEquals(90, metadataProvider.getPokemonMetadata(1).getStamina());
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = PokedexObjectFactory.createMockMetadataProvider();

        when(metadataProvider.getPokemonMetadata(999)).thenThrow(PokedexObjectFactory.createPokedexException("Invalid index"));

        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(999);
        });
    }

    @Test
    public void testEuqalsAndHashcode() {
        PokemonMetadata metadata = PokedexObjectFactory.createPokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        PokemonMetadata metadata1 = PokedexObjectFactory.createPokemonMetadata(1, "Bulbasaur", 126, 126, 90);

        assertTrue(metadata.equals(metadata1));
        assertEquals(metadata.hashCode(), metadata1.hashCode());

        assertFalse(metadata.equals(null));
        assertTrue(metadata.getIndex() == metadata1.getIndex());
        assertTrue(metadata.getName().equals(metadata1.getName()));
        assertTrue(metadata.getDefense() == metadata1.getDefense());
        assertTrue(metadata.getStamina() == metadata1.getStamina());
        assertTrue(metadata.getAttack() == metadata1.getAttack());
    }
}
