import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import database.ConnectionFactory;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import view.Menu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase Main: Se encarga de manejar el panel de control gracias al switch con todas sus opciones.
 */
public class Main {

  static SessionFactory sessionFactoryObj;


  private static SessionFactory buildSessionFactory() {
    try {
      StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
          .configure("hibernate.cfg.xml").build();
      Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();

    } catch (HibernateException he) {
      System.out.println("Session Factory creation failure");
      throw he;
    }
  }

  /**
   * Metodo EntityManagerFactory
   * @return emf
   */
  public static EntityManagerFactory createEntityManagerFactory(){
    EntityManagerFactory emf;
    try {
      emf = Persistence.createEntityManagerFactory("Bioparc");
    } catch (Throwable ex) {
      System.err.println("Failed to create EntityManagerFactory object."+ ex);
      throw new ExceptionInInitializerError(ex);
    }
    return emf;
  }

  public static void main(String[] args) {

    ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
    Connection c = connectionFactory.connect();

//    SessionFactory sessionFactory = buildSessionFactory();
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory();
    //sessionObj = buildSessionFactory().openSession();


    Menu menu = new Menu();


    HabitatController habitatController = new HabitatController(c, entityManagerFactory);
    AnimalController animalController = new AnimalController(c, entityManagerFactory);

    int opcio = menu.mainMenu();
    while (opcio > 0 && opcio < 12) {
      switch (opcio) {

        case 3:

          try {
            List<Habitat> habitats = habitatController.poblarTablaHabitatLeer("src/main/resources/Habitat.csv");
            for (Habitat habitat : habitats) {
              habitatController.addHabitat(habitat);
            }
            List<Animal> animals = animalController.poblarTablaAnimalLeer("src/main/resources/Animal.csv");
            for (Animal animal : animals) {
              animalController.addAnimal(animal);
            }

          } catch (IOException e) {
            e.printStackTrace();
          }

          break;
        case 4:
          animalController.consultaClaseConcreta();
          break;
        case 5:
          animalController.consultaOrdenConcreta();
          break;
        case 6:
          animalController.consultaNombreConcreta();
          break;
        case 7:
          animalController.consultaDietaConcreta();
          break;
        case 8:
          animalController.modificarDieta();
          break;
        case 9:
          habitatController.consultaHabitat();
          animalController.modificarClasesPorHabitat();
          break;
        case 10:
          animalController.deleteAnimal();
          break;
        case 11:
          animalController.deleteAnimalForeveryClase();
          break;
        default:
          System.out.println("Adeu!!");
          habitatController.listHabitats();
          animalController.listAnimals();
          System.exit(1);
          break;

      }
      opcio = menu.mainMenu();
    }
  }
}


/*


    static User userObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static void main(String[] args) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            for(int i = 101; i <= 105; i++) {
                userObj = new User();
                userObj.setUserid(i);
                userObj.setUsername("Editor " + i);
                userObj.setCreatedBy("Administrator");
                userObj.setCreatedDate(new Date());

                sessionObj.save(userObj);
            }
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }


*/
