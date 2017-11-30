package com.ucbcba.proyecto.proyecto.Services;


import com.ucbcba.proyecto.proyecto.Repositories.StatusRepository;
import com.ucbcba.proyecto.proyecto.Entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;
    @Autowired
    @Qualifier(value = "statusRepository")
    public void setStatusRepository(StatusRepository statusRepository){this.statusRepository=statusRepository;}

    @Override
    public Iterable<Status> listAllOptions(){return statusRepository.findAll();}
    @Override
    public Status getStatusById(Integer id) {
        return statusRepository.findOne(id);
    }

    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void deleteStatus(Integer id) {
        statusRepository.delete(id);
    }
}
