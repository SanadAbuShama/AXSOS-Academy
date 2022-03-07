package Mammal;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("Gorilla threw something");
		energyLevel-=5;
	}
	public void eatBanana() {
		System.out.println("Gorilla is satisfied");
		energyLevel+=10;
	}
	public void climb() {
		System.out.println("Gorilla has climbed a tree");
		energyLevel-=10;
	}
}
