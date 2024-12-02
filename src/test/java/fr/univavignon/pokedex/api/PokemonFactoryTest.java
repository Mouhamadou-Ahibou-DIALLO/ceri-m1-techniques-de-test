package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() {
        PokemonMetadata bulbizarre = new PokemonMetadata(0,
                "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133,
                "Aquali", 186, 168, 260);

        List<PokemonMetadata> metadataList = List.of(bulbizarre, aquali);
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(metadataList);
        pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 15, 10, 10, 10);
        assertEquals(pokemon, pokemonFactory.createPokemon(0, 15, 10, 10, 10));
        assertEquals("Bulbizarre", pokemon.getName());
    }
}
