package com.TripleT.BlogManager.service;

import com.TripleT.BlogManager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User blog);

    void remove(Long id);

}
