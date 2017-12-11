package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.User;

/**
 * Created by amolina on 10/05/17.
 */
public interface UserService {
    void save(User user);

    void saveData(User user);

    User edit(User user);

    Iterable<User> listAllUser();

    User findByEmail(String email);

    User findById(Integer id);
}