package fr.univavignon.pokedex.api;

import java.util.List;

/**
 * PokemonMetadataObject class.
 *
 * @author fv
 */
public class PokemonMetadataObject implements IPokemonMetadataProvider {

    /**
     * List of pokemon metadata.
     */
    private final List<PokemonMetadata> pokemonMetadatas;

    /**
     * Default constructor.
     *
     * @param pokemonMetadatas List of pokemon metadata.
     */
    public PokemonMetadataObject(List<PokemonMetadata> pokemonMetadatas) {
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
     * Returns a string representation of the PokemonMetadataObject.
     *
     * @return A string containing the list of pokemon metadata.
     */
    @Override
    public String toString() {
        return "PokemonMetadataObject{" +
                "pokemonMetadatas=" + pokemonMetadatas +
                '}';
    }
}
