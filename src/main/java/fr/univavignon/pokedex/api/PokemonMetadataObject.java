package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataObject implements IPokemonMetadataProvider {

    private final List<PokemonMetadata> pokemonMetadatas;

    public PokemonMetadataObject(List<PokemonMetadata> pokemonMetadatas) {
        this.pokemonMetadatas = pokemonMetadatas;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0) {
            throw new PokedexException("Index invalid: " + index);
        }

        for (PokemonMetadata pokemonMetadata : pokemonMetadatas) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }

        throw new PokedexException("Pokemon not found for index: " + index);
    }

    @Override
    public String toString() {
        return "PokemonMetadataObject{" +
                "pokemonMetadatas=" + pokemonMetadatas +
                '}';
    }
}
