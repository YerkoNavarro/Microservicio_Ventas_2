package com.microservicio.ventas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.microservicio.ventas.entity.VentaEntity;
import com.microservicio.ventas.model.Venta;
import com.microservicio.ventas.repository.ventasRepository;
import com.microservicio.ventas.service.VentaService;

public class VentasTest {

    @Mock
    private ventasRepository ventasrepository;

    @InjectMocks
    private VentaService ventaServiceMock;

    private Venta venta;

    private VentaEntity ventaEntity;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        List<Integer>listaProductos = new ArrayList<>();
        listaProductos.add(1);
        venta = new Venta(1,1,listaProductos);
        ventaEntity =new VentaEntity();
        ventaEntity.setIdVenta(1);
        ventaEntity.setIdUsuario(1);
        ventaEntity.setIdProductos(listaProductos);
    }
    @Test
    public void crearNuevaVentaTest(){
        when(ventasrepository.existsByIdVenta(venta.getIdVenta())).thenReturn(false);
        when(ventasrepository.save(ventaEntity)).thenReturn(ventaEntity);
        String result = ventaServiceMock.crearVenta(venta);
        assertEquals( "Venta creada", result);
    }

    @Test
    public void ventaExistenteTest(){
        when(ventasrepository.existsByIdVenta(venta.getIdVenta())).thenReturn(true);
        String result = ventaServiceMock.crearVenta(venta);
        assertEquals( "venta ya existente", result);
    }

   // @Test
  //  public void actualizarVentaTest(){
   //     when(ventasrepository.existsByIdVenta(venta.getIdVenta())).thenReturn(true);
   //     when(ventasrepository.save(ventaEntity)).thenReturn(ventaEntity);
   //     boolean result = ventaServiceMock.actualizarVenta(venta.getIdVenta(), venta);
  //      assertEquals( true, result);
  //  }


    @Test
    public void actualizarVentaNoExistenteTest(){
        when(ventasrepository.existsByIdVenta(venta.getIdVenta())).thenReturn(false);
        boolean result = ventaServiceMock.actualizarVenta(venta.getIdVenta(), venta);
        assertEquals( false, result);
    }

    @Test
    public void traerVentaTest(){
        when(ventasrepository.findByIdVenta(venta.getIdVenta())).thenReturn(ventaEntity);
        Venta result = ventaServiceMock.traerVenta(venta.getIdVenta());
        assertEquals( venta, result);
    }

    @Test
    public void eliminarVentaTest(){
        when(ventasrepository.findByIdVenta(venta.getIdVenta())).thenReturn(ventaEntity);
        doNothing().when(ventasrepository).deleteByIdVenta(venta.getIdVenta());
        boolean result = ventaServiceMock.eliminarVenta(venta.getIdVenta());
        assertEquals( true, result);
    }
}
