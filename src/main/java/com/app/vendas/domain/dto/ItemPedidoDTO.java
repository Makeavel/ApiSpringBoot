package com.app.vendas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //  Getter, Setter e muito mais
@AllArgsConstructor // cria contrutor com todos argumentos
@NoArgsConstructor  // o oposto
public class ItemPedidoDTO {  // Data Transfer Object

    private String Produto;
    private Integer quantidade;
}
