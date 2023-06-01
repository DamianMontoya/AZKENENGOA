package azkena.azkena.model.identity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="relacion")
public class Relacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="evento_id")
    private Evento evento;
    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    @Size(min = 1,max = 5)
    private Integer entradasReservadas;


}
