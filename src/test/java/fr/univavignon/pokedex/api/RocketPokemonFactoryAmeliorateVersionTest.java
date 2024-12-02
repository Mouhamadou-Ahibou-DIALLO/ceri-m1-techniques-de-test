package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the RocketPokemonFactory class.
 */
public class RocketPokemonFactoryAmeliorateVersionTest {

    private RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    public void setup() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 500, 100, 3000, 50);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());

        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 200);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 200);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 200);

        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(50, pokemon.getCandy());

        assertTrue(pokemon.getIv() >= 0.0 && pokemon.getIv() <= 100.0);
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(-1, 1000, 200, 4000, 100);

        assertEquals(-1, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());

        assertEquals(1000, pokemon.getStamina());
        assertEquals(1000, pokemon.getCp());
        assertEquals(200, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());

        assertEquals(100, pokemon.getCandy());
        assertEquals(0.0, pokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithUnmappedIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(999, 1500, 250, 5000, 75);

        assertEquals(999, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());

        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 200);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 200);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 200);

        assertEquals(1500, pokemon.getCp());
        assertEquals(250, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(75, pokemon.getCandy());

        assertTrue(pokemon.getIv() >= 0.0 && pokemon.getIv() <= 100.0);
    }

    @Test
    public void testIvCalculation() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 500, 100, 3000, 50);

        double iv = pokemon.getIv();
        assertTrue(iv >= 0.0 && iv <= 100.0, "IV should be in the range 0.0 to 100.0");
    }
}

