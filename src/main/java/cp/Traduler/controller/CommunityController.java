package cp.Traduler.controller;

import cp.Traduler.domain.BoardDto;
import cp.Traduler.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/community")

public class CommunityController {

    private UserService userService;
    //커뮤니티 홈화면
    @GetMapping("")
    public String community(Model model){
        List<BoardDto> boardDtoList=userService.getBoardList();
        model.addAttribute("BoardDto", boardDtoList);
        return "community";
    }

    @GetMapping("/post")
    public String Post(Model model){
        BoardDto boardDto = new BoardDto();
        model.addAttribute("BoardDto", boardDto);
        return "post";
    }

    @PostMapping("/post")
    public String Write(@Valid BoardDto boardDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "게시물 제목을 입력하세요");
            System.out.println(" com "  );
            return "post";
        }
        userService.savePost(boardDto);
        return "redirect:/community";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model){
        System.out.println("들어왓니");
        BoardDto boardDto =userService.findBoard(id);
        System.out.println("boardDto.getTitle() = " + boardDto.getTitle());
        model.addAttribute("boardDto", boardDto);
        return "test";
    }
}
