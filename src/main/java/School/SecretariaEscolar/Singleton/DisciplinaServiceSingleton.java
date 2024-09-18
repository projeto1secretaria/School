package School.SecretariaEscolar.Singleton;

import School.SecretariaEscolar.Entity.Disciplina;

public class DisciplinaServiceSingleton {
    private static DisciplinaServiceSingleton instance;

    private DisciplinaServiceSingleton() {}

    public static synchronized DisciplinaServiceSingleton getInstance() {
        if (instance == null) {
            instance = new DisciplinaServiceSingleton();
        }
        return instance;
    }

    public Disciplina adicionarDisciplina(Disciplina disciplina) {
        // Lógica de adicionar disciplina
        return disciplina;
    }
}
