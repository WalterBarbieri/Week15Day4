package w15d4prove.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gatto")
public class Cat extends Animal {
	private double maxJumpHeight;

	public Cat() {

	}

	public Cat(String name, int age, double maxJumpHeight) {
		super(name, age);
		this.maxJumpHeight = maxJumpHeight;
	}

	public double getMaxJumpHeight() {
		return maxJumpHeight;
	}

	public void setMaxJumpHeight(double maxJumpHeight) {
		this.maxJumpHeight = maxJumpHeight;
	}

	@Override
	public String toString() {
		return "Cat: " + getId() + " [Name: " + getName() + ", Age: " + getAge() + ", MaxJumpHeight: " + maxJumpHeight
				+ "]";
	}

}
