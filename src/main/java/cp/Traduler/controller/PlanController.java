package cp.Traduler.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/plan")
public class PlanController {
    @GetMapping("/")
    public String main(){
        return "plan";
    }
}
