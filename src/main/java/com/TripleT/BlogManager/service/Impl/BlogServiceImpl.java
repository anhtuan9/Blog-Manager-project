package com.TripleT.BlogManager.service.Impl;

import com.TripleT.BlogManager.model.Blog;
import com.TripleT.BlogManager.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Blog findById(Long id) {
        return null;
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Blog> findAllByAuthor(Blog blog) {
        return null;
    }

    @Override
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return null;
    }
}
