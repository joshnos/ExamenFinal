package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Pais;
import com.ucbcba.proyecto.proyecto.Services.CiudadService;
import com.ucbcba.proyecto.proyecto.Services.PaisService;
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
public class PaisController {

    private PaisService paisService;
    private CiudadService ciudadService;

    @Autowired
    private void setPaisService(PaisService paisService){this.paisService = paisService;}

    @Autowired
    private void setCiudadService(CiudadService ciudadService){
        this.ciudadService=ciudadService;
    }

    @RequestMapping(value = "/admin/pais", method = RequestMethod.POST)
    public String save(@Valid Pais pais, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("ciudades",ciudadService.listAllCiudades());
            return "paisForm";
        }
        paisService.savePais(pais);
        return "redirect:/admin/paises";
    }

    @RequestMapping(value = "/admin/paises", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("paises", paisService.listAllPaices());
        return "paises";
    }

    @RequestMapping(value = "/admin/pais/new",method = RequestMethod.GET)
    public String newPais(Model model){
        model.addAttribute("pais", new Pais());
        model.addAttribute("ciudades", ciudadService.listAllCiudades());
        return "paisForm";
    }

    @RequestMapping(value = "/admin/pais/{id}",method = RequestMethod.GET)
    public String showPais(@PathVariable Integer id, Model model){
        model.addAttribute("pais",paisService.getPaisById(id));
        return "pais";
    }

    @RequestMapping(value = "/admin/pais/eliminar/{id}",method = RequestMethod.GET)
    public String deletePais(@PathVariable Integer id, Model model){
        paisService.deletePais(id);
        return "redirect:/admin/paises";
    }

    @RequestMapping(value = "/admin/pais/editar/{id}",method = RequestMethod.GET)
    public String editarEmpresa(@PathVariable Integer id, Model model){
        model.addAttribute("pais",paisService.getPaisById(id));
        return "paisForm";
    }
}
