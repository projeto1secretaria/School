package School.SecretariaEscolar.Singleton;

import School.SecretariaEscolar.Entity.Aluno;

public class AlunoServiceSingleton {
    private static AlunoServiceSingleton instance;

    private AlunoServiceSingleton() {}

    public static synchronized AlunoServiceSingleton getInstance() {
        if (instance == null) {
            instance = new AlunoServiceSingleton();
        }
        return instance;
    }

    public Aluno adicionarAluno(Aluno aluno) {
        // Lógica de adicionar aluno
        return aluno;
    }
}
