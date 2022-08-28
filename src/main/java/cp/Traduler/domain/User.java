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
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    내가 pk로 정한 값은 String형인데 기본키를 자동생성 하려 하니 오류가 남..
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

}
