package com.ucbcba.proyecto.proyecto.Services;


import com.ucbcba.proyecto.proyecto.Entities.Direccion;
import com.ucbcba.proyecto.proyecto.Repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl implements DireccionService {

    private DireccionRepository direccionRepository;

    @Autowired
    @Qualifier(value="direccionRepository")
    public void setDireccionRepository(DireccionRepository direccionRepository){this.direccionRepository=direccionRepository;}

    @Override
    public Iterable<Direccion> listAllDirecciones() {
        return direccionRepository.findAll();
    }

    @Override
    public Direccion getDireccionById(Integer id) {
        return direccionRepository.findOne(id);
    }

    @Override
    public Direccion saveDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void deleteDireccion(Integer id) {
        direccionRepository.delete(id);
    }
}
