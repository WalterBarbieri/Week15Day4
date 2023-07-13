package w15d4prove.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import w15d4prove.dao.AnimalDao;
import w15d4prove.entities.Cat;
import w15d4prove.entities.Dog;
import w15d4prove.utils.JpaUtil;

public class App {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		AnimalDao ad = new AnimalDao(em);

		Cat fischietto = new Cat("fischietto", 1, 4.0);
		Dog atma = new Dog("Atma", 11, 25.4);

//		ad.save(fischietto);
//		ad.save(atma);

//		ad.searchAndUpdateNamedDog(16, "Lanciafiamme");

//		ad.searchAndDestroy(15);
		ad.searchThemAll().forEach(a -> log.info(a.toString()));
		ad.searchThemCat().forEach(c -> log.info(c.toString()));

		ad.searchFuffy("Lanciafiamme").forEach(el -> log.info(el.toString()));

	}

}
