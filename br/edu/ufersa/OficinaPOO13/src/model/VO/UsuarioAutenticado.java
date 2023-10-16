package model.VO;

public class UsuarioAutenticado {
    
	private static Gerente gerenteAutenticado;
    private static Funcionario funcAutenticado;
    private static String funcao;
    
    public static Funcionario getFuncAutenticado() {
        return funcAutenticado;
    }

    public static void setFuncAutenticado(Funcionario func) {
        funcAutenticado = func;
        funcao = "funcionario";
    }
    
    public static Gerente getGerenteAutenticado() {
    	return gerenteAutenticado;
    }
    
    public static void setGerenteAutenticado(Gerente ger) {
    	gerenteAutenticado = ger;
    	funcao = "gerente";
    }
    
    public static void setFuncao(String f) {
    	funcao = f;
    }
    
    public static String getFuncao() {return funcao;}
    
 }