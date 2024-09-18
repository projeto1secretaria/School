package School.SecretariaEscolar.Service;

import School.SecretariaEscolar.DTO.DisciplinaDTO;
import School.SecretariaEscolar.DTO.DisciplinaResponseDTO;
import School.SecretariaEscolar.Entity.Aluno;
import School.SecretariaEscolar.Entity.Disciplina;
import School.SecretariaEscolar.Entity.Professor;
import School.SecretariaEscolar.Exceptions.DisciplinaNotFoundException;
import School.SecretariaEscolar.Mapper.DisciplinaMapper;
import School.SecretariaEscolar.Repository.AlunoRepository;
import School.SecretariaEscolar.Repository.DisciplinaRepository;
import School.SecretariaEscolar.Repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    // Método para adicionar disciplina recebendo Disciplina e IDs de aluno e professor
    public Disciplina adicionarDisciplina(Disciplina disciplina, Long alunoId, Long professorId) {

        // Buscar o aluno e o professor pelos seus IDs
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        // Atribuir o aluno e o professor à disciplina
        disciplina.setAluno(aluno);
        disciplina.setProfessor(professor);

        // Salvar a disciplina no repositório
        return disciplinaRepository.save(disciplina);
    }

    // Método renomeado para evitar conflito, agora responsável por adicionar disciplina usando DTO
    @Transactional
    public DisciplinaResponseDTO adicionarDisciplinaComDTO(DisciplinaDTO disciplinaDTO, Long alunoId, Long professorId) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);

        // Atribuir o aluno e o professor à disciplina
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        disciplina.setAluno(aluno);
        disciplina.setProfessor(professor);

        // Salvar a disciplina
        Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
        return disciplinaMapper.toResponseDTO(disciplinaSalva);
    }

    // Listar todas as disciplinas
    public List<DisciplinaResponseDTO> listarTodas() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        return disciplinas.stream()
                .map(disciplinaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Buscar disciplina por ID
    public DisciplinaResponseDTO buscarPorId(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina não encontrada"));
        return disciplinaMapper.toResponseDTO(disciplina);
    }

    // Atualizar disciplina
    @Transactional
    public DisciplinaResponseDTO atualizarDisciplina(Long id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina não encontrada"));
        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setCargaHoraria(disciplinaDTO.getCargaHoraria());

        // Atualizar professor e aluno se necessário (opcional)
        // Aqui poderíamos adicionar lógica para atualizar o aluno e professor, se necessário

        return disciplinaMapper.toResponseDTO(disciplinaRepository.save(disciplina));
    }

    // Deletar disciplina
    @Transactional
    public void deletarDisciplina(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina não encontrada"));
        disciplinaRepository.delete(disciplina);
    }

    // Buscar disciplina por alunoId e professorId
    public DisciplinaResponseDTO buscarPorAlunoIdEProfessorId(Long alunoId, Long professorId) {
        Disciplina disciplina = disciplinaRepository.findDisciplinaByAlunoIdAndProfessorId(alunoId, professorId);
        return disciplina != null ? disciplinaMapper.toResponseDTO(disciplina) : null;
    }
}
