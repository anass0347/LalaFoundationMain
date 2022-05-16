package nl.hu.Todss.WasteBar.lalafoundation.presentation.controller;

import nl.hu.Todss.WasteBar.lalafoundation.application.MedewerkerService;
import nl.hu.Todss.WasteBar.lalafoundation.domain.Medewerker;

import nl.hu.Todss.WasteBar.lalafoundation.domain.exception.MedewerkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@CrossOrigin(origins = "http://localhost:8081")

//@RestController
//@RequestMapping("/")

@Controller
public class MedewerkerController {

    @Autowired
    private final MedewerkerService medewerkerService;

    public MedewerkerController(MedewerkerService medewerkerService) {
        this.medewerkerService = medewerkerService;
    }

    @GetMapping("/addnew")
    public String addNewMedewerker(Model model , RedirectAttributes ra) {
        Medewerker medewerker = new Medewerker();
        model.addAttribute("medewerker", medewerker);
        model.addAttribute("pageTitle", "Add New Mederwerker");
        return "mederwerker_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("medewerker") Medewerker medewerker, RedirectAttributes ra) {
        medewerkerService.save(medewerker);
        ra.addFlashAttribute("message", "de mederwerker is toegevoegd");
        return "redirect:/";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", medewerkerService.getAllMedewerker());
        return "index";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model, RedirectAttributes ra) {
        try {
            Medewerker medewerker = medewerkerService.getById(id);
            model.addAttribute("medewerker", medewerker);
            model.addAttribute("pageTitle", "Update Medewerker (ID: " + id + ")");
            return "update";
        } catch (MedewerkerNotFoundException e){
            ra.addFlashAttribute("message", "de mederwerker is toegevoegd");
            return "redirect:/";
        }
    }

    @GetMapping("/deleteMedewerker/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        medewerkerService.deleteViaId(id);
        return "redirect:/";
    }
}
