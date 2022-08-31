package cp.Traduler.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanDto {
    private Long id;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String endDate;
    @NotEmpty
    private String place;
    private String memo;
    private String userName;

    public Plan toEntity(){
        String changedStart=startDate.replace("T"," ");
        String changedEnd=endDate.replace("T"," ");

        LocalDateTime startdate=LocalDateTime.parse(changedStart, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime enddate=LocalDateTime.parse(changedEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return Plan.builder()
                .startDate(startdate)
                .endDate(enddate)
                .id(id)
                .place(place)
                .memo(memo)
                .userName(userName)
                .build();

    }
}
