package com.msf.msfmng.controller.sys;

import com.msf.msfmng.controller.sys.vo.ResourceForm;
import com.msf.msfmng.entity.SysResource;
import com.msf.msfmng.service.sys.ResourceService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Resource Controller
 *
 * @author shihujiang
 * @date 2019-07-08
 */
@Controller
public class ResourceController {

    private static final String ADD_VIEW_NAME = "sys/resource/resourceAdd";
    private static final String UPDATE_VIEW_NAME = "sys/resource/resourceUpdate";
    private static final String LIST_VIEW_NAME = "sys/resource/resourceList";

    private ResourceService resourceService;


    @ModelAttribute("menuHref")
    public String module() {
        return "sys/resource";
    }


    @GetMapping("sys/resources")
    public String list(Model model) {
        List<SysResource> resourceList = resourceService.allResources();
        model.addAttribute("resourceList", resourceList);

        return LIST_VIEW_NAME;
    }

    @GetMapping("sys/resource")
    public String create(Long pid, Model model) {
        ResourceForm resourceForm = new ResourceForm();
        resourceForm.setParentId(pid);
        model.addAttribute("addOrUpt", "add");
        model.addAttribute("resource",resourceForm);
        return ADD_VIEW_NAME;
    }


    @GetMapping("sys/resource/{id}")
    public String jumpTpUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("addOrUpt", "upt");
        model.addAttribute("resource",resourceService.get(id));

        return UPDATE_VIEW_NAME;
    }

    @PutMapping("sys/resource")
    public String update(@Valid ResourceForm resourceForm,Errors errors){
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }
        resourceService.saveOrUpt(copy(resourceForm));
        return "redirect:/sys/resources";
    }

    @PostMapping("sys/resource")
    public String save(@Valid ResourceForm resourceForm, Errors errors) {
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }
        resourceService.saveOrUpt(copy(resourceForm));

        return "redirect:/sys/resources";
    }

    private SysResource copy(ResourceForm resourceForm) {
        BeanCopier copier = BeanCopier.create(ResourceForm.class, SysResource.class, false);
        SysResource entity = new SysResource();
        copier.copy(resourceForm, entity, null);
        return entity;
    }


    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

}
