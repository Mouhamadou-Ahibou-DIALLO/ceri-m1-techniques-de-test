package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * Enumeration of pokemon comparator.
 * 
 * @author fv
 */
public enum PokemonComparators implements Comparator<Pokemon> {

	/** Comparator using Pokemon name. **/
	NAME(Comparator.comparing(Pokemon::getName)),

	/** Comparator using Pokemon index. **/
	INDEX(Comparator.comparing(Pokemon::getIndex)),
	
	/** Comparator using Pokemon combat point. **/
	CP(Comparator.comparing(Pokemon::getCp))
	
	;
	
	/** Delegate comparator instance. **/
	private final Comparator<Pokemon> delegate;

	/**
	 * Default constructor.
	 * 
	 * @param delegate Delegate comparator instance.
	 */
	private PokemonComparators(final Comparator<Pokemon> delegate) {
		this.delegate = delegate;
	}

	/**
	 * Compares two Pokemon instances using the underlying comparator.
	 *
	 * @param first  First Pokemon to compare.
	 * @param second Second Pokemon to compare.
	 * @return Result of the comparison.
	 */
	@Override
	public int compare(final Pokemon first, final Pokemon second) {

		return delegate.compare(first, second);
	}
}
