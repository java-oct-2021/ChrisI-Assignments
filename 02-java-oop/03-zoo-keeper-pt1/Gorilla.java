public class Gorilla extends Mammal {
	public Gorilla() {
		this.energyLevel = 500;
	}
	public Gorilla throwSomething() {
		System.out.println("*gorilla throws object*");
		this.energyLevel -= 5;
		this.displayEnergy();
		return this;
	}
	public Gorilla eatBananas() {
		System.out.println("*gorilla devours banana*");
		this.energyLevel += 10;
		this.displayEnergy();
		return this;
	}
	public Gorilla climb() {
		System.out.println("*gorilla climbs tall building*");
		this.energyLevel -= 10;
		this.displayEnergy();
		return this;
	}
}