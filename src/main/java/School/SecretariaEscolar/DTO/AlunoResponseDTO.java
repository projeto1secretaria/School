package School.SecretariaEscolar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String matricula;
}
