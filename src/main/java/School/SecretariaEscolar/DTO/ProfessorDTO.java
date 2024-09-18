package School.SecretariaEscolar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfessorDTO {

    private Long id_prof;
    private String nome;
    private String cpf;
    private String email;
}
