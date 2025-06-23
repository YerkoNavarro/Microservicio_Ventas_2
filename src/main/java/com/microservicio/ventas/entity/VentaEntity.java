package com.microservicio.ventas.entity;


import jakarta.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VentaEntity {
    

    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Id
    private int idVenta;

    private int idUsuario;

    @CollectionTable(name = "venta_productos", 
    joinColumns = @JoinColumn(name = "venta_id"))
    @Column(name = "producto_id") 
    private List<Integer> idProductos = new ArrayList();

}
