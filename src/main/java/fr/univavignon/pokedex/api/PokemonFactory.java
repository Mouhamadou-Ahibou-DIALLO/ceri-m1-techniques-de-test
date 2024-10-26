package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final PokemonMetadataObject pokemonMetadataObject;

    private static final int MAX_ATTACK = 200;
    private static final int MAX_DEFENSE = 200;
    private static final int MAX_STAMINA = 200;

    public PokemonFactory(PokemonMetadataObject pokemonMetadataObject) {
        this.pokemonMetadataObject = pokemonMetadataObject;
    }

    private double calculateIv(int index) throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataObject.getPokemonMetadata(index);

        return (((double) metadata.getAttack() / MAX_ATTACK +
                (double) metadata.getDefense() / MAX_DEFENSE +
                (double) metadata.getStamina() / MAX_STAMINA) / 3.0) * 100;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust,
                                 int candy) throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataObject.getPokemonMetadata(index);
        String name = metadata.getName();
        int attack = metadata.getAttack();
        int defense = metadata.getDefense();
        int stamina = metadata.getStamina();
        double iv = calculateIv(index);
        System.out.println(iv + "% iv");
        return new Pokemon(index, name, attack, defense, stamina,
                cp, hp, dust, candy, iv);
    }
}
