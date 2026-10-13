package com.tenco.spring_blog.user;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class SessionUserDto {
    private Long id;
    private String username;
    private String email;

    public SessionUserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
