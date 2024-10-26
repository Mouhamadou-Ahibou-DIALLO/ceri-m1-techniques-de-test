package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemons = new ArrayList<>();
    private final PokemonMetadataObject pokemonMetadataObject;
    private final PokemonFactory pokemonFactory;

    public Pokedex(PokemonMetadataObject pokemonMetadataObject, PokemonFactory pokemonFactory) {
        this.pokemonMetadataObject = pokemonMetadataObject;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() < 0 || pokemon.getIndex() > id) {
                throw new PokedexException("Index invalid");
            }
            return pokemon;
        }
        return null;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return pokemons.stream().sorted(order).toList();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust,
                                 int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataObject.getPokemonMetadata(index);
    }
}
