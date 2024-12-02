package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void setup() {
        PokemonMetadata bulbizarre = new PokemonMetadata(0,
                "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133,
                "Aquali", 186, 168, 260);

        List<PokemonMetadata> metadataList = List.of(bulbizarre, aquali);
        pokemonMetadataProvider = new PokemonMetadataProvider(metadataList);
    }


    @Test
    void getPokemonMetadata() throws PokedexException {
        assertEquals(new PokemonMetadata(133, "Aquali",
                186, 168, 260),
                pokemonMetadataProvider.getPokemonMetadata(1));
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(10));
    }

    @Test
    void testToString() {
        assertEquals("PokemonMetadataProvider{pokemonMetadatas=[PokemonMetadata{index=0," +
                " name='Bulbizarre', " + "attack=126, defense=126, stamina=90}, PokemonMetadata{index=133," +
                " name='Aquali', attack=186, defense=168, stamina=260}]}", pokemonMetadataProvider.toString());
    }
}
