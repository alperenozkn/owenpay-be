package com.pentavex.owenpay.service;

import java.util.List;

import com.pentavex.owenpay.domain.User;

public interface UserService {

    List<User> listAll();
    User getById(Long id);
    User saveOrUpdate(User user);
    void delete(Long id);
    User saveOrUpdateUserForm(User user);
}
