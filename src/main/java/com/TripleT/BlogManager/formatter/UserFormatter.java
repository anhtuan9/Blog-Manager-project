package com.TripleT.BlogManager.formatter;

import com.TripleT.BlogManager.model.User;
import com.TripleT.BlogManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserFormatter implements Formatter<User> {

    private UserService userService;

    @Autowired
    public UserFormatter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User parse(String text, Locale locale) {
        return userService.findById(Long.parseLong(text));
    }

    @Override
    public String print(User object, Locale locale) {
        return "[" + object.getId() + ", " + object.getNickname() + "]";
    }
}

