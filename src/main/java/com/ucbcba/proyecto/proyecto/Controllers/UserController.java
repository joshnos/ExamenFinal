package com.ucbcba.proyecto.proyecto.Controllers;



import com.ucbcba.proyecto.proyecto.Entities.Empresa;
import com.ucbcba.proyecto.proyecto.Entities.Role;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Repositories.UserRepository;
import com.ucbcba.proyecto.proyecto.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    private StatusService statusService;
    private RolesService rolesService;
    private CiudadService ciudadService;
    private PedidoService pedidoService;
    private EmpresaService empresaService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private void setStatusService(StatusService statusService){this.statusService=statusService;}
    @Autowired
    private void setCiudadService(CiudadService ciudadService){
        this.ciudadService=ciudadService;
    }
    @Autowired
    private void setRolesService(RolesService rolesService){this.rolesService=rolesService;}
    @Autowired
    private void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}
    @Autowired
    private void setEmpresaService(EmpresaService empresaService){this.empresaService = empresaService;}
    //@Autowired
    //private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationInit(Model model) {
        model.addAttribute("ciudades",ciudadService.listAllCiudades());
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        ///userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("ciudades",ciudadService.listAllCiudades());
            return "registration";
        }
        userService.save(user);
        securityService.autologin(user.getEmail(), user.getPasswordConfirm());
        return "redirect:/bienvenidos";
    }
    @RequestMapping(value = "/admin/listar",method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("users", userService.listAllUser());
        model.addAttribute("roles",rolesService.listAllOptions());
        model.addAttribute("empresas", empresaService.listAllEmpresas());
        model.addAttribute("CambiarRol",new Role());
        model.addAttribute("miEmpresa",new Empresa());
        return "listar";
    }
    @RequestMapping(value = "/admin/listar/set",method = RequestMethod.POST)
    public String modificarUsuario(@ModelAttribute("newUser") int userid,@ModelAttribute("CambiarRol") int roleid
    ,@ModelAttribute("miEmpresa") Empresa empresa)
    {
        Role role = rolesService.getRoleById(roleid);
        User user=userService.findById(userid);
        if(role.getName() != "EMP"){
            Set<Role> lista = user.getRoles();
            for(Role rolito: lista){
                lista.remove(rolito);
            }
            lista.add(role);
            user.setRoles(lista);
            userRepository.save(user);
        }
        else if(empresa != null)
        {
            empresa.setUser(user);
            empresaService.saveEmpresa(empresa);
        }
        return "redirect:/admin/listar";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null){
            model.addAttribute("message", "You have been logged out successfully.");
            return "redirect:/bienvenidos";
        }

        return "login";
    }

    @RequestMapping(value = "/misPedidos",method = RequestMethod.GET)
    public String mostrarPedidos(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("user",userService.findByEmail(name));
        return "pedidosUsuario";
    }

    @RequestMapping(value = "/AdminEmp/pedidosEmpresa",method = RequestMethod.GET)
    public String controlarPedidos(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByEmail(name);
        model.addAttribute("user",user);
        Empresa empresaMia = new Empresa();
        for(Empresa empresa:empresaService.listAllEmpresas()){
            if(empresa.getUser()==user){
                empresaMia=empresa;
            }
        }
        model.addAttribute("pedidos",empresaMia.getPedidos());
        model.addAttribute("empresa",empresaMia);
        model.addAttribute("statuses",statusService.listAllOptions());
        return "CambiarEstado";
    }
}