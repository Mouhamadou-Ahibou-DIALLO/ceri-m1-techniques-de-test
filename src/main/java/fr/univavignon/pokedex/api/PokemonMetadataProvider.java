package fr.univavignon.pokedex.api;

import java.util.List;

/**
 * PokemonMetadataProvider class.
 *
 * @author fv
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * List of pokemon metadata.
     */
    private final List<PokemonMetadata> pokemonMetadatas;

    /**
     * Default constructor.
     *
     * @param pokemonMetadatas List of pokemon metadata.
     */
    public PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadatas) {
        this.pokemonMetadatas = pokemonMetadatas;
    }

    /**
     * Retrieves and returns the metadata for the pokemon denoted by the given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= pokemonMetadatas.size()) {
            throw new PokedexException("Index invalid: " + index);
        }

        return pokemonMetadatas.get(index);
    }

    /**
     * Returns a string representation of the PokemonMetadataProvider.
     *
     * @return A string containing the list of pokemon metadata.
     */
    @Override
    public String toString() {
        return "PokemonMetadataProvider{" +
                "pokemonMetadatas=" + pokemonMetadatas +
                '}';
    }
}
