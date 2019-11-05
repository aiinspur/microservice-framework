package com.msf.msfmng.controller.sys;

import com.msf.msfmng.controller.sys.vo.RoleForm;
import com.msf.msfmng.entity.SysResource;
import com.msf.msfmng.entity.SysRole;
import com.msf.msfmng.service.sys.ResourceService;
import com.msf.msfmng.service.sys.RoleService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shihujiang
 * @date 2019-07-08
 */
@Controller
public class RoleController {

    private RoleService roleService;

    private ResourceService resourceService;

    @GetMapping("sys/roles")
    public String list(Model model) {
        model.addAttribute("roles", roleService.list(new SysRole()));
        return "sys/role/roleList.html";
    }

    @GetMapping("sys/role")
    public String add(Model model) {
        model.addAttribute("role", new RoleForm());
        return "sys/role/roleAdd.html";

    }

    @GetMapping("sys/role/{id}")
    public String get(Model model, @PathVariable Long id) {
        model.addAttribute("role", roleService.get(id));
        return "sys/role/roleUpt.html";

    }

    @GetMapping("sys/role/permission")
    public String grantPermission(@NotBlank Long roleId, Model model) {
        model.addAttribute("role", roleService.get(roleId));

        List<SysResource> list = resourceService.allResources();

        SysResource root = new SysResource();
        root.setId(0L);
        root.setName("主菜单");
        root.setParentId(-1L);
        list.add(root);
        model.addAttribute("menus", list);


        model.addAttribute("roleResources", roleService.getResourcesByRole(roleId));
        return "sys/role/roleGrantPermission.html";
    }


    @PostMapping("sys/role/permission")
    public String saveGrantPermission(@NotNull Long roleId, @NotNull String selectedIds, RedirectAttributes ra) {
        List<Long> resourceIds = Arrays.stream(selectedIds.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());

        roleService.grantPermission(roleId, resourceIds);
        ra.addFlashAttribute("roleId", roleId);
        return "redirect:/sys/role/permission?roleId=" + roleId;
    }

    @PutMapping("sys/role")
    public String uptSave(@Valid RoleForm roleForm, Errors errors) {
        if (errors.hasErrors()) {
            return "sys/role/roleUpt.html";
        }
        roleService.saveOrUpt(copy(roleForm));
        return "redirect:/sys/roles";
    }

    @PostMapping("sys/role")
    public String createSave(@Valid RoleForm roleForm, Errors errors) {
        if (errors.hasErrors()) {
            return "sys/role/roleAdd.html";
        }
        roleService.saveOrUpt(copy(roleForm));
        return "redirect:/sys/roles";
    }

    @DeleteMapping("sys/role")
    public String delete(Long id) {
        roleService.delete(id);
        return "redirect:/sys/roles";
    }

    private SysRole copy(RoleForm roleForm) {
        BeanCopier copier = BeanCopier.create(RoleForm.class, SysRole.class, false);
        SysRole entity = new SysRole();
        copier.copy(roleForm, entity, null);
        return entity;
    }

    public RoleController(RoleService roleService, ResourceService resourceService) {
        this.roleService = roleService;
        this.resourceService = resourceService;
    }


}
