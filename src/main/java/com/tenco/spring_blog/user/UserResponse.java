package com.tenco.spring_blog.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class JoinDto {
        private Long id;
        private String username;
        private String email;

        public JoinDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }

    @Data
    public static class updateFormDto {
        private Long id;
        private String username;
        private String email;

        public updateFormDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }


}
