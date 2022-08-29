package cp.Traduler.controller;

import cp.Traduler.domain.BoardDto;
import cp.Traduler.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/community")

public class CommunityController {

    private UserService userService;
    //커뮤니티 홈화면
    @GetMapping("")
    public String community(Model model){
        System.out.println("되니? = ");
        List<BoardDto> boardDtoList=userService.getBoardList();
        model.addAttribute("BoardDto", boardDtoList);
        System.out.println(" 이제는? "  );
        return "community";
    }

    @GetMapping("/post")
    public String Post(Model model){
        BoardDto boardDto = new BoardDto();
        model.addAttribute("BoardDto", boardDto);
        return "post";
    }

    @PostMapping("/post")
    public String Write(BoardDto boardDto){
        userService.savePost(boardDto);
        return "redirect:/community";
    }
}
