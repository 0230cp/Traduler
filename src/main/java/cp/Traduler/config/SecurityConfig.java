package cp.Traduler.config;

import cp.Traduler.handler.LoginFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginFailHandler loginFailHandler; //로그인 핸들러 의존성 주입
    @Bean // 패스워드 암호화 관련 메소드
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/js/**","/bootstrap/css/**","/bootstrap/img/**","/bootstrap/scss/**","/bootstrap/vendor/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/plan").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureHandler(new LoginFailHandler())
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        ;
    }



    }


