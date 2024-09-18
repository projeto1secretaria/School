package School.SecretariaEscolar.Singleton;

import School.SecretariaEscolar.Entity.Professor;

public class ProfessorServiceSingleton {
    private static ProfessorServiceSingleton instance;

    private ProfessorServiceSingleton() {}

    public static synchronized ProfessorServiceSingleton getInstance() {
        if (instance == null) {
            instance = new ProfessorServiceSingleton();
        }
        return instance;
    }

    public Professor adicionarProfessor(Professor professor) {
        // Lógica de adicionar professor
        return professor;
    }
}
