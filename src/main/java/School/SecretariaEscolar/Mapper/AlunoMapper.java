package School.SecretariaEscolar.Mapper;

import School.SecretariaEscolar.DTO.AlunoDTO;
import School.SecretariaEscolar.DTO.AlunoResponseDTO;
import School.SecretariaEscolar.Entity.Aluno;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlunoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Aluno toEntity(AlunoDTO dto) {
        return modelMapper.map(dto, Aluno.class);
    }

    public AlunoResponseDTO toResponseDTO(Aluno entity) {
        return modelMapper.map(entity, AlunoResponseDTO.class); // Mapeando para o ResponseDTO
    }

    public List<AlunoResponseDTO> toResponseDTO(List<Aluno> alunos) {
        return alunos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}

