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

import br.com.carlosrodrigues.freela_org.core.enums.Icone;
import br.com.carlosrodrigues.freela_org.web.dtos.FlashMessage;
import br.com.carlosrodrigues.freela_org.web.dtos.ServicoFreelaForm;
import br.com.carlosrodrigues.freela_org.web.service.WebServicoFreelaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/servico")
public class WebServicoFreelaController {

    @Autowired
    WebServicoFreelaService service;

    @GetMapping
    public ModelAndView mostrarTodos() {

        var modelAndView = new ModelAndView("admin/servico/lista");
        modelAndView.addObject("lista", service.buscarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {

        var modelAndView = new ModelAndView("admin/servico/form");
        modelAndView.addObject("form", new ServicoFreelaForm());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoFreelaForm form,
     BindingResult result,
      RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "/admin/servico/form";
        }

        service.cadastrar(form);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço cadastrado com sucesso"));

        return "redirect:/admin/servico";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {

        var modelAndView = new ModelAndView("admin/servico/form");
        modelAndView.addObject("form", service.buscarPorId(id));

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@Valid @ModelAttribute("form") ServicoFreelaForm form,
    @PathVariable Long id,
    BindingResult result,
    RedirectAttributes attrs) {

        if(result.hasErrors()) {
            return "admin/servico/form";
        }

        service.editar(form, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço editado com sucesso"));

        return "redirect:/admin/servico";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {

        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço excluido com sucesso"));

        return "redirect:/admin/servico";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
    
}