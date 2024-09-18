package School.SecretariaEscolar.Factory;

import School.SecretariaEscolar.Entity.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorFactory implements EntityFactory<Professor> {
    @Override
    public Professor create() {
        return new Professor();
    }
}