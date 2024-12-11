package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.imp.RocketPokemonFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RocketPokemonFactoryTest {

    private Pokemon pokemon;

    @BeforeEach
    public void setup() {
        RocketPokemonFactory rocketPokemonFactory = new RocketPokemonFactory();
        pokemon = rocketPokemonFactory.createPokemon(1, 100, 50, 10, 5);
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        assertEquals("Bulbasaur", pokemon.getName(), "Le nom devrait être 'Bulbasaur'.");
        assertTrue(pokemon.getAttack() >= 0, "L'attaque devrait être non-négative.");
        assertTrue(pokemon.getDefense() >= 0, "La défense devrait être non-négative.");
        assertTrue(pokemon.getStamina() >= 0, "L'endurance devrait être non-négative.");
        assertEquals(1, pokemon.getIv(), "L'IV devrait être fixé à 1.");
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        Pokemon invalidPokemon = new RocketPokemonFactory().createPokemon(-1, 100, 50, 10, 5);
        assertEquals("Ash's Pikachu", invalidPokemon.getName(), "Le nom devrait être 'MISSINGNO' pour un index invalide.");
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        Pokemon negativePokemon = new RocketPokemonFactory().createPokemon(-10, 100, 50, 10, 5);
        assertEquals("MISSINGNO", negativePokemon.getName(), "Le nom devrait être 'Ash's Pikachu' pour un index négatif.");
        assertEquals(1000, negativePokemon.getAttack(), "L'attaque devrait être fixée à 1000 pour un index négatif.");
        assertEquals(1000, negativePokemon.getDefense(), "La défense devrait être fixée à 1000 pour un index négatif.");
        assertEquals(1000, negativePokemon.getStamina(), "L'endurance devrait être fixée à 1000 pour un index négatif.");
        assertEquals(0, negativePokemon.getIv(), "L'IV devrait être fixée à 0 pour un index négatif.");
    }
}
