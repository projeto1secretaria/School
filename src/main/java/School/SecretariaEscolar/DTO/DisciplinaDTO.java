package School.SecretariaEscolar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaDTO {

    private Long id; // ID da disciplina, se necessário para atualizações
    private String nome;
    private int cargaHoraria;
    private String curso; // Adicionei o campo curso, que estava faltando
    private Long idProfessor; // ID do professor associado
    private Long idAluno; // ID do aluno associado
}
