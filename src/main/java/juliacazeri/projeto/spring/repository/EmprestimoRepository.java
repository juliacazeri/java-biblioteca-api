package juliacazeri.projeto.spring.repository;

import juliacazeri.projeto.spring.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    List<Emprestimo> findByUsuarioIdAndDataDevolucaoRealIsNull(Long usuarioId);
    List<Emprestimo> findByDataDevolucaoPrevistaBeforeAndDataDevolucaoRealIsNull(LocalDate data);
}