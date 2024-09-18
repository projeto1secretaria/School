package School.SecretariaEscolar.Controller;

import School.SecretariaEscolar.DTO.AlunoDTO;
import School.SecretariaEscolar.DTO.AlunoResponseDTO;
import School.SecretariaEscolar.Entity.Aluno;
import School.SecretariaEscolar.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping // chama o crud
    public ResponseEntity<Aluno> createAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setEmail(alunoDTO.getEmail());

        Aluno savedAluno = alunoService.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarTodos() {
        List<AlunoResponseDTO> alunos = alunoService.listarTodos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarPorId(@PathVariable Long id) {
        AlunoResponseDTO aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoResponseDTO alunoAtualizado = alunoService.atualizarAluno(id, alunoDTO);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}

