package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    @Test
    public void testSize() {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        when(pokedex.size()).thenReturn(1);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemonFirstTest() {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        Pokemon pokemon = PokedexObjectFactory.createPokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 0.85);

        when(pokedex.addPokemon(pokemon)).thenReturn(1);

        assertEquals(1, pokedex.addPokemon(pokemon));
        assertEquals(0, pokedex.getPokemons().size());
    }

    @Test
    public void testAddPokemonSecondTest() {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        Pokemon pokemon = PokedexObjectFactory.createPokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 0.85);

        when(pokedex.addPokemon(pokemon)).thenReturn(1);
        when(pokedex.size()).thenReturn(1);
        when(pokedex.getPokemons()).thenReturn(Collections.singletonList(pokemon));

        assertEquals(1, pokedex.addPokemon(pokemon));
        assertEquals(1, pokedex.size());
        assertEquals(1, pokedex.getPokemons().size());
        assertEquals("Bulbasaur", pokedex.getPokemons().get(0).getName());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        Pokemon pokemon = PokedexObjectFactory.createPokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 0.85);

        when(pokedex.getPokemon(1)).thenReturn(pokemon);

        assertEquals("Bulbasaur", pokedex.getPokemon(1).getName());
        assertEquals(pokemon.getCp(), pokedex.getPokemon(1).getCp());
        assertEquals(pokemon.getDefense(), pokedex.getPokemon(1).getDefense());
        assertEquals(pokemon.getHp(), pokedex.getPokemon(1).getHp());
        assertEquals(pokemon.getCandy(), pokedex.getPokemon(1).getCandy());
        assertEquals(pokemon.getIndex(), pokedex.getPokemon(1).getIndex());
        assertEquals(pokemon.getStamina(), pokedex.getPokemon(1).getStamina());
        assertEquals(pokemon.getDust(), pokedex.getPokemon(1).getDust());
        assertEquals(pokemon.getIv(), pokedex.getPokemon(1).getIv());
    }

    @Test
    public void testGetPokemons() {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        Pokemon pokemon = PokedexObjectFactory.createPokemon(1, "Bulbasaur", 126, 126, 90, 2000, 60, 3000, 3, 0.85);
        Pokemon pokemon2 = PokedexObjectFactory.createPokemon(2, "Bulbasaur2", 125, 125, 100, 500, 20, 5000, 5, 0.8);
        List<Pokemon> pokemons = List.of(pokemon, pokemon2);

        when(pokedex.getPokemons()).thenReturn(pokemons);

        assertEquals(2, pokedex.getPokemons().size());
        assertEquals("Bulbasaur", pokedex.getPokemons().get(0).getName());
        assertEquals(125, pokedex.getPokemons().get(1).getAttack());
        assertEquals(100, pokedex.getPokemons().get(1).getStamina());
    }

    @Test
    public void testGetPokemonsComparators() {
        IPokedex pokedex = PokedexObjectFactory.createMockPokedex();
        Pokemon pokemon = PokedexObjectFactory.createPokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 0.85);
        Pokemon pokemon2 = PokedexObjectFactory.createPokemon(2, "Bulbasaur2", 125, 125, 100, 2000, 20, 5000, 5, 0.8);

        List<Pokemon> pokemons = List.of(pokemon, pokemon2);
        List<Pokemon> sortedListPokemons = pokemons.stream().sorted(Comparator.comparing(Pokemon::getName)).toList();
        Comparator<Pokemon> order = Comparator.comparing(Pokemon::getName);

        when(pokedex.getPokemons(order)).thenReturn(sortedListPokemons);
        List<Pokemon> retrievedPokemons = pokedex.getPokemons(order);

        assertEquals(2, retrievedPokemons.size());
        assertEquals(sortedListPokemons, retrievedPokemons);
    }
}
