package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTrainerFactoryTest {

    private PokemonMetadata bulbasaur;
    private PokemonMetadata aquali;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokemonFactory pokemonFactory;
    IPokedex iPokedex;
    IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setup() {
        bulbasaur = new PokemonMetadata(0,
                "Bulbasaur", 126, 126, 90);
        aquali = new PokemonMetadata(133,
                "Aquali", 186, 168, 260);

        List<PokemonMetadata> pokemonMetadataList = List.of(bulbasaur, aquali);
        pokemonMetadataProvider = new PokemonMetadataProvider(pokemonMetadataList);
        pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
        pokemonTrainerFactory = new PokemonTrainerFactory(pokemonFactory, pokemonMetadataProvider);
        iPokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);;
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = new PokemonTrainer("Trainer", Team.MYSTIC, iPokedex);
        assertEquals(trainer.getName(), pokemonTrainerFactory.createTrainer("Trainer", Team.MYSTIC, new PokedexFactory()).getName());
    }
}
