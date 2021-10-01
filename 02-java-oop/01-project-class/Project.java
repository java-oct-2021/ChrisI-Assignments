public class Project {
	private String name;
	private String description;
	private double initialCost;
	public Project(String name, String description, double initialCost) {
		this.name = name;
		this.description = description;
		this.initialCost = initialCost;
	}
	public Project(String name) {
		this.name = name;
		this.description = "no description";
		this.initialCost = 0;
	}
	public Project() {
		this.name = "no name";
		this.description = "no description";
		this.initialCost = 0;
	}

	public String elevatorPitch() {
		return this.name +" ("+this.initialCost+"): " + this.description;
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public double getInitialCost() {
		return this.initialCost;
	}
	public String setName(String name) {
		this.name = name;
		return this.name;
	}
	public String setDescription(String description) {
		this.description = description;
		return this.description;
	}
	public double setInitialCost(double initialCost) {
		this.initialCost = initialCost;
		return this.initialCost;
	}
}
