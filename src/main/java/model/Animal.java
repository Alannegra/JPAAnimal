package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name = "animal")
public class Animal implements Serializable {
    @Id
    @Column(name = "id")
    int animalId;
    @Column(name = "nombre")
    String name;
    @Column(name = "especie")
    String species;
    @Column(name = "familia")
    String family;

    public Animal(int animalId, String name, String species, String family) {
        super();
        this.name = name;
        this.species = species;
        this.family = family;
    }
    public Animal() {

    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}

