package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public interface IServiceProducto
{
    public List<Producto> getListProduct();

    public Producto findById (UUID id);

    Producto saveProduct(String productDto, MultipartFile image) throws IOException;

    public void deleteProduct(UUID id) throws IOException;

    Producto saveProductoJson(Producto producto);

    List<Producto> getProductDisplay();
}
