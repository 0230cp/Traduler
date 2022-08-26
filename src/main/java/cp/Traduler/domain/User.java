package cp.Traduler.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "usertbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "pw")
    private String pw;
    @Column(name = "phone")
    private String phone;
    @Builder
    public User(String id, String name, String pw, String phone){
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.phone = phone;
    }
    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = User.builder()
                .name(userFormDto.getName())
                .id(userFormDto.getId())
                .pw(passwordEncoder.encode(userFormDto.getPw()))
                .phone(userFormDto.getPhone())
                .build();
        return user;
    }

}
