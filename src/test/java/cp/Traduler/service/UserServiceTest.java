package cp.Traduler.service;

import cp.Traduler.TradulerApplication;
import cp.Traduler.domain.User;
import cp.Traduler.domain.UserFormDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = TradulerApplication.class)
@Transactional

class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        UserFormDto userFormDto = UserFormDto.builder()
                .name("고재찬")
                .id("rnjsgo")
                .pw("1234")
                .phone("123456789")
                .build();
        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 Test")
    @Rollback(false)
    void saveUser() {
        User user = createUser();
        User savedUser = userService.saveUser(user);

        System.out.println("savedUserName = " + savedUser.getName());
        System.out.println("savedUserId = " + savedUser.getId());
        assertEquals(user.getId(), savedUser.getId());
    }
}