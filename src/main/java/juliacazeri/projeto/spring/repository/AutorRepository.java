package juliacazeri.projeto.spring.repository;

import juliacazeri.projeto.spring.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}