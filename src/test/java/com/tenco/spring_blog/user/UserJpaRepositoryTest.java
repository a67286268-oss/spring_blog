
package com.tenco.spring_blog.user;

import com.tenco.spring_blog.user.User;
import com.tenco.spring_blog.user.UserJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // JPA 관련 컴포넌트만 로드하여 가볍고 빠르게 테스트를 수행합니다.
class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    @DisplayName("사용자명과 비밀번호로 조회 성공 테스트")
    void findByUsernameAndPassword_test() {
        // given
        String username = "testUser";
        String password = "securePassword123";

        User user = User.builder()
                .username(username)
                .password(password)
                .email("test@test.com")
                .build();
        userJpaRepository.save(user);

        // when
        Optional<User> foundUser = userJpaRepository.findByUsernameAndPassword(username, password);

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo(username);
        assertThat(foundUser.get().getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("사용자명으로 조회(중복 체크용) 테스트")
    void findByUsername_test() {
        // given
        String username = "uniqueUser";

        User user = User.builder()
                .username(username)
                .password("1234")
                .email("unique@test.com")
                .build();
        userJpaRepository.save(user);

        // when
        Optional<User> foundUser = userJpaRepository.findByUsername(username);

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo(username);
    }

    @Test
    @DisplayName("이메일로 조회(중복 체크용) 테스트")
    void findByEmail_test() {
        // given
        String email = "email@test.com";

        User user = User.builder()
                .username("emailUser")
                .password("1234")
                .email(email)
                .build();
        userJpaRepository.save(user);

        // when
        Optional<User> foundUser = userJpaRepository.findByEmail(email);

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo(email);
    }
}