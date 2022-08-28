package cp.Traduler.service;

import cp.Traduler.domain.User;
import cp.Traduler.domain.UserFormDto;
import cp.Traduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

    public void saveUser(UserFormDto userFormDto) throws Exception {
        User user=userFormDto.toEntity(passwordEncoder);
        validateDuplicateUser(user);
    }

    private void validateDuplicateUser(User user) throws Exception {
    Optional<User> findUser = userRepository.findById(user.getId());

        findUser.ifPresent(m->{
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
        userRepository.save(user);
        throw new Exception("회원가입에 성공했습니다!");
    }

}
