package cp.Traduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //이거해야 jpa auditing 쓸수잇음
public class TradulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradulerApplication.class, args);
    }
//
}
