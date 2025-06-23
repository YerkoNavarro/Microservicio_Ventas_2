package com.microservicio.ventas.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.ventas.entity.VentaEntity;




@Repository


public interface ventasRepository extends JpaRepository<VentaEntity, Integer> {

    VentaEntity findByIdVenta(int idVenta);
    boolean existsByIdVenta(int idVenta);
    void deleteByIdVenta(int idVenta);
    

}
