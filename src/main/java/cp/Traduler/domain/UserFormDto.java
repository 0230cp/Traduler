package cp.Traduler.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserFormDto {
    private String name;
    private String id;
    private String pw;
    private String phone;

    @Builder
    public UserFormDto(String name, String id, String pw, String phone) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.phone = phone;
    }
}
