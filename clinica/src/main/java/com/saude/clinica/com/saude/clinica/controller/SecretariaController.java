package com.saude.clinica.com.saude.clinica.controller;

import com.saude.clinica.com.saude.clinica.model.Estados;
import com.saude.clinica.com.saude.clinica.model.Paciente;
import com.saude.clinica.com.saude.clinica.repository.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/secretaria")
public class SecretariaController {

    @Autowired
    private Pacientes pacientes;


    @RequestMapping("/novo-paciente")
    public ModelAndView novoPaciente(){
        ModelAndView mv = new ModelAndView("cadastraPacienteView");
        mv.addObject(new Paciente());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Paciente paciente, Errors errors, RedirectAttributes attributes) {

        if(errors.hasErrors()) {
            return "cadastraPacienteView";
        }

        try {
            Paciente p = pacientes.findOne(paciente.getCpf());
            if(p==null){
                pacientes.save(paciente);
                attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso");
                return "redirect:/secretaria";
            }else{
                errors.rejectValue("cpf", null, "O CPF informado já está cadastrado");
                return "cadastraPacienteView";
            }

        }catch(DataIntegrityViolationException e) {
            errors.rejectValue("dataNascimento", null, "Formato de data inválido");
            return "cadastraPacienteView";

        }
    }

    @RequestMapping("/listaPacientes")
    public ModelAndView lista(){
        List<Paciente> todosPacientes = pacientes.findAll();
        ModelAndView mv = new ModelAndView("listaPacientesView");
        mv.addObject("pacientes", todosPacientes);
        return mv;
    }


    @ModelAttribute("todosEstados")
    public List<Estados> todosStatusTitulo() {
        return Arrays.asList(Estados.values());
    }

}
