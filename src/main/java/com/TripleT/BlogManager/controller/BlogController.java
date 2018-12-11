package com.TripleT.BlogManager.controller;

import com.TripleT.BlogManager.model.Blog;
import com.TripleT.BlogManager.model.Post;
import com.TripleT.BlogManager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/post")
    public ModelAndView showPost() {
        ModelAndView modelAndView = new ModelAndView("post");
        modelAndView.addObject("post", new Blog());
        return modelAndView;
    }

    @PostMapping("/post")
    public ModelAndView addPost(@ModelAttribute("post") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("post");
        blogService.save(blog);
        modelAndView.addObject("message", "Add Success !");
        return modelAndView;
    }

    @GetMapping("/post/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/post")
    public ModelAndView editPost(@ModelAttribute("post") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("edit");
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
