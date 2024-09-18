package School.SecretariaEscolar.Mapper;

import School.SecretariaEscolar.DTO.ProfessorDTO;
import School.SecretariaEscolar.DTO.ProfessorResponseDTO;
import School.SecretariaEscolar.Entity.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Professor toEntity(ProfessorDTO dto) {
        return modelMapper.map(dto, Professor.class);
    }

    public ProfessorResponseDTO toResponseDTO(Professor entity) {
        return modelMapper.map(entity, ProfessorResponseDTO.class); // Mapeando para o ResponseDTO
    }

    public List<ProfessorResponseDTO> toResponseDTO(List<Professor> professors) {
        return professors.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}

