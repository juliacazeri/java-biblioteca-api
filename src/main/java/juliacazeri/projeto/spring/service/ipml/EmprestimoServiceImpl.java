package juliacazeri.projeto.spring.service.ipml;

import juliacazeri.projeto.spring.dto.EmprestimoDTO;
import juliacazeri.projeto.spring.exception.ResourceNotFoundException;
import juliacazeri.projeto.spring.model.Emprestimo;
import juliacazeri.projeto.spring.model.Livro;
import juliacazeri.projeto.spring.model.Usuario;
import juliacazeri.projeto.spring.repository.EmprestimoRepository;
import juliacazeri.projeto.spring.repository.LivroRepository;
import juliacazeri.projeto.spring.repository.UsuarioRepository;
import juliacazeri.projeto.spring.service.EmprestimoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoServiceImpl implements EmprestimoService{

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository,
                                 LivroRepository livroRepository,
                                 UsuarioRepository usuarioRepository){
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private EmprestimoDTO toDTO(Emprestimo emp){
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emp.getId());
        dto.setIdLivro(emp.getLivro() != null ? emp.getLivro().getId() : null);
        dto.setIdUsuario(emp.getUsuario() != null ? emp.getUsuario().getId() : null);
        dto.setDataEmprestimo(emp.getDataEmprestimo());
        dto.setDataDevolucaoPrevista(emp.getDataDevolucaoPrevista());
        dto.setDataDevolucaoReal(emp.getDataDevolucaoReal());
        return dto;
    }

    @Override
    public List<EmprestimoDTO> listarTodos(){
        return emprestimoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmprestimoDTO buscarPorId(Long id){
        Emprestimo emp = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O empréstimo não foi encontrado!"));
        return toDTO(emp);
    }

    @Override
    public EmprestimoDTO criar(EmprestimoDTO dto){
        Livro livro = livroRepository.findById(dto.getIdLivro())
                .orElseThrow(() -> new ResourceNotFoundException("O livro não foi encontrado!"));
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("O usuário não encontrado!"));

        if(livro.getQuantidadeEstoque() == null || livro.getQuantidadeEstoque() <= 0){
            throw new IllegalArgumentException("O livro informado está sem estoque disponível.");
        }

        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
        livroRepository.save(livro);

        LocalDate hoje = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(hoje);
        emprestimo.setDataDevolucaoPrevista(hoje.plusDays(7));
        emprestimo.setDataDevolucaoReal(null);

        emprestimo = emprestimoRepository.save(emprestimo);
        return toDTO(emprestimo);
    }

    @Override
    public EmprestimoDTO devolver(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O empréstimo não foi encontrado!"));

        if(emprestimo.getDataDevolucaoReal() != null){
            throw new IllegalArgumentException("O empréstimo já foi devolvido!");
        }

        emprestimo.setDataDevolucaoReal(LocalDate.now());
        Livro livro = emprestimo.getLivro();
        if (livro != null) {
            livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + 1);
            livroRepository.save(livro);
        }

        emprestimo = emprestimoRepository.save(emprestimo);
        return toDTO(emprestimo);
    }

    @Override
    public void deletar(Long id){
        Emprestimo emp = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O empréstimo não foi encontrado!"));
        emprestimoRepository.delete(emp);
    }

    @Override
    public List<EmprestimoDTO> listarAtivosPorUsuario(Long usuarioId){
        return emprestimoRepository.findByUsuarioIdAndDataDevolucaoRealIsNull(usuarioId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmprestimoDTO> listarAtrasados(){
        LocalDate hoje = LocalDate.now();
        return emprestimoRepository.findByDataDevolucaoPrevistaBeforeAndDataDevolucaoRealIsNull(hoje)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}