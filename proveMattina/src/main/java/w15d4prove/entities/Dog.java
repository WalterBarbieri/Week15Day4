package w15d4prove.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("Cane")
@NamedQuery(name = "findByName", query = "SELECT d FROM Dog d WHERE d.name = :name")
public class Dog extends Animal {
	private double maxSpeed;

	public Dog() {

	}

	public Dog(String name, int age, double maxSpeed) {
		super(name, age);
		this.maxSpeed = maxSpeed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Dog: " + getId() + " [Name: " + getName() + ", Age: " + getAge() + ", MaxJumpHeight: " + maxSpeed + "]";
	}

}
