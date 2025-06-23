package com.microservicio.ventas.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.microservicio.ventas.entity.VentaEntity;
import com.microservicio.ventas.model.Factura;
import com.microservicio.ventas.model.Venta;
import com.microservicio.ventas.repository.ventasRepository ;
@Service
public class VentaService {
    @Autowired
    private ventasRepository  ventasRepository;
    
    VentaEntity nVenta = new VentaEntity();

    

    public String crearVenta(Venta v){

        try {
            if (ventasRepository.existsByIdVenta(v.getIdVenta())) {
                return "venta ya existente";
            } else {
                }
            nVenta.setIdVenta(v.getIdVenta());
            nVenta.setIdUsuario(v.getIdUsuario());
            nVenta.setIdProductos(v.getIdProductos());
            ventasRepository.save(nVenta);
            return "Venta creada";
        } catch (Exception e) {
            return e.getMessage();
        }

            
    }


    public Venta traerVenta(int idVenta){

        try { VentaEntity  v = ventasRepository.findByIdVenta(idVenta);
            if (v != null) {
                Venta venta = new Venta();
                venta.setIdVenta(v.getIdVenta());
                venta.setIdUsuario(v.getIdUsuario());
                venta.setIdProductos(v.getIdProductos());
                return venta;
            
            }

        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        return null;

    }


    @Transactional
    public boolean eliminarVenta(int idV){
        try {
             VentaEntity v = ventasRepository.findByIdVenta(idV);

              if (v != null){
                ventasRepository.deleteByIdVenta(idV);
                return true;
              }else{
                return false;
              }
        } catch (Exception e) {
            return false;
        }
           
            
           
           
        
    }



    @Autowired
    RestTemplate restTemplate;
    public Factura generarFactura(int usuarioId, int ventaId){
        try {
            String usuarioUrl = "http://localhost:8081/api/v1/usuario/"+usuarioId;
            String usuarioData = restTemplate.getForObject(usuarioUrl, String.class);
            VentaEntity  v = ventasRepository.findByIdVenta(ventaId);
                if (v != null) {
                Venta venta = new Venta();
                venta.setIdVenta(v.getIdVenta());
                venta.setIdUsuario(v.getIdUsuario());
                venta.setIdProductos(v.getIdProductos());

                Factura factura = new Factura();
                factura.setCliente(usuarioData);
                factura.setCompra(venta);
                return factura;
                
                }

                
           


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    

    
}
