package controller;

import com.opencsv.CSVReader;
import model.Author;
import model.Habitat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
  Habitat habitat = new Habitat();
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

      habitatsList.add(new Habitat( habitat, description));

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
    //Habitat habitatExists = (Habitat) em.find(Habitat.class, habitat.getHabitat());
    //if (habitatExists == null ){
      //System.out.println("insert habitat");
    try{
      em.persist(habitat);
    }catch (Exception e){

    }

    //}
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


  public List<Habitat> poblarTablaHabitatLeer(String filename) throws IOException {
    int num = 0 ;
    List<Habitat> habitats = new ArrayList<>();

    try{
      Reader reader = Files.newBufferedReader(Paths.get(filename));
      List<String[]> list = new ArrayList<>();
      CSVReader csvReader = new CSVReader(reader);
      String[] line;


      while ((line = csvReader.readNext()) != null) {
        if(num > 0){
          list.add(line);
          //String sql = "INSERT INTO habitat (habitat,description) VALUES (?,?)";
          habitats.add(new Habitat(line[0],line[1]));
        }
        num++;
      }

      for (String[] a:list) {
        System.out.println(a[0]);
      }
      System.out.println(num-1);

      reader.close();
      csvReader.close();



    }catch (Exception e){
      System.out.println("Error" + e);
    }
    return habitats;
  }


  public void consultaHabitat() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Habitat> result = em.createQuery("from Habitat", Habitat.class).getResultList();
    habitat.toString(result);
    em.getTransaction().commit();
    em.close();
  }
}
