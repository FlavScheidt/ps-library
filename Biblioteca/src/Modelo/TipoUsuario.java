package Modelo;

public enum TipoUsuario {
	PROFESSOR, ALUNO, USUARIO_GERAL;

	public static TipoUsuario fromInteger(int x) {
        switch(x) {
        case 1:
            return PROFESSOR;
        case 2:
            return ALUNO;
        case 3:
            return USUARIO_GERAL;
        }
        return null;
    }
}
