package com.microservicio.ventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private int idProducto;
    private String nombre;
    private int precio;
    private int stock;

}
