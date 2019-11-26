package com.msf.msfmng.controller.sys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msf.msfmng.entity.Dict;
import com.msf.msfmng.entity.DictData;
import com.msf.msfmng.service.sys.DictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-08-01
 */
@Controller
public class DictController {

    private static final String ADD_VIEW_NAME = "sys/dict/add";
    private static final String UPDATE_VIEW_NAME = "sys/dict/update";
    private static final String LIST_VIEW_NAME = "sys/dict/list";

    private DictService dictService;

    @ResponseBody
    @RequestMapping("sys/dicts/page")
    public String page(Dict dict, HttpServletRequest request,
                       @RequestParam(value = "start", defaultValue = "0") Integer start,
                       @RequestParam(value = "length", defaultValue = "10") Integer length) throws JsonProcessingException {
        Pageable pageable = PageRequest.of(start / length , length);

        Page<Dict> page = dictService.page(pageable);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("recordsTotal", page.getTotalElements());
        root.put("recordsFiltered", page.getTotalElements());
        root.putPOJO("data", page.getContent());

        String json = mapper.writeValueAsString(root);
        return json;
    }

    @GetMapping("sys/dicts")
    public String list(Model model, Dict dict) {
        List<Dict> list = dictService.list(dict);
        model.addAttribute("list", list);
        return LIST_VIEW_NAME;
    }


    @GetMapping("sys/dict")
    public String create(Model model) {
        model.addAttribute("obj", new Dict());
        return ADD_VIEW_NAME;
    }

    @PostMapping("sys/dict")
    public String save(@Valid Dict dict, Errors errors) {
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }
        dictService.saveOrUpt(dict);

        return "redirect:/sys/dicts";
    }


    @GetMapping("sys/dict/{code}/data")
    public String dataList(Model model, @PathVariable("code") String code) {
        List<DictData> dataList = dictService.getDataByDictCode(code);
        model.addAttribute("list", dataList);
        return "sys/dictData/list";
    }

    @GetMapping("sys/dict/data/{dictCode}")
    public String dataCreate(Model model, @PathVariable String dictCode) {
        DictData dictData = new DictData();
        dictData.setCode(dictCode);
        model.addAttribute("obj", dictData);
        return "sys/dictData/add";
    }


    @PostMapping("sys/dict/data")
    public String save(@Valid DictData data, Errors errors) {
        if (errors.hasErrors()) {
            return "sys/dictData/list";
        }
        dictService.saveDictData(data);

        return "redirect:/sys/dict/" + data.getCode() + "/data";
    }


    @GetMapping("sys/dict/{code}/data/delete/{dictDataId}")
    public String deleteDictData(@PathVariable String code, @PathVariable Long dictDataId) {
        dictService.deleteDictData(dictDataId);
        return "redirect:/sys/dict/" + code + "/data";
    }


    public DictController(DictService dictService) {
        this.dictService = dictService;
    }
}
