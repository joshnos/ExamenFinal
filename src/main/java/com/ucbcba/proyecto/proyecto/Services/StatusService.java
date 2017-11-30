package com.ucbcba.proyecto.proyecto.Services;
import com.ucbcba.proyecto.proyecto.Entities.Status;

public interface StatusService {
    Iterable<Status> listAllOptions();
    Status getStatusById(Integer id);
    Status saveStatus(Status status);
    void deleteStatus(Integer id);
}
