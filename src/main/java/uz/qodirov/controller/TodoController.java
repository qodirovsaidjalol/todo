package uz.qodirov.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.qodirov.dto.todo.TodoCreateDto;
import uz.qodirov.dto.todo.TodoUpdateDto;
import uz.qodirov.service.TodoService;


import javax.validation.Valid;

@Controller
@RequestMapping("/todo/*")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping("create")
    public String createPage(Model model) {
        model.addAttribute("dto", new TodoCreateDto());
        return "todo/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") TodoCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo/create";
        }
        service.create(dto);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("todo", service.getById(id));
        return "todo/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("todo", service.getById(id));
        return "todo/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute(name = "dto") TodoUpdateDto dto) {
        service.update(dto);
        return "redirect:/todo/list";
    }

    @RequestMapping("list")
    public String list(Model model/*, @PathVariable(name = "userId") Long userId*/) {
        model.addAttribute("todos", service.getAllByUserId());
        return "todo/list";
    }

    @PostAuthorize("hasRole('ADMIN')")
    @RequestMapping("all")
    public String all(Model model) {
        model.addAttribute("todos", service.getAll());
        return "todo/all";
    }
}
