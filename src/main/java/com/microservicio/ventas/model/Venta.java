package com.microservicio.ventas.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    private int idVenta;
    private int idUsuario;
    private List<Integer> idProductos = new ArrayList<>();
    
}
