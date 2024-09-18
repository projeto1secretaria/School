package School.SecretariaEscolar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoDTO {

    private Long id_aluno;
    private String nome;
    private String matricula;
    private String email;
}
