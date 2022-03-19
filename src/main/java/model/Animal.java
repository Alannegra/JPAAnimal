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
    String nombre;
    @Column(name = "especie")
    String especie;
    @Column(name = "familia")
    String familia;
    @Column(name = "orden")
    String orden;
    @Column(name = "clase")
    String clase;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "habitat")
    public Habitat habitat;

    @Column(name = "dieta")
    String dieta;
    @Column(name = "gestacion")
    String gestacion;
    @Column(name = "crias")
    String crias;
    @Column(name = "vida")
    String vida ;

    public Animal(int animalId, String nombre, String especie, String familia, String orden, String clase, Habitat habitat, String dieta, String gestacion, String crias, String vida) {
        this.animalId = animalId;
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

    public Animal() {

    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getGestacion() {
        return gestacion;
    }

    public void setGestacion(String gestacion) {
        this.gestacion = gestacion;
    }

    public String getCrias() {
        return crias;
    }

    public void setCrias(String crias) {
        this.crias = crias;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", familia='" + familia + '\'' +
                ", orden='" + orden + '\'' +
                ", clase='" + clase + '\'' +
                ", habitat='" + habitat + '\'' +
                ", dieta='" + dieta + '\'' +
                ", gestacion='" + gestacion + '\'' +
                ", crias='" + crias + '\'' +
                ", vida='" + vida + '\'' +
                '}';
    }
}

