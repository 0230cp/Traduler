package cp.Traduler.service;

import cp.Traduler.domain.User;
import cp.Traduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);

        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
    Optional<User> findUser = userRepository.findById(user.getId());
        findUser.ifPresent(m->{
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
    }

}
