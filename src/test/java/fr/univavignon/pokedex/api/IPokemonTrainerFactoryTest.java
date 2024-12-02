package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    @Test
    public void createTrainerIsValid() {
        IPokemonTrainerFactory pokemonTrainerFactory = PokedexObjectFactory.createMockTrainerFactory();
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        IPokedexFactory pokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        PokemonTrainer pokemonTrainer = PokedexObjectFactory.createPokemonTrainer("Momo", Team.INSTINCT, pokedex);

        when(pokemonTrainerFactory.createTrainer("Momo", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);

        assertEquals("Momo", pokemonTrainer.getName());
        assertEquals(pokemonTrainer.toString(), "PokemonTrainer{" + "name='"
                + pokemonTrainer.getName() + '\'' + ", team=" + pokemonTrainer.getTeam() +
                ", pokedex=" + pokemonTrainer.getPokedex() + '}');
    }

    @Test
    public void trainerHasCorrectPokedex() {
        IPokemonTrainerFactory pokemonTrainerFactory = PokedexObjectFactory.createMockTrainerFactory();
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        IPokedexFactory pokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        PokemonTrainer pokemonTrainer = PokedexObjectFactory.createPokemonTrainer("Iniesta", Team.INSTINCT, pokedex);

        when(pokemonTrainerFactory.createTrainer("Iniesta", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);

        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Iniesta", Team.INSTINCT, pokedexFactory);
        assertSame(pokedex, createdTrainer.getPokedex());
    }

    @Test
    public void createdTrainerHasCorrectValues() {
        IPokemonTrainerFactory pokemonTrainerFactory = PokedexObjectFactory.createMockTrainerFactory();
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        IPokedexFactory pokedexFactory = PokedexObjectFactory.createMockPokedexFactory();
        PokemonTrainer pokemonTrainer = PokedexObjectFactory.createPokemonTrainer("Xavi", Team.INSTINCT, pokedex);

        when(pokemonTrainerFactory.createTrainer("Xavi", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);

        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Xavi", Team.INSTINCT, pokedexFactory);
        assertEquals("Xavi", createdTrainer.getName());
        assertEquals(Team.INSTINCT, createdTrainer.getTeam());
    }


}
