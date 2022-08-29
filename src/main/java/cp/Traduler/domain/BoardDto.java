package cp.Traduler.domain;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardDto {

    private Long id;

    private String userName;

    private String title;

    private String contents;

    private LocalDateTime date;

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
