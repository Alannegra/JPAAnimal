package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "habitat")

/**
 * Clase Habitat: Se encarga de crear el objeto de la tabla habitat con los distintos datos de cada Habitat en la base de datos.
 */
    public class Habitat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int habitatId;

    @Column(name = "habitat")
    String habitat;
    @Column(name = "description")
    String description;

    /**
     * Constructor Habitat: Se encarga de construir la clase de cada Habitat.
     * @param habitat String nombre del habitat
     * @param description String descripcion del habitat
     */
    public Habitat(String habitat, String description) {
        //this.habitatId = habitatId;
        this.habitat = habitat;
        this.description = description;
    }
    /**
     * Constructor Animal: Vació
     */
    public Habitat() {
    }
    /**
     * Getter getHabitat
     * @return habitatId
     */
    public int getHabitatId() {
        return habitatId;
    }
    /**
     * Setter setHabitatId
     * @param habitatId habitatId
     */
    public void setHabitatId(int habitatId) {
        this.habitatId = habitatId;
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
     * Getter getHabitat
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Setter setDescription
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo toString: Se encarga de mostrar por el terminal la lista de habitats de una forma muy visual.
     * @param result Lista de Habitats para recorrerla.
     */
    public void toString(List<Habitat> result) {
        System.out.print("| ");
        for (Habitat habitat:result) {
            System.out.print(habitat.getHabitat() + " | ");
        }
        System.out.println();
        System.out.println("+----------------------------------------+-----------------+-------------------+--------------------+");
    }
}
