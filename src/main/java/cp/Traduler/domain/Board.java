package cp.Traduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) //이거 써야 auditing 기능 사용가능
@Table(name = "boardtbl")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents")
    private String contents;

    @CreatedDate
    @Column(name = "date")
    private LocalDateTime date;


}
