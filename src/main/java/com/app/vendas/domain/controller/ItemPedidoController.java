package com.app.vendas.domain.controller;

import com.app.vendas.domain.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


}
