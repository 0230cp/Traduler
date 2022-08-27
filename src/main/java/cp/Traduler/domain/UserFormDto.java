package cp.Traduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserFormDto {
    private String name;
    private String id;
    private String pw;
    private String phone;
    
}
