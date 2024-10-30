package br.com.carlosrodrigues.freela_org.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.carlosrodrigues.freela_org.core.exception.ValidacaoException;
import br.com.carlosrodrigues.freela_org.web.dtos.FlashMessage;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaCadastroForm;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaEdicaoForm;
import br.com.carlosrodrigues.freela_org.web.service.WebUsuarioFreelaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/usuarios")
public class WebUsuarioFreelaController {
    
    private WebUsuarioFreelaService service;

    @GetMapping
    public ModelAndView mostrarTodos() {

        var modelAndView = new ModelAndView("admin/usuarios/lista");
        modelAndView.addObject("lista", service.mostrarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {

        var modelAndView = new ModelAndView("admin/usuarios/cadastrar");
        modelAndView.addObject("formCadastro", new UsuarioFreelaCadastroForm());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("formCadastro") UsuarioFreelaCadastroForm form,
    BindingResult result,
    RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/usuarios/formCadastro";
        }

        try{
        service.cadastrar(form);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario cadastrado com sucesso"));
        } catch(ValidacaoException e) {
        result.addError(e.getFieldError());
        return "redirect:/admin/formCadastro";
        }

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {

        var modelAndView = new ModelAndView("admin/usuarios/eitar");
        modelAndView.addObject("formEdicao", service.buscarPorId(id));

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id,
    @Valid @ModelAttribute("formEdicao") UsuarioFreelaEdicaoForm form,
    BindingResult result,
    RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/usuarios/formEdicao";
        }

        try{
        service.editar(form, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert_success", "Usuario editado com sucesso"));
        } catch(ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuarios/formEdicao";
        }

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {

        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario excluido com sucesso"));

        return "redirect:/admin/usuarios";
    }
}
