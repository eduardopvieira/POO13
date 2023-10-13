package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VO.Funcionario;
import model.VO.Gerente;


public class Telas extends Application{
	private static Stage primaryStage;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Oficina do Zezé");
		primaryStage.show();
		//telaMenuOrcamento();
		telaLogin();
		
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuClientes() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuClientes.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastroCliente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void popUpCadastroAutomovel() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("PopUpCadastroAuto.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	public static void telaMenuServicoFuncionario(Funcionario func) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuServicoFuncionario.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuServicoGerente(Gerente ger) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuServicoGerente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	/*public static void telaVisualizarServicoFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastroCliente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}*/
	
	
	public static void telaCadastrarServicoGerente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastrarServicoGerente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuPecas() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuPecas.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}	
	
	public static void telaCadastrarPecas() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastrarPecas.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	
	public static void telaEditarPecasFuncionario(Funcionario func) throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaEditarPecasFuncionario.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	public static void telaEditarPecasGerente(Gerente ger) throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaEditarPecasGerente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuOrcamentos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuOrcamento.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	/*public static void telaCadastroOrcamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastroCliente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}*/
	
	
	
	public static void telaVisualizarOrcamento() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaVisualizarOrcamento.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void main(String ... args) {
		launch();
	}

}