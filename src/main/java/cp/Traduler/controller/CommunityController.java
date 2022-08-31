package cp.Traduler.controller;

import cp.Traduler.domain.BoardDto;
import cp.Traduler.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/community")

public class CommunityController {

    private UserService userService;
    //커뮤니티 홈화면
    @GetMapping("")
    public String community(@RequestParam(value="errorMessage",required = false) String errorMessage,Model model){
        List<BoardDto> boardDtoList=userService.getBoardList();
        model.addAttribute("BoardDto", boardDtoList);
        model.addAttribute("errorMessage",errorMessage);
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
            return "post";
        }
        userService.savePost(boardDto);
        return "redirect:/community";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model){
        BoardDto boardDto =userService.findBoard(id);
        model.addAttribute("boardDto", boardDto);
        return "boardDetail";
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id")Long id, RedirectAttributes redirect) {
        try {
            userService.deletePost(id);
        } catch (Exception e) {
            redirect.addAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/community";


    }


}
