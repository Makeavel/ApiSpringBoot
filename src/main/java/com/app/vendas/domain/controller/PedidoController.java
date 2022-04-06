package com.app.vendas.domain.controller;

import com.app.vendas.domain.repository.PedidoRepository;
import com.app.vendas.domain.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private PedidoService service;
    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

}
