public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 400;
	}
	public Bat fly() {
		this.energyLevel -= 50;
		System.out.println("whoosh!");
		this.displayEnergy();
		return this;
	}
	public Bat eatHumans() {
		this.energyLevel += 25;
		System.out.println("*screaming in the distance*");
		this.displayEnergy();
		return this;
	}
	public Bat attackTown() {
		this.energyLevel -= 100;
		System.out.println("*screaming all around*");
		this.displayEnergy();
		return this;
	}
}
