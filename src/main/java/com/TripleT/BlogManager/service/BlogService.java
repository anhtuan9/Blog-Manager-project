package com.TripleT.BlogManager.service;

import com.TripleT.BlogManager.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
    Iterable<Blog> findAllByAuthor(Blog blog);
    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
