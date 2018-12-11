package com.TripleT.BlogManager.controller;

import com.TripleT.BlogManager.model.Blog;
import com.TripleT.BlogManager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ModelAndView showBlog(Pageable pageable) {
        Page<Blog> blogs;
        blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/User/list");
        modelAndView.addObject("blog", blogs);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showPost() {
        ModelAndView modelAndView = new ModelAndView("/User/add");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addPost(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("/User/add");
        blogService.save(blog);
        modelAndView.addObject("message", "Add Success !");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/User/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editPost(@ModelAttribute("post") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("/User/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Edit Success !");
        return modelAndView;
    }

    @GetMapping("/del/{id}")
    public String delStar(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/admin";
    }
}
