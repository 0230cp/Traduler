package cp.Traduler.service;

import cp.Traduler.domain.*;
import cp.Traduler.repository.BoardRepository;
import cp.Traduler.repository.PlanRepository;
import cp.Traduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private PlanRepository planRepository;

    /**
     * 회원가입 서비스
     */

    public void saveUser(UserFormDto userFormDto) throws Exception {
        User user = userFormDto.toEntity(passwordEncoder);
        validateDuplicateUser(user);
    }

    private void validateDuplicateUser(User user) throws Exception {
        Optional<User> findUser = userRepository.findById(user.getId());

        findUser.ifPresent(m -> {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
        userRepository.save(user);
        throw new Exception("회원가입에 성공했습니다!");

    }

    /**
     * 로그인 서비스 구현
     */

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("아이디와 비밀번호를 확인하세요.");
        }
        User user1 = user.get(); //user가 Optional<User> 형이라 이렇게 해줘야함. 왜그런진 아직도 이해못함.
        return new SecurityDetails(user1);
    }

    /**
     *  게시물 등록
     */
    @Transactional
    public void savePost(BoardDto boardDto){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        boardDto.setUserName(username);
        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }

    public List<BoardDto> getBoardList(){
        List<BoardDto> boardDtoList = new ArrayList<>();
        List<Board> boardList= boardRepository.findAll();
        for(Board a: boardList){
            BoardDto boardDto= BoardDto.builder()
                    .id(a.getId())
                    .title(a.getTitle())
                    .userName(a.getUserName())
                    .date(a.getDate())
                    .contents(a.getContents())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }


    public BoardDto findBoard(Long id) {
        Optional<Board> findBoard = boardRepository.findById(id);
        Board board=findBoard.get();
        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .contents(board.getContents())
                .userName(board.getUserName())
                .date(board.getDate())
                .build()
                ;
        return boardDto;
    }

    public void deletePost(Long id) throws Exception {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();

        Optional<Board> findBoard=boardRepository.findById(id);
        Board board=findBoard.get();

        if(username.equals(board.getUserName())){
            boardRepository.delete(board);
        }
        else{
            throw new Exception("삭제 권한이 없습니다.");
        }

    }

    /**
     *  나만의 여정 서비스
     */

    public void savePlan(PlanDto planDto){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName =authentication.getName();
        planDto.setUserName(userName);
        Plan plan = planDto.toEntity();
        planRepository.save(plan);
    }


    public List<PlanDto> getPlanList() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName =authentication.getName();
        List<PlanDto> planDtoList = new ArrayList<>();
        List<Plan> PlanList= planRepository.findAllByUserName(userName);
        for(Plan a: PlanList){
            PlanDto planDto= PlanDto.builder()
                    .id(a.getId())
                    .StartDate(a.getStartDate())
                    .EndDate(a.getEndDate())
                    .place(a.getPlace())
                    .memo(a.getMemo())
                    .userName(a.getUserName())
                    .build();
            planDtoList.add(planDto);
        }
        return planDtoList;
    }

    public void deletePlan(Long id) throws Exception {
        Optional<Plan> findPlan=planRepository.findById(id);
        Plan plan = findPlan.get();
        planRepository.delete(plan);
    }
}
