package cp.Traduler.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanDto {
    private Long id;
    @NotEmpty
    private LocalDateTime startDate;
    @NotEmpty
    private LocalDateTime endDate;
    @NotEmpty
    private String place;
    private String memo;
    private String userName;

    public Plan toEntity(){
        return Plan.builder()
                .startDate(startDate)
                .endDate(endDate)
                .id(id)
                .place(place)
                .memo(memo)
                .userName(userName)
                .build();

    }
}
