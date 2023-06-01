package azkena.azkena.Controller;

import azkena.azkena.model.dao.IRolDAO;
import azkena.azkena.model.identity.Cliente;
import azkena.azkena.model.identity.Rol;
import azkena.azkena.model.service.IClienteService;
import azkena.azkena.model.service.IRolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ClienteController {


    @Autowired
    private IClienteService clienteService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private IRolService rolService;

    @GetMapping(value = {"/clientes/listar"})
    public String listar(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        return "/clientes/listar";
    }

    @GetMapping(value = "/clientes/form")
    public String crear(Model model) {

        Cliente cliente = new Cliente();
        cliente.setRol(rolService.findByRol("ROLE_USER"));
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Nuevo Cliente");
        return "clientes/form";
    }

    @PostMapping(value = "/clientes/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Cliente");
            return "/clientes/form";
        }
        cliente.setPassword(encoder.encode(cliente.getPassword()));
        clienteService.save(cliente);
        return "redirect:/eventos/listar";
    }

    @GetMapping(value = "/clientes/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Cliente cliente = null;

        if (id > 0) {
            cliente = clienteService.findOne(id);
            if (cliente == null){
                return "redirect:/eventos/listar";
        } else {
            model.put("cliente", cliente);
            model.put("titulo", "Editar Cliente");
            return "/clientes/form";
        }
    }else{
        return "redirect:/clientes/listar";
    }
}

    @GetMapping(value="/clientes/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {

        if(id > 0) {
            clienteService.delete(id);
        }
        return "redirect:/clientes/listar";
    }
}
