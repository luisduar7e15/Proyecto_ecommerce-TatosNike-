package com.uam.ecommerce.controller;

import com.uam.ecommerce.model.Producto;
import com.uam.ecommerce.service.IServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ControllerProducto
{
    @Qualifier("serviceProduct")
    @Autowired
    private IServiceProducto service;

    @GetMapping("/listAll")
    public List<Producto> getAll(){return service.getListProduct();}

    @GetMapping("/list")
    public List<Producto> getProductoDisplay()
    {
        return service.getProductDisplay();
    }

    @PostMapping("/save")
    public Producto saveProduct(@RequestPart("producto") String productDto, @RequestPart("imagen") MultipartFile image) throws IOException {
        return service.saveProduct(productDto, image);
    }

    @GetMapping("/{id}")
    public Producto getProduct(@PathVariable UUID id)
    {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) throws IOException {
        service.deleteProduct(id);
    }

    @PostMapping("/saveJson")
    public void  saveProductoJson(@RequestBody Producto producto) {
        service.saveProductoJson(producto);
    }
}
