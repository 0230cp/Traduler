package cp.Traduler.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserFormDto {
    private String name;
    private String pw;
    private String phone;

    @Builder
    public UserFormDto(String name, String pw, String phone) {
        this.name = name;
        this.pw = pw;
        this.phone = phone;
    }
}
