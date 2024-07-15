package br.com.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.picpay.model.Carteira;

@Repository
public interface CarteiraRepositorio extends JpaRepository<Carteira, Long>{

}
