package w15d4prove.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Le classi figlio vengono inserite nella tabella padre
//@Inheritance(strategy = InheritanceType.JOINED) // viene creata una tabella per ogni entit
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // viene creata una tabella per ogni entità, ma la tabella
// padre rimane vuota mentre le proprietà del padre vengono
// inserite nelle tabelle dei figli
//@MappedSuperclass // La classe padre astratta non viene mappata, crete solo tabelle figli -> rimuovere entity in quanto classe astratta
@DiscriminatorColumn(name = "tipo_animale")
public abstract class Animal {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;

	public Animal() {

	}

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
