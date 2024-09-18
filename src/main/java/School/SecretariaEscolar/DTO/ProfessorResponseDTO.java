package School.SecretariaEscolar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfessorResponseDTO {
    private Long id;
    private String nome;
    private String email;
}

