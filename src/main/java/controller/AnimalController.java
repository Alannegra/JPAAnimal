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
    Animal animalExists = (Animal) em.find(Animal.class, animal.getNombre());
    if (animalExists == null ){
      //System.out.println("insert animal");
      em.persist(animal);
    }
    em.getTransaction().commit();
    em.close();
  }


  /* Method to READ all Autors */
  public void listAnimals() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List<Animal> result = em.createQuery("from Animal where dieta like '%fruta%'", Animal.class)
        .getResultList();
    for (Animal animal : result) {
      System.out.println(animal.toString());
    }
    em.getTransaction().commit();
    em.close();
  }

  /* Method to UPDATE activity for an author */
  public void updateHabitat(Integer animalId) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Animal animal = (Animal) em.find(Animal.class, animalId);
    em.merge(animal);
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

  /*public void consultaClase(){
    ResultSet rs = null;
    String sql = "SELECT distinct clase FROM animal";
    try{
      Statement st = connection.createStatement();
      rs = st.executeQuery(sql);
      System.out.print("| ");
      while (rs.next()) {
        System.out.print(rs.getString("clase") + " | ");
      }
      System.out.println();
      System.out.println("+----------+-----------+---------+----------+----------+------+");

      rs.close();
      st.close();
    }catch (Exception e){
      System.out.println("ERROR" + e);
    }
  }*/

  public void consultaClaseConcreta(){
    //consultaClase();
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

}
