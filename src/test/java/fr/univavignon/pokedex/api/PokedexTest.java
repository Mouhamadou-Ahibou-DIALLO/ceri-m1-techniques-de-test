package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokedexTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;
    private Pokemon pokemon;
    private Pokemon pokemon2;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;

    @BeforeEach
    public void setup() {
        bulbizarre = new PokemonMetadata(0,
                "Bulbasaur", 126, 126, 90);
        aquali = new PokemonMetadata(133,
                "Aquali", 186, 168, 260);

        List<PokemonMetadata> metadataList = List.of(bulbizarre, aquali);
        pokemonMetadataProvider = new PokemonMetadataProvider(metadataList);

        pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 2000, 60, 3000, 3, 56.99999999999999);
        pokemon2 = new Pokemon(2, "Bulbasaur2", 125, 125, 100, 500, 20, 5000, 5, 0.8);

        pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon2);
        assertEquals(3, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.addPokemon(pokemon2));
        assertEquals(1, pokedex.addPokemon(pokemon));
    }

    @Test
    public void testGetPokemonWithId() throws PokedexException {
        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon2);
        assertEquals(pokemon, pokedex.getPokemon(1));
        assertEquals(pokemon2, pokedex.getPokemon(2));
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(3));
    }

    @Test
    public void testGetListPokemons() {
        pokedex.addPokemon(pokemon);
        Pokemon pokemonData = new Pokemon(1, "Bulbasaur", 126, 126, 90, 2000,
                60, 3000, 3, 56.99999999999999);
        List<Pokemon> pokemonList = List.of(pokemonData);
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemons() {
        Comparator<Pokemon> order = PokemonComparators.INDEX;
        pokedex.addPokemon(pokemon2);
        pokedex.addPokemon(pokemon);
        List<Pokemon> pokemonList = List.of(pokemon, pokemon2);
        assertEquals(pokemonList, pokedex.getPokemons(order));
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemonData = new Pokemon(0, "Bulbasaur", 126, 126, 90, 2000, 60, 3000, 3, 56.99999999999999);
        assertEquals(pokemonData, pokedex.createPokemon(0, 2000, 60, 3000, 3));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertEquals(aquali, pokedex.getPokemonMetadata(1));
        assertEquals(bulbizarre, pokedex.getPokemonMetadata(0));
    }
}
