package com.msf.msfmng.controller.sys;

import com.msf.msfmng.controller.BaseController;
import com.msf.msfmng.controller.sys.vo.InstitutionForm;
import com.msf.msfmng.entity.Institution;
import com.msf.msfmng.service.sys.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * 机构管理
 *
 * @author shihujiang
 * @date 2019-07-30
 */
@Controller
public class InstitutionController extends BaseController<InstitutionForm, Institution> {

    private static final String ADD_VIEW_NAME = "sys/institution/add";
    private static final String UPDATE_VIEW_NAME = "sys/institution/update";
    private static final String LIST_VIEW_NAME = "sys/institution/list";

    private InstitutionService institutionService;


    @GetMapping("sys/institutions")
    public String list(Model model, InstitutionForm form) {
        List<Institution> list = institutionService.list(beanCopy(form, new Institution()));
        model.addAttribute("list", list);

        return LIST_VIEW_NAME;
    }

    @GetMapping("sys/institution")
    public String create(Long pid, Model model) {
        InstitutionForm form = new InstitutionForm();
        form.setPid(pid);
        model.addAttribute("addOrUpt", "add");
        model.addAttribute("obj", form);
        return ADD_VIEW_NAME;
    }


    @GetMapping("sys/institution/{id}")
    public String jumpTpUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("addOrUpt", "upt");
        model.addAttribute("obj", institutionService.get(id));

        return UPDATE_VIEW_NAME;
    }

    @PutMapping("sys/institution")
    public String update(@Valid InstitutionForm form, Errors errors) {
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }
        institutionService.saveOrUpt(beanCopy(form, new Institution()));
        return "redirect:/sys/institutions";
    }

    @PostMapping("sys/institution")
    public String save(@Valid InstitutionForm form, Errors errors) {
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }
        institutionService.saveOrUpt(beanCopy(form, new Institution()));

        return "redirect:/sys/institutions";
    }


    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

}
