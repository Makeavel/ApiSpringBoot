package com.app.vendas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data               //  Getter, Setter e muito mais
@AllArgsConstructor // cria contrutor com todos argumentos
@NoArgsConstructor  // o oposto
public class PedidoDTO {  // Data Transfer Object

    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;

}
