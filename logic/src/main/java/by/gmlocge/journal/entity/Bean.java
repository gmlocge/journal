package by.gmlocge.journal.entity;

import javax.persistence.*;

/**
 * The Class Bean.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Bean {
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (unique = true, nullable = false)
	/** The id. */
	private int id;

	/**
	 * Instantiates a new bean.
	 */
	public Bean() {
		super();
	}

	/**
	 * Instantiates a new bean.
	 * @param id
	 *            the id
	 */
	public Bean(int id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
