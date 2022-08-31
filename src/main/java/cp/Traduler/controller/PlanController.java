package cp.Traduler.controller;


import cp.Traduler.domain.PlanDto;
import cp.Traduler.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private UserService userService;
    @GetMapping("")
    public String plan(@RequestParam(value="errorMessage",required = false) String errorMessage,Model model){
        List<PlanDto> planDtoList = userService.getPlanList();
        model.addAttribute("PlanDto",planDtoList);
        model.addAttribute("errorMessage",errorMessage);
        return "myPlan";
    }

    @GetMapping("/delete/{id}")
    public String deletePlan(@PathVariable("id")Long id) throws Exception {
        userService.deletePlan(id);
        return "redirect:/plan";
    }

    @GetMapping("/add")
    public String addPlan(Model model){
            return "addPlan";
    }


}
