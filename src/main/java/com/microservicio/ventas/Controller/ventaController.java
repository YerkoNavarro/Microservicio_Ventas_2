package com.microservicio.ventas.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.ventas.model.Factura;
import com.microservicio.ventas.model.Venta;
import com.microservicio.ventas.service.VentaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/api/v1/ventas")
public class ventaController {
    @Autowired
    private VentaService ventaService;


    @PostMapping("/")
ResponseEntity<String> obtenerVenta(@RequestBody Venta venta){
    if (!ventaService.crearVenta(venta)) {
        System.out.println("Venta ya existente");
        return ResponseEntity.badRequest().body("Venta ya existente");
    } else {
        System.out.println("Venta creada con exito");
        return ResponseEntity.ok("Venta creada con éxito");
    }
}
   

    
    @GetMapping("/{idVenta}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable int idVenta){ 

        if(ventaService.traerVenta(idVenta) != null){
            System.out.println("Venta encontrada con exito");
            return ResponseEntity.ok(ventaService.traerVenta(idVenta));
        }
        else{
            System.out.println("Venta no encontrada");
            return ResponseEntity.notFound().build();
        }
            
    }

    
    
    @DeleteMapping("/{idVenta}")
    public ResponseEntity<Boolean> eliminarVenta(@PathVariable int idVenta){ {
        if((ventaService.eliminarVenta(idVenta))){
            System.out.println("Venta eliminada con exito");
            return ResponseEntity.ok(ventaService.eliminarVenta(idVenta)) ;
        }else{
            System.out.println("Venta no encontrada");
            return ResponseEntity.notFound().build();
        }
    }
}

    @GetMapping("/{usuarioId}/{ventaId}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable int usuarioId,
                                                    @PathVariable int ventaId){ 

        if(ventaService.generarFactura(usuarioId, ventaId)!= null){
            System.out.println("Factura generada con exito");
            return ResponseEntity.ok(ventaService.generarFactura(usuarioId, ventaId));
        }
        else{
           
            System.out.println("No se pudo generar la factura");
            return ResponseEntity.notFound().build();
        }
            
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> actualizarVenta(@PathVariable int id, @RequestBody Venta venta) {
        if (ventaService.actualizarVenta(id, venta)) {
            System.out.println("Venta actualizada con exito");
            return ResponseEntity.ok(ventaService.actualizarVenta(id, venta));
        } else {
            System.out.println("No se pudo actualizar la venta");
            return ResponseEntity.notFound().build();
        }
    }



}
