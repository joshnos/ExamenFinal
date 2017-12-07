package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Direccion;
import com.ucbcba.proyecto.proyecto.Entities.Empresa;
import com.ucbcba.proyecto.proyecto.Services.CiudadService;
import com.ucbcba.proyecto.proyecto.Services.DireccionService;
import com.ucbcba.proyecto.proyecto.Services.EmpresaService;
import com.ucbcba.proyecto.proyecto.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
@Controller

public class EmpresaController {

    private EmpresaService empresaService;
    private UserService userService;
    private DireccionService direccionService;
    private CiudadService ciudadService;

    @Autowired
    public void setDireccionService(DireccionService direccionService){this.direccionService=direccionService;}

    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService = empresaService;}

    @Autowired
    public void setUserService(UserService userService){this.userService=userService;}

    @Autowired
    private void setCiudadService(CiudadService ciudadService){
        this.ciudadService=ciudadService;
    }

    @RequestMapping(value = "/admin/empresa", method = RequestMethod.POST)
    public String save(@Valid Empresa empresa, @ModelAttribute("longitud") Double longitud,@ModelAttribute("latitud") Double latitud, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users",userService.listAllUser());
            model.addAttribute("ciudades",ciudadService.listAllCiudades());
            return "empresaForm";
        }
        Direccion direccion = new Direccion();
        direccion.setLatitud(latitud);
        direccion.setLongitud(longitud);
        direccionService.saveDireccion(direccion);
        empresa.setDireccion(direccion);
        empresaService.saveEmpresa(empresa);
        return "redirect:/admin/empresas";
    }

    @RequestMapping(value = "/admin/empresas", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "empresas";
    }

    @RequestMapping(value = "/admin/empresa/new",method = RequestMethod.GET)
    public String newEmpresa(Model model){
        model.addAttribute("empresa",new Empresa());
        model.addAttribute("users",userService.listAllUser());
        model.addAttribute("ciudades",ciudadService.listAllCiudades());
        model.addAttribute("Midireccion", new Direccion());
        return "empresaForm";
    }

    @RequestMapping(value = "/admin/empresa/{id}",method = RequestMethod.GET)
    public String showEmpresa(@PathVariable Integer id, Model model){
        model.addAttribute("empresa", empresaService.getEmpresaById(id));
        return "empresa";
    }

    @RequestMapping(value = "/admin/empresa/eliminar/{id}",method = RequestMethod.GET)
    public String deleteEmpresa(@PathVariable Integer id, Model model){
        empresaService.deleteEmpresa(id);
        return "redirect:/admin/empresas";
    }

    @RequestMapping(value = "/admin/empresa/editar/{id}",method = RequestMethod.GET)
    public String editarEmpresa(@PathVariable Integer id, Model model){
        model.addAttribute("empresa",empresaService.getEmpresaById(id));
        model.addAttribute("users",userService.listAllUser());
        model.addAttribute("ciudades",ciudadService.listAllCiudades());
        return "empresaForm";
    }



}
