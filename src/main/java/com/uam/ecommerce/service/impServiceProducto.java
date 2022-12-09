package com.uam.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.ecommerce.model.Producto;
import com.uam.ecommerce.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@Component("serviceProduct")
public class impServiceProducto implements IServiceProducto
{
    @Autowired
    private IProductoRepository repo;
    @Value("${ruta.archivos.imagen}")
    private String ruta;

    @Override
    public List<Producto> getListProduct()
    {
        return repo.findAll();
    }

    @Override
    public Producto findById(UUID id)
    {
        return repo.findById(id).get();
    }

    @Override
    public Producto saveProduct(String productDto, MultipartFile image) throws IOException {
        byte[] imgByte = image.getBytes();
        Path path = Paths.get(ruta + "//" + image.getOriginalFilename());
        if (!Files.exists(path)){
            Files.write(path,imgByte);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Producto producto = objectMapper.readValue(productDto, Producto.class);
        producto.setImagen(image.getOriginalFilename());
        return repo.save(producto);
    }

    @Override
    public void deleteProduct(UUID id) throws IOException {
        Producto producto = repo.findById(id).get();
        Files.deleteIfExists(Paths.get(ruta + "//" + producto.getImagen()));
        repo.deleteById(id);
    }

    @Override
    public Producto saveProductoJson(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public List<Producto> getProductDisplay() {
        return repo.getProductoDisplay();
    }
}
