package fr.univavignon.pokedex.api;

import java.util.Objects;

/**
 * Pokemon POJO.
 * 
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

	/** Combat Point of the pokemon. **/
	private final int cp;

	/** HP of the pokemon. **/
	private final int hp;

	/** Required dust for upgrading this pokemon. **/
	private final int dust;

	/** Required candy for upgrading this pokemon. **/
	private final int candy;

	/** IV perfection percentage. **/
	private final double iv;
	
	/**
	 * Default constructor.
	 * 
	 * @param index Pokemon index.
	 * @param name Pokemon name.
	 * @param attack Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 * @param cp Pokemon cp.
	 * @param hp Pokemon hp.
	 * @param dust Required dust for upgrading this pokemon.
	 * @param candy Required candy for upgrading this pokemon.
	 * @param iv IV perfection percentage.
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Returns the combat point of this pokemon.
	 *
	 * @return Combat point of this pokemon.
	 */
	public int getCp() {
		return cp;
	}
	
	/**
	 * Returns the hit points of this pokemon.
	 *
	 * @return Hit points of this pokemon.
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Returns the required dust for upgrading this pokemon.
	 *
	 * @return Dust required for upgrading this pokemon.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Returns the required candy for upgrading this pokemon.
	 *
	 * @return Candy required for upgrading this pokemon.
	 */
	public int getCandy() {
		return candy;
	}
	
	/**
	 * Returns the IV perfection percentage of this pokemon.
	 *
	 * @return IV perfection percentage of this pokemon.
	 */
	public double getIv() {
		return iv;
	}

	@Override
	public String toString() {
		return super.toString() + ", Pokemon{cp=" + this.cp + ", hp=" + this.hp +
				", dust=" + this.dust + ", candy=" + this.candy + ", iv="
				+ this.iv + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pokemon that = (Pokemon) o;
		return this.cp == that.cp &&
				this.hp == that.hp &&
				Double.compare(that.iv, this.iv) == 0 &&
				this.dust == that.dust &&
				this.candy == that.candy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cp, hp, iv, dust, candy);
	}
}
