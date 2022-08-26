package cp.Traduler.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/community")

public class CommunityController {

    //커뮤니티 홈화면
    @GetMapping("")
    public String community(){
        return "community";
    }
}
