package com.app.vendas.domain.repository;


import com.app.vendas.domain.db.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


}
