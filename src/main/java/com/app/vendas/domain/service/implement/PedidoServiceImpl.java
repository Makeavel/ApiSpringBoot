package com.app.vendas.domain.service.implement;

import com.app.vendas.domain.repository.PedidoRepository;
import com.app.vendas.domain.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


}
