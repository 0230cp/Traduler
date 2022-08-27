package cp.Traduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserFormDto {
    private String name;
    private String id;
    private String pw;
    private String phone;

    public User toEntity(PasswordEncoder passwordEncoder){
        return User.builder()
                .name(name)
                .id(id)
                .pw(passwordEncoder.encode(pw))
                .phone((phone))
                .build();
    }
}
