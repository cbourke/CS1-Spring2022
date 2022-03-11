package unl.cse.honors.jdbc;

public class Platform {

	private final int platformId;
	private final String name;

	/**
	 * @param platformId
	 * @param name
	 */
	public Platform(int platformId, String name) {
		super();
		this.platformId = platformId;
		this.name = name;
	}

	public int getPlatformId() {
		return platformId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s (%d)", this.name, this.platformId);
	}

}
