package cp.Traduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) //이거 써야 auditing 기능 사용가능
@Table(name = "plantbl")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "startdate")
    private LocalDateTime startDate;
    @Column(name = "enddate")
    private LocalDateTime endDate;
    @Column(name ="place")
    private String place;
    @Column(name = "memo")
    private String memo;
    @Column(name = "username")
    private String userName;



}
