package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "habitat")

public class Habitat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int habitatId;

    @Column(name = "habitat")
    String habitat;
    @Column(name = "description")
    String description;

    public Habitat(String habitat, String description) {
        //this.habitatId = habitatId;
        this.habitat = habitat;
        this.description = description;
    }

    public Habitat() {
    }

    public int getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(int habitatId) {
        this.habitatId = habitatId;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void toString(List<Habitat> result) {
        System.out.print("| ");
        for (Habitat habitat:result) {
            System.out.print(habitat.getHabitat() + " | ");
        }
        System.out.println();
        System.out.println("+----------------------------------------+-----------------+-------------------+--------------------+");
    }
}
