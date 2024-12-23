package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class. A Pokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 *
 * @author fv
 */
public class Pokedex implements IPokedex {

    /** List of all pokemons in this pokedex. */
    private List<Pokemon> pokemons = new ArrayList<>();

    /**
     * Creates a new pokedex instance using the given
     * <code>metadataProvider</code> and <code>pokemonFactory</code>.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /** Number of pokemon in this pokedex. */
    private static int SIZE = 0;

    /**
     * Creates a new pokedex instance using the given
     * <code>metadataProvider</code> and <code>pokemonFactory</code>.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Creates a new pokedex instance using the given
     * <code>pokemonMetadataProvider</code> and <code>pokemonFactory</code>.
     *
     * @param pokemonMetadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider,
                   IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return SIZE;
    }

    /**
     * Adds the given <code>pokemon</code> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        System.out.println(pokemons.size() + " ::: size");
        SIZE++;
        return pokemon.getIndex();
    }

    /**
     * Locates the pokemon identified by the given <code>id</code>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <code>id</code> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon not found with id: " + id);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list is sorted according to the given comparator.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return pokemons.stream().sorted(order).toList();
    }

    /**
     * Creates a pokemon instance with the given parameters.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP (Combat Points).
     * @param hp Pokemon HP (Hit Points).
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust,
                                 int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retrieves and returns the metadata provider associated with this
     * pokedex instance.
     *
     * @return Metadata provider associated with this pokedex instance.
     */
    @Override
    public IPokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }

    /**
     * Retrieves and returns the factory instance associated with this
     * pokedex instance and used for creating pokemon instances.
     *
     * @return Factory instance associated with this pokedex instance.
     */
    @Override
    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    /**
     * Retrieves and returns the metadata for the pokemon denoted by the given
     * <code>index</code>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
