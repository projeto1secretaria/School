package School.SecretariaEscolar.Repository;

import School.SecretariaEscolar.Entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Query("SELECT d FROM Disciplina d WHERE d.aluno.id = :alunoId AND d.professor.id = :professorId")
    Disciplina findDisciplinaByAlunoIdAndProfessorId(@Param("alunoId") Long alunoId, @Param("professorId") Long professorId);

}

