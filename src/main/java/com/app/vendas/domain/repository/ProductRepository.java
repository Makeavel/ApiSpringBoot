package com.app.vendas.domain.repository;

import com.app.vendas.domain.db.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produto, Integer> {

    /*
    @Query(value = "select * from produto c where c.descricao like '%:descricao%' " , nativeQuery = true)
    List<Produto> encontrarPorNome(@Param("nome") String nome);

    @Query( "delete from Cliente c where c.nome like '%:nome' ")
    @Modifying
        // sempre que for mexer com delete ou update tem que por o modifying
    void deleteByNome(String descricao);

    @Query( "select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Produto findClienteFetchPedido( @Param("id") Integer id);


     */
}
