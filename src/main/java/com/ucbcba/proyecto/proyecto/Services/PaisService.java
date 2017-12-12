package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Pais;

public interface PaisService {

    Iterable<Pais> listAllPaices();
    Pais getPaisById(Integer id);
    Pais savePais(Pais pais);
    void deletePais(Integer id);
}
