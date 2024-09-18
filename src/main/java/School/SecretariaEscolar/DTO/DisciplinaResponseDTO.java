package School.SecretariaEscolar.DTO;

import School.SecretariaEscolar.Entity.Disciplina;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaResponseDTO {
    private Long id_disciplina;
    private String nome;
    private int cargaHoraria;
    private String curso;
    private Long idProfessor;
    private Long idAluno;

    // Construtor que aceita um objeto Disciplina
    public DisciplinaResponseDTO(Disciplina disciplina) {
        this.id_disciplina = disciplina.getId_disciplina();
        this.nome = disciplina.getNome();
        this.cargaHoraria = disciplina.getCargaHoraria();
        this.curso = disciplina.getCurso();
        // Supondo que Professor e Aluno têm métodos getId() para obter os IDs
        this.idProfessor = disciplina.getProfessor().getId_prof();
        this.idAluno = disciplina.getAluno().getId_aluno();
    }
}