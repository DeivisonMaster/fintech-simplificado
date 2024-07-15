package br.com.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.picpay.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByCpfOrCnpjOrEmail(String cpf, String cnpj, String email);

}
