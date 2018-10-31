package com.pentavex.owenpay.service;

import com.pentavex.owenpay.domain.User;
import com.pentavex.owenpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveOrUpdate(final User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveOrUpdateUserForm(final User user) {

        User savedUser = saveOrUpdate(user);

        System.out.println("Saved User Id: " + savedUser.getId());
        return savedUser;
    }
}
