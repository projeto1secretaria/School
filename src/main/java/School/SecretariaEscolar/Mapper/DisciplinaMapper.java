package School.SecretariaEscolar.Mapper;

import School.SecretariaEscolar.DTO.DisciplinaDTO;
import School.SecretariaEscolar.DTO.DisciplinaResponseDTO;
import School.SecretariaEscolar.Entity.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisciplinaMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Disciplina toEntity(DisciplinaDTO dto) {
        return modelMapper.map(dto, Disciplina.class);
    }

    public DisciplinaResponseDTO toResponseDTO(Disciplina entity) {
        return modelMapper.map(entity, DisciplinaResponseDTO.class); // Mapeando para o ResponseDTO
    }

    public List<DisciplinaResponseDTO> toResponseDTO(List<Disciplina> disciplinas) {
        return disciplinas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}


