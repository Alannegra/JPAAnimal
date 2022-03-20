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

public class AnimalController {

  private Connection connection;
  private EntityManagerFactory entityManagerFactory;

  public AnimalController(Connection connection) {
    this.connection = connection;
  }
  Animal animal = new Animal();
  Scanner scanner = new Scanner(System.in);

  public AnimalController(Connection connection, EntityManagerFactory entityManagerFactory) {
    this.connection = connection;
    this.entityManagerFactory = entityManagerFactory;
  }

  public List<Habitat> readHabitatsFile23213(String filename) throws IOException {
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

  public void printAnimals(ArrayList<Animal> animalsList) {
    for (int i = 0; i < animalsList.size(); i++) {
      System.out.println(animalsList.get(i).toString());
    }
  }

  /* Method to CREATE an Autor in the database */
  public void addAnimal(Animal animal) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
   //Animal animalExists = (Animal) em.find(Animal.class, animal.getNombre());
    //if (animalExists == null ){
      //System.out.println("insert animal");
      em.persist(animal);
    //}
    em.getTransaction().commit();
    em.close();
  }


  /* Method to READ all Autors */
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

  /* Method to UPDATE activity for an author */
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

  /* Method to DELETE an Author from the records */
  public void deleteHabitat(Integer habitatId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Habitat habitat = (Habitat) em.find(Habitat.class, habitatId);
    em.remove(habitat);
    em.getTransaction().commit();
    em.close();
  }


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
          //String sql = "INSERT INTO habitat (habitat,description) VALUES (?,?)";
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

  public void consultaClase(){
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<String> result = em.createQuery("select distinct clase from Animal").getResultList();
    for (String clase: result) {
      System.out.print(clase + " | ");
    }
    System.out.println();
    System.out.println("+----------+-----------+---------+----------+----------+------+");


    em.getTransaction().commit();
    em.close();

  }

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

  public void consultaNombre(){
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<String> result = em.createQuery("select nombre from Animal").getResultList();

    int i = 1;
    for (String animal: result) {
      System.out.println(" | " + i + " | " + animal + " | ");
      i++;
    }
    em.getTransaction().commit();
    em.close();
  }

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
    /*try {
      consultaNombre();
      Statement st = connection.createStatement();
      System.out.println("Escribe el numero de la id");
      String word = scanner.nextLine();
      System.out.println("Escribe el nuevo nombre: ");
      String word2 = scanner.nextLine();
      st.executeUpdate("update animal set nombre='" + word2 + "' where id=" + word );
      st.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }*/
  }

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
