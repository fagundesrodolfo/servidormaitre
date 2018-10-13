package inicio.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inicio.modelos.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>  {
//responsavel por fazer a conexão com o banco de dados
	
	
}
