package view;

import controller.FrontController;
import model.VO.Funcionario;
import model.VO.Gerente;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


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
		telaVisualizarOrcamento();// <--TROQUE AQUI PELO MÉTODO DA TELA
		//Telas funcionando:
		//telaLogin();
		//telaMenuClientes();
		//telaCadastroCliente();
		//telaCadastrarServicoGerente();
		//telaCadastropecaFunc();
		//telaCadastroPecaGer();
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaLogin1Opcao.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuClientes(Funcionario func) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuClientes.fxml"));
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