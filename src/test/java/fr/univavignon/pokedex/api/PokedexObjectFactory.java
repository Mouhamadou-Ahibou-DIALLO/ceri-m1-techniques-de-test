package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.*;

public class PokedexObjectFactory {

    public static IPokemonMetadataProvider createMockMetadataProvider() {
        return mock(IPokemonMetadataProvider.class);
    }

    public static IPokemonFactory createMockPokemonFactory() {
        return mock(IPokemonFactory.class);
    }

    public static IPokedexFactory createMockPokedexFactory() {
        return mock(IPokedexFactory.class);
    }

    public static IPokedex createMockPokedex() {
        return mock(IPokedex.class);
    }

    public static IPokemonTrainerFactory createMockTrainerFactory() {
        return mock(IPokemonTrainerFactory.class);
    }

    public static PokemonMetadata createPokemonMetadata(int index, String name, int attack, int defense, int stamina) {
        return new PokemonMetadata(index, name, attack, defense, stamina);
    }

    public static Pokemon createPokemon(int index, String name, int attack, int defense, int stamina, int cp, int hp, int dust, int candy, double iv) {
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }

    public static PokemonTrainer createPokemonTrainer(String name, Team team, IPokedex pokedex) {
        return new PokemonTrainer(name, team, pokedex);
    }

    public static PokedexException createPokedexException(String message) {
        return new PokedexException(message);
    }
}

