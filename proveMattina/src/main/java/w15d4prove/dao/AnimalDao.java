package w15d4prove.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import w15d4prove.app.App;
import w15d4prove.entities.Animal;
import w15d4prove.entities.Cat;
import w15d4prove.entities.Dog;

public class AnimalDao {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(App.class);

	public AnimalDao(EntityManager em) {
		this.em = em;
	}

	public void save(Animal s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		log.info(s.getName() + " salvato");
	}

	public Animal searchById(long id) {
		Animal found = em.find(Animal.class, id);

		if (found != null) {
			return found;
		} else {
			log.info("Animal non trovato");
		}

		return null;
	}

	public List<Animal> searchThemAll() {
		TypedQuery<Animal> getAllQuery = em.createQuery("SELECT a FROM Animal a", Animal.class);
		return getAllQuery.getResultList();
	}

	public List<Cat> searchThemCat() {
		TypedQuery<Cat> getAllQuery = em.createQuery("SELECT c FROM Cat c", Cat.class);
		return getAllQuery.getResultList();
	}

	public List<Dog> searchThemDog() {
		TypedQuery<Dog> getAllQuery = em.createQuery("SELECT c FROM Cat c", Dog.class);
		return getAllQuery.getResultList();
	}

	public void searchAndUpdateNamedDog(long id, String name) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		Query q = em.createQuery("UPDATE Dog d SET name = :name WHERE id = :id");

		q.setParameter("name", name);
		q.setParameter("id", id);

		int numeroModificati = q.executeUpdate();
		t.commit();

		if (numeroModificati > 0) {
			log.info("Cani modificati");
		} else {
			log.info("Nessun cane trovato");
		}

	}

	public void searchAndDestroy(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("DELETE FROM Animal WHERE id = :id");
		q.setParameter("id", id);
		int numeroCancellati = q.executeUpdate();
		t.commit();

		if (numeroCancellati > 0) {
			log.info("Animale Soppresso");
		} else {
			log.info("Nessun Animale Soppresso");
		}
	}

	public List<Dog> searchFuffy(String name) {
		TypedQuery<Dog> getAllQuery = em.createNamedQuery("findByName", Dog.class);
		getAllQuery.setParameter("name", name);
		return getAllQuery.getResultList();
	}
}
