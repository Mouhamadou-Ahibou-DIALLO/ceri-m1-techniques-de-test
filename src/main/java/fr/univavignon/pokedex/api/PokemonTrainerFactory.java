package fr.univavignon.pokedex.api;

/**
 * Pokemon trainer factory.
 *
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Factory to use for creating associated pokedex instance.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Pokemon metadata object.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * @param pokemonFactory Factory to use for creating associated pokedex instance.
     * @param pokemonMetadataProvider Pokemon metadata object.
     * Creates a new pokemon trainer factory using the given
     * <code>pokemonFactory</code> and <code>pokemonMetadataProvider</code>.
     */
    public PokemonTrainerFactory(IPokemonFactory pokemonFactory,
                                 IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team,
            IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory
                .createPokedex(pokemonMetadataProvider, pokemonFactory);

        return new PokemonTrainer(name, team, pokedex);
    }
}
