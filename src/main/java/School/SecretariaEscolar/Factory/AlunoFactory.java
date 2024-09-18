package School.SecretariaEscolar.Factory;

import School.SecretariaEscolar.Entity.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoFactory implements EntityFactory<Aluno> {
    @Override
    public Aluno create() {
        return new Aluno();
    }
}