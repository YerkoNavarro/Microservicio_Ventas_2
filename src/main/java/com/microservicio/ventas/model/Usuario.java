package com.microservicio.ventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;

}
