package br.com.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.picpay.model.Transacao;

@Repository
public interface TransacaoRepositorio extends JpaRepository<Transacao, Long>{

}
