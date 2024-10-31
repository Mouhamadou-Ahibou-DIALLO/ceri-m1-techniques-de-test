package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team,
						  final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/**
	 * Returns the name of this trainer.
	 *
	 * @return Name of this trainer.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the team of this trainer.
	 *
	 * @return Team of this trainer.
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * Returns the pokedex of this trainer.
	 *
	 * @return Pokedex of this trainer.
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}

	/**
	 * Returns a string representation of this PokemonTrainer.
	 *
	 * @return A string representation of this PokemonTrainer.
	 */
	@Override
	public String toString() {
		return "PokemonTrainer{" +
				"name='" + name + '\'' +
				", team=" + team +
				", pokedex=" + pokedex +
				'}';
	}
}
