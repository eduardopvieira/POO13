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
		//telaVisualizarOrcamento();// <--TROQUE AQUI PELO MÉTODO DA TELA
		//Telas funcionando:
		telaLogin();
		//telaMenuClientes();
		//telaCadastroCliente();
		//telaCadastrarServicoGerente();
		//telaCadastropecaFunc();
		//telaCadastroPecaGer();
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuClientesFuncionario(Funcionario func) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuClientesFuncionario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuClientesGerente(Gerente gerente) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuClientesGerente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastroCliente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastrarServicoGerente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastrarServicoGerente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	public static void telaCadastroPecaFunc() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("cadastroPecaFunc.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	public static void telaCadastroPecaGer() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("cadastroPecaGer.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	public static void telaVisualizarOrcamento() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaVisualizarOrcamento.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void main(String ... args) {
		launch();
	}

}