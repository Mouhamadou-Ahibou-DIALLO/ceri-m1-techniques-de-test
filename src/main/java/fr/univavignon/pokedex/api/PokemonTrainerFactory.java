package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private final IPokemonFactory pokemonFactory;
    private  final  PokemonMetadataObject pokemonMetadataObject;

    public PokemonTrainerFactory(IPokemonFactory pokemonFactory,
                                 PokemonMetadataObject pokemonMetadataObject) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataObject = pokemonMetadataObject;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team,
                                        IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory
                .createPokedex(pokemonMetadataObject, pokemonFactory));
    }
}
