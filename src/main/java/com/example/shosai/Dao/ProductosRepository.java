package com.example.shosai.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.shosai.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {

    Producto findFirstByCodigo(String codigo);
    
    @Query(value = "select * from producto", nativeQuery = true)
    public List<Producto> lstProducto();
}
