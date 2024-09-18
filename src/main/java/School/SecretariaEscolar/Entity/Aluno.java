package School.SecretariaEscolar.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    private String nome;
    private String matricula;
    private String email;

    // Construtores, getters e setters
    public Aluno() {}

    public Aluno(Long id_aluno, String nome, String matricula, String email) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id_aluno, aluno.id_aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_aluno);
    }

}

