package br.com.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.picpay.model.Carteira;

@Repository
public interface CarteiraRepositorio extends JpaRepository<Carteira, Long>{

	@Query("select c from Carteira c where c.usuario.id = :pId")
	Optional<Carteira> buscaCarteiraPorIdUsuario(@Param("pId") Long id);

}
