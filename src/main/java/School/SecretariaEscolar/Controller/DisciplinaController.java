package School.SecretariaEscolar.Controller;

import School.SecretariaEscolar.DTO.DisciplinaDTO;
import School.SecretariaEscolar.DTO.DisciplinaResponseDTO;
import School.SecretariaEscolar.Entity.Aluno;
import School.SecretariaEscolar.Entity.Disciplina;
import School.SecretariaEscolar.Entity.Professor;
import School.SecretariaEscolar.Repository.AlunoRepository;
import School.SecretariaEscolar.Repository.DisciplinaRepository;
import School.SecretariaEscolar.Repository.ProfessorRepository;
import School.SecretariaEscolar.Service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/alunos/{alunoId}/professores/{professorId}")
    public ResponseEntity<Disciplina> createDisciplina(
            @PathVariable Long alunoId,
            @PathVariable Long professorId,
            @RequestBody Disciplina disciplina) {

        // Atribuir alunoId e professorId à disciplina antes de salvá-la
        Disciplina novaDisciplina = disciplinaService.adicionarDisciplina(disciplina, alunoId, professorId);

        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listarTodas() {
        // Obtém a lista de todas as disciplinas
        List<DisciplinaResponseDTO> disciplinas = disciplinaService.listarTodas();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarPorId(@PathVariable Long id) {
        // Obtém a disciplina pelo ID
        DisciplinaResponseDTO disciplina = disciplinaService.buscarPorId(id);
        return ResponseEntity.ok(disciplina);
    }

    @GetMapping("/alunos/{alunoId}/professores/{professorId}")
    public ResponseEntity<DisciplinaResponseDTO> getDisciplina(@PathVariable Long alunoId, @PathVariable Long professorId) {
        // Lógica para buscar a disciplina
        DisciplinaResponseDTO disciplina = disciplinaService.buscarPorAlunoIdEProfessorId(alunoId, professorId);
        if (disciplina != null) {
            return ResponseEntity.ok(disciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> atualizarDisciplina(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO) {
        // Atualiza a disciplina existente
        DisciplinaResponseDTO disciplinaAtualizada = disciplinaService.atualizarDisciplina(id, disciplinaDTO);
        return ResponseEntity.ok(disciplinaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable Long id) {
        // Deleta a disciplina pelo ID
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    }
}
