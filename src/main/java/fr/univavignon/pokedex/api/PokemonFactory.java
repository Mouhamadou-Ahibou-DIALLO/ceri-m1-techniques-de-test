package fr.univavignon.pokedex.api;

/**
 * Pokemon factory.
 *
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Pokemon metadata object the created pokemon factory will use.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Maximum attack level of the pokemon.
     */
    private static final int MAX_ATTACK = 200;

    /**
     * Maximum defense level of the pokemon.
     */
    private static final int MAX_DEFENSE = 200;

    /**
     * Maximum stamina level of the pokemon.
     */
    private static final int MAX_STAMINA = 200;

    /**
     * Creates a new pokemon factory using the given
     * <code>pokemonMetadataProvider</code>.
     *
     * @param pokemonMetadataProvider Pokemon metadata object the created
     * pokemon factory will use.
     */
    public PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * Calculates the IV (Individual Value) perfection percentage for the pokemon
     * denoted by the given <code>index</code>.
     *
     * @param attack Attack level of the pokemon.
     * @param defense Defense level of the pokemon.
     * @param stamina Stamina level of the pokemon.
     * @return IV perfection percentage of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    private double calculateIv(int attack, int defense, int stamina) {

        return (((double) attack / MAX_ATTACK +
                (double) defense / MAX_DEFENSE +
                (double) stamina / MAX_STAMINA) / 3.0) * 100;
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP (Combat Points).
     * @param hp Pokemon HP (Hit Points).
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust,
                                 int candy) throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(index);

        String name = metadata.getName();
        int attack = metadata.getAttack();
        int defense = metadata.getDefense();
        int stamina = metadata.getStamina();

        double iv = calculateIv(attack, defense, stamina);
        System.out.println(iv + "% iv");
        return new Pokemon(index, name, attack, defense, stamina,
                cp, hp, dust, candy, iv);
    }
}
