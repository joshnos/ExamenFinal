package com.ucbcba.proyecto.proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ucbcba.proyecto.proyecto.Entities.Status;

import javax.transaction.Transactional;

@Transactional
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
