package domain;

public class Stadium {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Stadium() {}
	
	public Stadium(String name) {
		this.setName(name);
	}
}
