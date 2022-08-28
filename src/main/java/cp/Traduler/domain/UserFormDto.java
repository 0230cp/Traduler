package cp.Traduler.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter //이거때문에 10시간 날림. Setter 안말들면 submit할때 데이터 안들어옴
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
