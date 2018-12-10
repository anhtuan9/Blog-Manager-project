package com.TripleT.BlogManager.service.Impl;

import com.TripleT.BlogManager.model.User;
import com.TripleT.BlogManager.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User blog) {

    }

    @Override
    public void remove(Long id) {

    }
}
