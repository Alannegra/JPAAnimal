package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Entity
@Access(AccessType.FIELD)
@Table(name = "animal")

/**
 * Clase Animal: Se encarga de crear el objeto de la tabla animal con los distintos datos de cada Animal en la base de datos.
 */
    public class Animal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int animalId;

    @Column(name = "nombre")
    String nombre;
    @Column(name = "especie")
    String especie;
    @Column(name = "familia")
    String familia;
    @Column(name = "orden")
    String orden;
    @Column(name = "clase")
    String clase;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "habitat")
    public Habitat habitat;*/

    @Column(name = "habitat")
    String habitat;
    @Column(name = "dieta")
    String dieta;
    @Column(name = "gestacion")
    String gestacion;
    @Column(name = "crias")
    String crias;
    @Column(name = "vida")
    String vida ;


    /**
     * Constructor Animal: Se encarga de construir la clase de cada Animal.
     * @param  nombre nombre
     * @param especie especie
     * @param familia familia
     * @param orden orden
     * @param clase clase
     * @param habitat habitat
     * @param dieta dieta
     * @param gestacion gestacion
     * @param crias crias
     * @param vida vida
     */
    public Animal(String nombre, String especie, String familia, String orden, String clase, String habitat, String dieta, String gestacion, String crias, String vida) {
        /*this.animalId = animalId;*/
        this.nombre = nombre;
        this.especie = especie;
        this.familia = familia;
        this.orden = orden;
        this.clase = clase;
        this.habitat = habitat;
        this.dieta = dieta;
        this.gestacion = gestacion;
        this.crias = crias;
        this.vida = vida;
    }
    /**
     * Constructor Animal: Vació
     */

    public Animal() {

    }

    /**
     * Getter getAnimalId
     * @return id
     */
    public int getAnimalId() {
        return animalId;
    }
    /**
     * Setter setCrias
     * @param animalId crias
     */
    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    /**
     * Getter getNombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter setNombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter getAnimalId
     * @return id
     */
    public String getEspecie() {
        return especie;
    }
    /**
     * Setter setCrias
     * @param especie crias
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    /**
     * Getter getAnimalId
     * @return id
     */
    public String getFamilia() {
        return familia;
    }
    /**
     * Setter setCrias
     * @param familia crias
     */
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    /**
     * Getter getOrden
     * @return orden
     */
    public String getOrden() {
        return orden;
    }
    /**
     * Setter setCrias
     * @param orden crias
     */
    public void setOrden(String orden) {
        this.orden = orden;
    }

    /**
     * Getter getClase
     * @return clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * Setter setClase
     * @param clase clase
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * Getter getHabitat
     * @return habitat
     */
    public String getHabitat() {
        return habitat;
    }
    /**
     * Setter setHabitat
     * @param habitat habitat
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * Getter getDieta
     * @return dieta
     */
    public String getDieta() {
        return dieta;
    }

    /**
     * Setter setDieta
     * @param dieta dieta
     */
    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    /**
     * Getter getGestacion
     * @return gestacion
     */
    public String getGestacion() {
        return gestacion;
    }
    /**
     * Setter setCrias
     * @param gestacion crias
     */
    public void setGestacion(String gestacion) {
        this.gestacion = gestacion;
    }

    /**
     * Getter getCrias
     * @return crias
     */
    public String getCrias() {
        return crias;
    }

    /**
     * Setter setCrias
     * @param crias crias
     */
    public void setCrias(String crias) {
        this.crias = crias;
    }

    /**
     * Getter getVida
     * @return vida
     */
    public String getVida() {
        return vida;
    }
    /**
     * Setter setCrias
     * @param vida crias
     */
    public void setVida(String vida) {
        this.vida = vida;
    }


    /**
     * Metodo toString: Se encarga de mostrar por el terminal la lista de animales de una forma muy visual.
     * @param result Lista de Animales para recorrerla.
     */
    public void toString(List<Animal> result) {
        System.out.println("|    Nombre     |    Orden   |   Clase   |   Habitat    |   Gestacion   |   Crias   |   Vida    |");
        System.out.println("+---------------+------------+-----------+--------------+---------------+-----------+-----------+");
            for (Animal animal : result) {
                System.out.println("| " + animal.getNombre() +
                        " | " + animal.getOrden() +
                        " | " + animal.getClase() +
                        " | " + animal.getHabitat() +
                        " | " + animal.getGestacion() +
                        " | " + animal.getCrias() +
                        " | " + animal.getVida() + " | ");
            }
    }

    /**
     * Metodo toString2: Se encarga de mostrar por el terminal la lista de animales de una forma muy visual.
     * @param result Lista de Animales para recorrerla.
     */
    public void toString2(List<Animal> result){
            System.out.println("|       Nombre       |                         Dieta                         | ");
            System.out.println("+--------------------+-------------------------------------------------------+");
        for (Animal animal : result) {
            System.out.println("| " + animal.getNombre() +
                    " | " + animal.getDieta() + " | ");
        }
    }
}

