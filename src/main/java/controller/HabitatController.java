package controller;

import model.Author;
import model.Habitat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HabitatController {

  private Connection connection;
  private EntityManagerFactory entityManagerFactory;

  public HabitatController(Connection connection) {
    this.connection = connection;
  }

  public HabitatController(Connection connection, EntityManagerFactory entityManagerFactory) {
    this.connection = connection;
    this.entityManagerFactory = entityManagerFactory;
  }

  public List<Habitat> readHabitatsFile(String filename) throws IOException {
    int id;
    String habitat, description;
    List<Habitat> habitatsList= new ArrayList<Habitat>();

    BufferedReader br = new BufferedReader(new FileReader(filename));
    String linea = "";
    while ((linea = br.readLine()) != null) {

      StringTokenizer str = new StringTokenizer(linea, ",");
      id = Integer.parseInt(str.nextToken());
      habitat = str.nextToken();
      description = str.nextToken();

      habitatsList.add(new Habitat(id, habitat, description));

    }
    br.close();

    return habitatsList;
  }

  public void printHabitats(ArrayList<Habitat> habitatsList) {
    for (int i = 0; i < habitatsList.size(); i++) {
      System.out.println(habitatsList.get(i).toString());
    }
  }

  /* Method to CREATE an Autor in the database */
  public void addHabitat(Habitat habitat) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Author authotExists = (Author) em.find(Author.class, habitat.getHabitatId());
    if (authotExists == null ){
      System.out.println("insert autor");
      em.persist(habitat);
    }
    em.getTransaction().commit();
    em.close();
  }


  /* Method to READ all Autors */
  public void listHabitats() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Habitat> result = em.createQuery("from Habitat", Habitat.class)
        .getResultList();
    for (Habitat habitat : result) {
      System.out.println(habitat.toString());
    }
    em.getTransaction().commit();
    em.close();
  }

  /* Method to UPDATE activity for an author */
  public void updateHabitat(Integer habitatId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Habitat habitat = (Habitat) em.find(Habitat.class, habitatId);
    em.merge(habitat);
    em.getTransaction().commit();
    em.close();
  }

  /* Method to DELETE an Author from the records */
  public void deleteHabitat(Integer habitatId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Habitat habitat = (Habitat) em.find(Habitat.class, habitatId);
    em.remove(habitat);
    em.getTransaction().commit();
    em.close();
  }

}
