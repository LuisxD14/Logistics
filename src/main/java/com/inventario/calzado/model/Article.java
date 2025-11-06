package com.inventario.calzado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tienda")
    private String tienda;

    @Column(name = "unidad_negocio")
    private String unidadNegocio;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private String mes;

    @Column(name = "vta_pzs")
    private Integer inventarioPzs;

    public Article() {}

    public Article(Long id, String tienda, String unidadNegocio, Integer anio, String mes, Integer inventarioPzs) {
        this.id = id;
        this.tienda = tienda;
        this.unidadNegocio = unidadNegocio;
        this.anio = anio;
        this.mes = mes;
        this.inventarioPzs = inventarioPzs;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTienda() { return tienda; }
    public void setTienda(String tienda) { this.tienda = tienda; }

    public String getUnidadNegocio() { return unidadNegocio; }
    public void setUnidadNegocio(String unidadNegocio) { this.unidadNegocio = unidadNegocio; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public Integer getInventarioPzs() { return inventarioPzs; }
    public void setInventarioPzs(Integer inventarioPzs) { this.inventarioPzs = inventarioPzs; }
}

