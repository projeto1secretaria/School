package School.SecretariaEscolar.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    private String nome;
    private int cargaHoraria;
    private String curso;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    public Disciplina() {}

    public Disciplina(Long id_disciplina, String nome, int cargaHoraria, String curso, Professor professor, Aluno aluno) {
        this.id_disciplina = id_disciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.professor = professor;
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id_disciplina, that.id_disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_disciplina);
    }
}