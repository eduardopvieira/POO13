package model.VO;

public class UsuarioAutenticado {
    
	private static Gerente gerenteAutenticado;
    private static Funcionario funcAutenticado;
    
    public static Funcionario getFuncAutenticado() {
        return funcAutenticado;
    }

    public static void setFuncAutenticado(Funcionario func) {
        funcAutenticado = func;
    }
    
    public static Gerente getGerenteAutenticado() {
    	return gerenteAutenticado;
    }
    
    public static void setGerenteAutenticado(Gerente ger) {
    	gerenteAutenticado = ger;
    }
 }