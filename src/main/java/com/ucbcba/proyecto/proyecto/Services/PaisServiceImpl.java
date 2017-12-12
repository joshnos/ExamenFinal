package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Pais;
import com.ucbcba.proyecto.proyecto.Repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {

    private PaisRepository paisRepository;

    @Autowired
    @Qualifier(value = "paisRepository")
    private void setPaisRepository(PaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }

    @Override
    public Iterable<Pais> listAllPaices() {
        return paisRepository.findAll();
    }

    @Override
    public Pais getPaisById(Integer id) {
        return paisRepository.findOne(id);
    }

    @Override
    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void deletePais(Integer id) {
        paisRepository.delete(id);
    }

}
