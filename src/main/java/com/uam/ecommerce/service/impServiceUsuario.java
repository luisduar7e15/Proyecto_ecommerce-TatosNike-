package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Direccion;
import com.uam.ecommerce.model.UsuarioWeb;
import com.uam.ecommerce.repository.IDireccionRepository;
import com.uam.ecommerce.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("serviceUsuario")
public class impServiceUsuario implements IServiceUsuario{

    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private IDireccionRepository repoDet;

    @Override
    public List<UsuarioWeb> listAll() {
        return repo.findAll();
    }

    @Override
    public UsuarioWeb findById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public UsuarioWeb saveUsuario(UsuarioWeb usuarioWeb) {
        UsuarioWeb o = new UsuarioWeb();
        o.setId(usuarioWeb.getId());
        o.setEmail(usuarioWeb.getEmail());
        o.setContraseña(usuarioWeb.getContraseña());
        o.setNombres(usuarioWeb.getNombres());
        o.setApellidos(usuarioWeb.getApellidos());
        o.setTelefono(usuarioWeb.getTelefono());
        o.setContraseña(usuarioWeb.getContraseña());
        List<Direccion> direccions = usuarioWeb.getDireccions();
        usuarioWeb.setDireccions(null);
        for (Direccion det : direccions){
            det.setUsuarioWeb(o);
        }
        o.setDireccions(direccions);
        return repo.save(o);
    }

    @Override
    public void deleteUsuario(String id) {
        repo.deleteById(id);
    }
}
