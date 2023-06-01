package azkena.azkena.Controller;

import azkena.azkena.model.identity.Evento;
import azkena.azkena.model.service.IEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RelacionController {
@Autowired
    IEventoService eventoService;

    @GetMapping("/eventos/reserva_entradas/{id}")
    public String reservaEntradas(@PathVariable("id") Long id, Model model){
        Evento evento= null;
            if(id>0L)
                evento=eventoService.findOne(id);
            if(evento== null)
                return "redirect:/eventos/listar";
            else
                model.addAttribute("evento", evento);
            return "/eventos/reserva_entradas";
    }

    @PostMapping
    public String reservaEntradasPost(){

        return"/eventos/listar";
    }
}
