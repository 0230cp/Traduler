package cp.Traduler.controller;


import cp.Traduler.domain.PlanDto;
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
        PlanDto planDto = new PlanDto();
        model.addAttribute("planDto",planDto);
            return "addPlan";
    }

    @PostMapping("/add")
    public String add(@Valid PlanDto planDto, BindingResult bindingResult, Model model){
        System.out.println("model = " + model);
     if(bindingResult.hasErrors()){
         model.addAttribute("errorMessage","입력 정보를 확인하세요.");
     }
     userService.savePlan(planDto);
    return "redirect:/plan/add";
    }


}
