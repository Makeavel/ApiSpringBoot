package com.app.vendas.domain.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data               //  Getter, Setter e muito mais
@AllArgsConstructor // cria contrutor com todos argumentos
@NoArgsConstructor  // o oposto
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 20 , precision = 2)
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente" , fetch = FetchType.LAZY) // um cliente para muitos pedidos| fetch é trazer junto na consulta
    private Set<Pedido> pedidos;


    public Cliente(String nome , String cargo){
        this.nome = nome;
        this.cargo = cargo;
    }

}
