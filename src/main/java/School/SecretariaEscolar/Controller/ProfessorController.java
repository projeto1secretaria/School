package School.SecretariaEscolar.Controller;

import School.SecretariaEscolar.DTO.ProfessorDTO;
import School.SecretariaEscolar.DTO.ProfessorResponseDTO;
import School.SecretariaEscolar.Entity.Professor;
import School.SecretariaEscolar.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setCpf(professorDTO.getCpf());
        professor.setEmail(professorDTO.getEmail());

        Professor savedProfessor = professorService.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessor);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> listarTodos() {
        List<ProfessorResponseDTO> professores = professorService.listarTodos();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> buscarPorId(@PathVariable Long id) {
        ProfessorResponseDTO professor = professorService.buscarPorId(id);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessorDTO professorDTO) {
        ProfessorResponseDTO professorAtualizado = professorService.atualizarProfessor(id, professorDTO);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}

