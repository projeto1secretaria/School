package School.SecretariaEscolar.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Disciplina_PK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Disciplina_PK() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina_PK that = (Disciplina_PK) o;
        return Objects.equals(professor, that.professor) && Objects.equals(aluno, that.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor, aluno);
    }
}