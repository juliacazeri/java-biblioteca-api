package juliacazeri.projeto.spring.repository;

import juliacazeri.projeto.spring.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

}