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
       if(ventaService.crearVenta(venta)!="venta creada"){
           return ResponseEntity.badRequest().body(ventaService.crearVenta(venta));
       }
       else{
           return ResponseEntity.ok(ventaService.crearVenta(venta));
       }

    }
   

    
    @GetMapping("/{idVenta}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable int idVenta){ 

        if(ventaService.traerVenta(idVenta) != null){
            return ResponseEntity.ok(ventaService.traerVenta(idVenta));
        }
        else{
            return ResponseEntity.notFound().build();
        }
            
    }

    
    
    @DeleteMapping("/{idVenta}")
    public ResponseEntity<Boolean> eliminarVenta(@PathVariable int idVenta){ {
        if((ventaService.eliminarVenta(idVenta))){
            return ResponseEntity.ok(ventaService.eliminarVenta(idVenta));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

    @GetMapping("/{usuarioId}/{ventaId}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable int usuarioId,
                                                    @PathVariable int ventaId){ 

        if(ventaService.generarFactura(usuarioId, ventaId)!= null){
            return ResponseEntity.ok(ventaService.generarFactura(usuarioId, ventaId));
        }
        else{
            return ResponseEntity.notFound().build();
        }
            
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> actualizarVenta(@PathVariable int id, @RequestBody Venta venta) {
        if (ventaService.actualizarVenta(id, venta)) {
            return ResponseEntity.ok(ventaService.actualizarVenta(id, venta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
