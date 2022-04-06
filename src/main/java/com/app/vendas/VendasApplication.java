package com.app.vendas;


import com.app.vendas.domain.db.Cliente;
import com.app.vendas.domain.db.Pedido;
import com.app.vendas.domain.repository.ClientRepository;
import com.app.vendas.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootApplication
public class VendasApplication {


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


    @Bean
    public CommandLineRunner init(
            @Autowired ClientRepository clientes,
            @Autowired PedidoRepository pedidos){
        return args -> {
            Cliente cliente = new Cliente();

            clientes.save(new Cliente("Laura" , "Presidente"));
            clientes.save(new Cliente("Maytê","Admin"));

            cliente.setNome("Paulo");
            clientes.save(cliente);


            clientes.save(new Cliente("Joana","Usuária"));
            //clientes.save( new Cliente( 3 ,"Ananda","Admin" ) );
            clientes.save(new Cliente("Helena","Gestora"));

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(BigDecimal.valueOf(100));

            pedidos.save(pedido);

            clientes.deleteById( 4 );


        };
    }

}
