package br.com.carlosrodrigues.freela_org.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin/usuarios")
public class WebUsuarioFreelaController {
    
    @Autowired
    private WebUsuarioFreelaService service;

    @GetMapping
    public ModelAndView mostrarTodos() {

        var modelAndView = new ModelAndView("admin/usuario/lista");
        modelAndView.addObject("usuarios", service.mostrarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {

        var modelAndView = new ModelAndView("admin/usuario/cadastroForm");
        modelAndView.addObject("cadastroForm", new UsuarioFreelaCadastroForm());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("cadastroForm") UsuarioFreelaCadastroForm form,
    BindingResult result,
    RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/usuario/cadastroForm";
        }

        try{
        service.cadastrar(form);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario cadastrado com sucesso"));
        } catch(ValidacaoException e) {
        result.addError(e.getFieldError());
        return "admin/cadastroForm";
        }

        return "redirect:/admin/usuario";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {

        var modelAndView = new ModelAndView("admin/usuario/edicaoForm");
        modelAndView.addObject("edicaoForm", service.buscarPorId(id));

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id,
    @Valid @ModelAttribute("edicaoForm") UsuarioFreelaEdicaoForm form,
    BindingResult result,
    RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/usuario/edicaoForm";
        }

        try{
        service.editar(form, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert_success", "Usuario editado com sucesso"));
        } catch(ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuario/edicaoForm";
        }

        return "redirect:/admin/usuario";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {

        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuario excluido com sucesso"));

        return "redirect:/admin/usuario";
    }
}
