package School.SecretariaEscolar.Service;

import School.SecretariaEscolar.DTO.AlunoDTO;
import School.SecretariaEscolar.DTO.AlunoResponseDTO;
import School.SecretariaEscolar.Entity.Aluno;
import School.SecretariaEscolar.Exceptions.AlunoNotFoundException;
import School.SecretariaEscolar.Mapper.AlunoMapper;
import School.SecretariaEscolar.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  // faz o crud
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoResponseDTO adicionarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return alunoMapper.toResponseDTO(alunoSalvo); // Convertendo para AlunoResponseDTO
    }

    public List<AlunoResponseDTO> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(alunoMapper::toResponseDTO) // Convertendo para uma lista de AlunoResponseDTO
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));
        return alunoMapper.toResponseDTO(aluno);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));
        aluno.setNome(alunoDTO.getNome());
        aluno.setMatricula(alunoDTO.getMatricula());
        return alunoMapper.toResponseDTO(alunoRepository.save(aluno));
    }

    public void deletarAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));
        alunoRepository.delete(aluno);
    }
}


