package com.TripleT.BlogManager.service;

import com.TripleT.BlogManager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User blog);

    void remove(Long id);
}
