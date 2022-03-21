package controller;

import com.opencsv.CSVReader;
import model.Animal;
import model.Habitat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Clase AnimalController: Se encarga de controlar la tabla Animal en la base de datos.
 */
public class AnimalController {

  private Connection connection;
  private EntityManagerFactory entityManagerFactory;

  public AnimalController(Connection connection) {
    this.connection = connection;
  }
  Animal animal = new Animal();
  Scanner scanner = new Scanner(System.in);

  /**
   * Constructor AnimalController: Se encarga de construir la clase.
   * @param connection Conexión a la base de datos
   * @param entityManagerFactory EntityManager se usa para crear y eliminar instancias de entidades persistentes, para buscar entidades por su clave principal y para consultar entidades.
   */
  public AnimalController(Connection connection, EntityManagerFactory entityManagerFactory) {
    this.connection = connection;
    this.entityManagerFactory = entityManagerFactory;
  }

  /**
   * Metodo addAnimal: Se encarga de crear un Animal en la base de datos
   * @param animal Animal con todos sus datos descritos en su modelo clase Animal
   */
  public void addAnimal(Animal animal) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
   //Animal animalExists = (Animal) em.find(Animal.class, animal.getNombre());
    //if (animalExists == null ){
      //System.out.println("insert animal");
    try{
      em.persist(animal);
    }catch (Exception e){

    }
    //}
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo listAnimals: Se encarga de mostrar por terminal un listado de la tabla animal de la base de datos.
   */
  public void listAnimals() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal", Animal.class)
        .getResultList();
    for (Animal animal : result) {
      System.out.println(animal.toString());
    }
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo updateAnimalDieta: Se encarga de brindarnos la posibilidad de modificar por terminal la dieta del animal deseado, escribiendo en el terminal el id del animal conectandose previamente a la base de datos.
   * @param animalId Int que indica la id del animal.
   */
  public void updateAnimalDieta(int animalId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();

    //List<Animal> result = em.createQuery("from Animal where animalId="+animalId+"", Animal.class).getResultList();

    Animal animal = (Animal) em.find(Animal.class, animalId);
    System.out.println("Escribe la nueva dieta del animal: ");
    String word2 = scanner.nextLine();
    animal.setDieta(word2);
    em.merge(animal);
    em.getTransaction().commit();
    em.close();

  }

  /**
   * Metodo updateAnimalClase: Se encarga de brindarnos la posibilidad de modificar por terminal la clase de todos los animales selecionados, escribiendo en el terminal el id del animal conectandose previamente a la base de datos.
   * @param habitat String que indica el habitat de los animales a modificar.
   */
  public void updateAnimalClase(String habitat) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();

    List<Animal> result = em.createQuery("from Animal where habitat='"+habitat+"'", Animal.class).getResultList();

    System.out.println("Escribe la clase del animal");
    String word2 = scanner.nextLine();



    for (Animal animal :result) {

      animal.setClase(word2);
      em.merge(animal);
    }


    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo deleteAnimal: Se encarga de brindarnos la posibilidad de eliminar por terminal un animal deseado escribiendo en el terminal el id del animal conectandose previamente a la base de datos.
   */
  public void deleteAnimal() {
    consultaNombre();
    System.out.println("Escribe el numero de la id");
    String animalId = scanner.nextLine();

    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Animal animal = (Animal) em.find(Animal.class, Integer.parseInt(animalId));
    em.remove(animal);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo eliminarAnimalesPorClase: Se encarga de brindarnos la posibilidad de eliminar por terminal todos los animales deseados escribiendo en el terminal la clase del animal conectandose previamente a la base de datos.
   */
  public void deleteAnimalForeveryClase() {
    consultaClase();
    System.out.println("Escribe la clase a eliminar: ");
    String str = scanner.nextLine();
    String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where clase='"+clase+"'", Animal.class).getResultList();

    for (Animal animal :result) {
      em.remove(animal);
    }

    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo poblarTablaAnimalLeer: Se encarga de poblar la tabla Animal y mostrar el nombre de los animales poblados en la base de datos.
   * @param filename String con ruta al archivo .csv
   */
  public List<Animal> poblarTablaAnimalLeer(String filename) throws IOException {
    int num = 0 ;
    List<Animal> animals = new ArrayList<>();

    try{
      Reader reader = Files.newBufferedReader(Paths.get(filename));
      List<String[]> list = new ArrayList<>();
      CSVReader csvReader = new CSVReader(reader);
      String[] line;


      while ((line = csvReader.readNext()) != null) {
        if(num > 0){
          list.add(line);
          animals.add(new Animal(line[0],line[1],line[2],line[3],line[4],line[5],line[6],line[7],line[8],line[9]));
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
    return animals;
  }

  /**
   * Metodo consultaClase: Se encarga de mostrar por terminal las clases disponibles conectandose previamente a la base de datos.
   */
  public void consultaClase(){
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<String> result = em.createQuery("select distinct clase from Animal").getResultList();
    System.out.print(" | ");
    for (String clase: result) {
      System.out.print(clase + " | ");
    }
    System.out.println();
    System.out.println("+----------+-----------+---------+----------+----------+------+");


    em.getTransaction().commit();
    em.close();

  }
  /**
   * Metodo consultaClaseConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la clase del animal conectandose previamente a la base de datos.
   */
  public void consultaClaseConcreta(){
    consultaClase();
    System.out.println("Escribe la clase a mostrar: ");
    String word = scanner.nextLine();
    String str = word.toLowerCase();
    String clase = str.substring(0, 1).toUpperCase() + str.substring(1);

    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where clase='" + clase + "'", Animal.class)
            .getResultList();
    animal.toString(result);

    em.getTransaction().commit();
    em.close();
  }
  /**
   * Metodo consultaOrden: Se encarga de mostrar por terminal los ordenes disponibles conectandose previamente a la base de datos.
   */
  public void consultaOrden() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<String> result = em.createQuery("select distinct orden from Animal").getResultList();
    int cont = 0;
    for (String orden: result) {
      if(cont % 5 == 0){
        System.out.println();
        System.out.print("| ");
      }else{
        System.out.print(orden + " | ");
      }
      cont++;
    }
    em.getTransaction().commit();
    em.close();

  }
  /**
   * Metodo consultaOrdenConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente el orden del animal conectandose previamente a la base de datos.
   */
  public void consultaOrdenConcreta(){
    consultaOrden();
    System.out.println("Escribe el orden a mostrar: ");
    String word = scanner.nextLine();
    String str = word.toLowerCase();
    String orden = str.substring(0, 1).toUpperCase() + str.substring(1);

    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where orden='" + orden + "'", Animal.class)
            .getResultList();
    animal.toString(result);

    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo consultaNombreConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la id del animal conectandose previamente a la base de datos.
   */
  public void consultaNombreConcreta() {
    System.out.println("Escribe un numero: ");
    String word = scanner.nextLine();
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where LENGtH(nombre) <=" + word, Animal.class)
            .getResultList();
    animal.toString(result);

    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo consultaDietaConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la dieta del animal a buscar conectandose previamente a la base de datos.
   */
  public void consultaDietaConcreta() {
    System.out.println("|@#|@#|@# EJEMPLOS #@|#@|#@|");
    System.out.println("- Fruta");
    System.out.println("- Huevo");
    System.out.println("- Semilla");
    System.out.println("- Insecto");
    System.out.println("- Flor");
    System.out.println("- Raton");
    System.out.println("Escribe la palabra a contener: ");
    String word = scanner.nextLine();
    String str = word.toLowerCase();

    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where dieta like '%" + str + "%'", Animal.class)
            .getResultList();
    animal.toString2(result);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo consultaNombre: Se encarga de mostrar por terminal las ids y nombres de todos los animales disponibles conectandose previamente a la base de datos.
   */
  public void consultaNombre(){
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal").getResultList();

    System.out.println("|    id     |    Nombre   |");
    System.out.println("+-----------+-------------+");
    for (Animal animal: result) {
      System.out.println(" | " + animal.getAnimalId() + " | " + animal.getNombre() + " | ");

    }
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Metodo modificarDieta: Se encarga de llamar al metodo updateAnimalDieta al cual le pasamos un parametro que sera la id del animal.
   */
  public void modificarDieta(){
    consultaNombre();
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();

    List<String> result = em.createQuery("select nombre from Animal").getResultList();
    System.out.println("Escribe el numero de la id");
    String word = scanner.nextLine();
    String nombre = result.get(Integer.parseInt(word)-1);

    em.getTransaction().commit();
    em.close();
    
    updateAnimalDieta(Integer.parseInt(word));

  }

  /**
   * Metodo modificarClasesPorHabitat: Se encarga de llamar al metodo updateAnimalClase al cual le pasamos el habitat que sera el habitat de los animales a modificar.
   */
  public void modificarClasesPorHabitat() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();

    System.out.println("Escribe el habitat de los animales a modificar: ");
    String word = scanner.nextLine().toUpperCase();

    List<String> result = em.createQuery("select nombre from Animal").getResultList();


    em.getTransaction().commit();
    em.close();

    updateAnimalClase(word);
  }

}
