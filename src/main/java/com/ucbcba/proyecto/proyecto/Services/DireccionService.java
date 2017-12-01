package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Direccion;

public interface DireccionService {
    Iterable<Direccion> listAllDirecciones();

    Direccion getDireccionById(Integer id);

    Direccion saveDireccion(Direccion direccion);

    void deleteDireccion(Integer id);
}
