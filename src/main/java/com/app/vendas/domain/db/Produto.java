package com.app.vendas.domain.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor // cria contrutor com todos argumentos
@NoArgsConstructor  // o oposto
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "descricao" , length = 100)
    private String descricao;

    @Column(name = "preco_unitario" )
    private BigDecimal preco;


}
