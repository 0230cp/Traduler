package cp.Traduler.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardDto {

    private Long id; //글 번호

    private String userName; //아이디

    @NotEmpty
    private String title; //글 제목

    private String contents; //글 내용

    private LocalDateTime date; //작성 날짜

    public Board toEntity(){

        return Board.builder()
                .id(id)
                .userName(userName)
                .title((title))
                .contents((contents))
                .date(date)
                .build();
    }
}
