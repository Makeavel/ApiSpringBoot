package com.app.vendas.domain.repository;

import com.app.vendas.domain.db.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface ClientRepository extends JpaRepository<Cliente,Integer>{

    @Query(value = "select * from cliente c where c.nome like '%:nome%' " , nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query( "delete from Cliente c where c.nome like '%:nome' ")
    @Modifying   // sempre que for mexer com delete ou update tem que por o modifying
    void deleteByNome(String nome);

    @Query( "select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedido( @Param("id") Integer id);
}
