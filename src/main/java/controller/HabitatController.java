package controller;

import com.opencsv.CSVReader;
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

/**
 * Clase HabitatController: Se encarga de controlar la tabla Habitat en la base de datos.
 */
public class HabitatController {

  private Connection connection;
  private EntityManagerFactory entityManagerFactory;

  public HabitatController(Connection connection) {
    this.connection = connection;
  }
  Habitat habitat = new Habitat();
  /**
   * Constructor HabitatController: Se encarga de construir la clase.
   * @param connection Conexión a la base de datos
   * @param entityManagerFactory EntityManager se usa para crear y eliminar instancias de entidades persistentes, para buscar entidades por su clave principal y para consultar entidades.
   */
  public HabitatController(Connection connection, EntityManagerFactory entityManagerFactory) {
    this.connection = connection;
    this.entityManagerFactory = entityManagerFactory;
  }

  /**
   * Metodo addHabitat: Se encarga de crear un Habitat en la base de datos
   * @param habitat Habitat con todos sus datos descritos en su modelo clase Habitat
   */
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

  /**
   * Metodo listHabitats: Se encarga de mostrar por terminal un listado de la tabla habitat de la base de datos.
   */
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

  /**
   * Metodo updateHabitat: Se encarga de modificar un habitat selecionado por la id.
   * @param habitatId Int que indica el id del habitat.
   */
  public void updateHabitat(Integer habitatId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Habitat habitat = (Habitat) em.find(Habitat.class, habitatId);
    em.merge(habitat);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo deleteHabitat: Se encarga de brindarnos la posibilidad de eliminar por terminal un habitat deseado escribiendo en el terminal el id del habitat conectandose previamente a la base de datos.
   */
  public void deleteHabitat(Integer habitatId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Habitat habitat = (Habitat) em.find(Habitat.class, habitatId);
    em.remove(habitat);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo poblarTablaHabitatLeer: Se encarga de poblar la tabla Habitat y mostrar el nombre de los habitats poblados en la base de datos.
   * @param filename String con ruta al archivo .csv
   */
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

  /**
   * Metodo consultaHabitat: Se encarga de mostrar por terminal las habitats disponibles conectandose previamente a la base de datos.
   */
  public void consultaHabitat() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Habitat> result = em.createQuery("from Habitat", Habitat.class).getResultList();
    habitat.toString(result);
    em.getTransaction().commit();
    em.close();
  }
}
