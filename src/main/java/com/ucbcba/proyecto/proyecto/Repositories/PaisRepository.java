package com.ucbcba.proyecto.proyecto.Repositories;

import com.ucbcba.proyecto.proyecto.Entities.Pais;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PaisRepository extends CrudRepository<Pais, Integer> {
}
