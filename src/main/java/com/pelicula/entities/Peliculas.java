
package com.pelicula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_peliculas")

public class Peliculas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pl_id", nullable=false)
    private int id;
    
    @Column(name="pl_titulo", nullable=false)
    private String titulo;
    
    @Column(name="pl_genero")
    private String genero;
    
    @Column(name="pl_actor_Principal")
    private String actor_Principal;
    
    @Column(name="pl_tiempo")
    private int tiempo_Min;
    
    @Column(name="pl_fecha_Estreno")
    private String fecha_Estreno;

    public Peliculas(String titulo, String genero, String actor_Principal, int tiempo_Min, String fecha_Estreno) {
        this.titulo = titulo;
        this.genero = genero;
        this.actor_Principal = actor_Principal;
        this.tiempo_Min = tiempo_Min;
        this.fecha_Estreno = fecha_Estreno;
    }

    public Peliculas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getActor_Principal() {
        return actor_Principal;
    }

    public void setActor_Principal(String actor_Principal) {
        this.actor_Principal = actor_Principal;
    }

    public int getTiempo_Min() {
        return tiempo_Min;
    }

    public void setTiempo_Min(int tiempo_Min) {
        this.tiempo_Min = tiempo_Min;
    }

    public String getFecha_Estreno() {
        return fecha_Estreno;
    }

    public void setFecha_Estreno(String fecha_Estreno) {
        this.fecha_Estreno = fecha_Estreno;
    }
    
}
