package School.SecretariaEscolar.Service;

import School.SecretariaEscolar.DTO.ProfessorDTO;
import School.SecretariaEscolar.DTO.ProfessorResponseDTO;
import School.SecretariaEscolar.Entity.Professor;
import School.SecretariaEscolar.Exceptions.ProfessorNotFoundException;
import School.SecretariaEscolar.Mapper.ProfessorMapper;
import School.SecretariaEscolar.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public ProfessorResponseDTO adicionarProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);
        Professor professorSalvo = professorRepository.save(professor);
        return professorMapper.toResponseDTO(professorSalvo); // Convertendo para ProfessorResponseDTO
    }

    public List<ProfessorResponseDTO> listarTodos() {
        List<Professor> professores = professorRepository.findAll();
        return professores.stream()
                .map(professorMapper::toResponseDTO) // Convertendo para uma lista de ProfessorResponseDTO
                .collect(Collectors.toList());
    }

    public ProfessorResponseDTO buscarPorId(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor não encontrado"));
        return professorMapper.toResponseDTO(professor);
    }

    public ProfessorResponseDTO atualizarProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor não encontrado"));
        professor.setNome(professorDTO.getNome());
        professor.setEmail(professorDTO.getEmail());
        return professorMapper.toResponseDTO(professorRepository.save(professor));
    }

    public void deletarProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor não encontrado"));
        professorRepository.delete(professor);
    }
}

