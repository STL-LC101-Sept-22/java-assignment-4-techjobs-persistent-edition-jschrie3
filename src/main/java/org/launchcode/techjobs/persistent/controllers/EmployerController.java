package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    // TODO: Add a private field of EmployerRepository type called employerRepository to EmployerController.
    //  Give this field an @Autowired annotation.



    // TODO: Add an index method that responds at /employers with a list of all employers in the database.
    //  This method should use the template employers/index. To figure out the name of the model attribute
    //  you should use to pass employers into the view, review this template.




    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        // TODO: processAddEmployerForm already takes care of sending the form back if any of the submitted
        //  employer object information is invalid. However, it doesn’t yet contain the code to save a valid
        //  object. Use employerRepository and the appropriate method to do so.

        if (errors.hasErrors()) {
            return "employers/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        // TODO: displayViewEmployer will be in charge of rendering a page to view the contents of an individual
        //  employer object. It will make use of that employer object’s id field to grab the correct information
        //  from employerRepository. optEmployer is currently initialized to null. Replace this using the
        //  .findById() method with the right argument to look for the given employer object from the data layer.

        Optional optEmployer = null;
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }

}
