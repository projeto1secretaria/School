package School.SecretariaEscolar.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prof;

    private String nome;
    private String cpf;
    private String email;

    // Construtores, getters e setters
    public Professor() {}

    public Professor(Long id_prof, String nome, String cpf, String email) {
        this.id_prof = id_prof;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id_prof, professor.id_prof);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_prof);
    }

}

