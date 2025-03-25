package br.com.contato.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "coontato")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Integer id;

    @Column(name = "contato_nome", length = 100)
    private String nome;

    @Column(name = "contato_email") @Email
    private String email;

    @Column(name = "contato_celular", length = 11)
    private String celular;

    @Column(name = "contato_telefone", length = 10)
    private String telefone;

    @Column(name = "contato_sn_favorito", length = 1)
    private Character favorito;

    @Column(name = "contato_sn_ativo", length = 1)
    private Character ativo;

    @Column(name = "contato_dh_cad")
    @CreationTimestamp
    private LocalDateTime cadastro;
}
