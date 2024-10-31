package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * Main test class for the application.
 */
public class MainTest {

    /**
     * The main test method of the application.
     *
     * @param args arguments of the program
     * @throws PokedexException if an error occurs
     */
    public static void main(String[] args) throws PokedexException {

        PokemonMetadata bulbizarre = new PokemonMetadata(0,
                "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133,
                "Aquali", 186, 168, 260);

        System.out.println(aquali.getIndex() + " index aquali");

        List<PokemonMetadata> pokemonMetadataList = List.of(bulbizarre, aquali);

        for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
            System.out.println(pokemonMetadata + " index: " + pokemonMetadata.getIndex());
        }

        IPokemonMetadataProvider pokemonMetadataProvider =
                new PokemonMetadataObject(pokemonMetadataList);
        System.out.println(pokemonMetadataProvider
                .getPokemonMetadata(133) + " yes exist");

        PokemonMetadataObject pokemonMetadataObject =
                new PokemonMetadataObject(pokemonMetadataList);

        System.out.println(pokemonMetadataObject
                .getPokemonMetadata(0).toString() + " object i verify list");

        PokemonFactory pokemonFactory = new PokemonFactory(pokemonMetadataObject);

        IPokedex pokedex = new Pokedex(pokemonMetadataObject, pokemonFactory);

        Pokemon pokemonAq = pokedex.createPokemon(
                pokemonMetadataProvider.getPokemonMetadata(133).getIndex(), 2729,
                202, 5000, 4);
        Pokemon pokemon = pokedex.createPokemon(
                pokemonMetadataProvider.getPokemonMetadata(0).getIndex(), 613,
                64, 4000, 4);

        int indexAqu = pokedex.addPokemon(pokemonAq);
        int indexPokedex = pokedex.addPokemon(pokemon);

        System.out.println("indexAq " + indexAqu);
        System.out.println(indexPokedex + " index");
        System.out.println(pokedex.size() + " taille du pokemons");

        System.out.println(pokedex.getPokemons() + " liste pokemon");

        Comparator<Pokemon> order = Comparator.comparing(Pokemon::getName);

        List<Pokemon> sortedList = pokedex.getPokemons(order);
        System.out.println(sortedList + " liste triée");

        PokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex iPokedexFactory = pokedexFactory
                .createPokedex(pokemonMetadataObject, pokemonFactory);

        int addPokedex = iPokedexFactory.addPokemon(pokemon);
        System.out.println(addPokedex + " index of pokemon");
        System.out.println(iPokedexFactory.size() + " taille ipokedexFactory");
        System.out.println(iPokedexFactory.getPokemons() + " liste ipokedexFactory");

        PokemonTrainerFactory pokemonTrainerFactory =
                new PokemonTrainerFactory(pokemonFactory, pokemonMetadataObject);

        PokemonTrainer pokemonTrainer = pokemonTrainerFactory
                .createTrainer("Ceri", Team.MYSTIC, pokedexFactory);
        System.out.println(pokemonTrainer.getPokedex().toString() + " pokedex");
    }
}
