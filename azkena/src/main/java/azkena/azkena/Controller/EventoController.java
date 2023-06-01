package azkena.azkena.Controller;

import azkena.azkena.model.identity.Evento;
import azkena.azkena.model.service.IEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class EventoController {

    @Autowired
    private IEventoService eventoService;
    @GetMapping(value={"/eventos/listar"})
    public String listar(Model model) {
        List<Evento> eventos= eventoService.findAll();
        model.addAttribute("eventos", eventos);

        return "/eventos/listar";
    }
    @GetMapping("/eventos/pruebaformulario")
    public String crear(Model model) {
        Evento evento = new Evento();
        model.addAttribute("evento", evento);
        model.addAttribute("titulo", "Nuevo evento");

        return "/eventos/pruebaformulario";
    }
    @GetMapping(value="/eventos/pruebaformulario/{id}")
    public String editar(@PathVariable(value="id") Long id,Map<String, Object> model) {

        Evento evento = null;

        if(id > 0) {
            evento = eventoService.findOne(id);
            if (evento == null)
                return "redirect:/eventos/listar";
        } else {
            return "redirect:/eventos/listar";
        }
        model.put("evento", evento);
        model.put("titulo", "Editar Evento");
        return "/eventos/pruebaformulario";
    }
    @PostMapping(value = "/eventos/pruebaformulario")
    public String guardar(@Valid @DateTimeFormat(pattern = "dd-MM-yyyy") Evento evento , BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Evento");
            return "/eventos/pruebaformulario";
        }eventoService.save(evento);
        return "redirect:/eventos/listar";
    }

    @GetMapping( value ="/eventos/eliminar/{id}")
    public String eliminar (@PathVariable (value="id") Long id){
        if(id > 0) {

            eventoService.delete(id);
        }
        return "redirect:/eventos/listar";
    }
}