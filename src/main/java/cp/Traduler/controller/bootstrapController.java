package cp.Traduler.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class bootstrapController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
}
