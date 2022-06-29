/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;


public class UploadFile {

    @Autowired
    Producto producto;

    public List<Producto> guardarFile(MultipartFile path) throws IOException, CsvValidationException {
        List<Producto> producto = new ArrayList<>();

        String ruta = "/app" + path.getOriginalFilename();
        File localFile = new File(ruta);
        path.transferTo(localFile);

        CSVReader csvReader = new CSVReader(new FileReader(ruta));
        String[] fila = null;
        csvReader.readNext();
        while ((fila = csvReader.readNext()) != null) {

            String[] datos = fila[0].split(",");
            /*System.out.println("fila: "+fila);
            System.out.println("fila[0]: "+fila[0]);
            System.out.println("datos: "+datos);*/
            Producto p = new Producto();
            //p.setId(Integer.parseInt(datos[0]));
            p.setNombre((fila[0]));
            //System.out.println(fila[0]);
            
            p.setCodigo(fila[1]);
            //System.out.println(fila[1]);
            
            p.setPrecio(Float.parseFloat(fila[2]));
            //System.out.println(fila[2]);
            
            p.setExistencia(Float.parseFloat(fila[3]));
            //System.out.println(fila[3]);
            
           
            producto.add(p);

        }
        csvReader.close();
        return producto;
    }
}
