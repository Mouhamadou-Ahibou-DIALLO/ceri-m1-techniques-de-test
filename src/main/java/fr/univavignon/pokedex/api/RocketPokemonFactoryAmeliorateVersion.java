package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * An optimized implementation of the IPokemonFactory interface provided by Team Rocket.
 * This implementation addresses performance issues, enhances readability, and ensures
 * better error handling.
 */
public class RocketPokemonFactoryAmeliorateVersion
        implements IPokemonFactory {

    private static final Map<Integer, String> index2name
            = initializeIndexToName();
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_STAT = 200;

    /**
     * Initializes the index-to-name mapping for Pokémon.
     */
    private static Map<Integer, String> initializeIndexToName() {
        Map<Integer, String> map = new HashMap<>();
        map.put(-1, "Ash's Pikachu");
        map.put(0, "MISSINGNO");
        map.put(1, "Bulbasaur");
        return Map.copyOf(map);
    }

    /**
     * Generates a random Pokémon stat between 0 and MAX_RANDOM_STAT (inclusive).
     */
    private static int generateRandomStat() {
        return RANDOM.nextInt(MAX_RANDOM_STAT + 1);
    }

    /**
     * Creates a Pokémon instance based on the given parameters.
     *
     * @param index  The index of the Pokémon.
     * @param cp     The combat points of the Pokémon.
     * @param hp     The hit points of the Pokémon.
     * @param dust   The amount of dust required to upgrade the Pokémon.
     * @param candy  The amount of candy required to upgrade the Pokémon.
     * @return The created Pokémon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp,
                                 int dust, int candy) {
        String name = index2name.getOrDefault(index, index2name.get(0));

        int attack, defense, stamina;
        double iv;

        if (index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0.0;
        } else {
            attack = generateRandomStat();
            defense = generateRandomStat();
            stamina = generateRandomStat();
            iv = calculateIv(attack, defense, stamina);
        }

        return new Pokemon(index, name, attack, defense,
                stamina, cp, hp, dust, candy, iv);
    }

    /**
     * Calculates the Individual Value (IV) percentage for a Pokémon.
     *
     * @param attack  The attack stat.
     * @param defense The defense stat.
     * @param stamina The stamina stat.
     * @return The IV percentage.
     */
    private double calculateIv(int attack, int defense, int stamina) {
        return ((double) (attack + defense + stamina)
                / (3 * MAX_RANDOM_STAT)) * 100;
    }
}

