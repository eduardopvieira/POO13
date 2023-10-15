package view;

import controller.EditarAutoController;
import controller.EditarClienteController;
import controller.EditarOrcamentoController;
import controller.EditarPecasFuncionarioController;
import controller.EditarPecasGerenteController;
import controller.EditarServicoController;
import controller.VisualizarOrcamentoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VO.Automovel;
import model.VO.Cliente;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.Orcamento;
import model.VO.Pecas;
import model.VO.Servico;


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
	
	public static void telaEditarCliente(Cliente cli) throws Exception{
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarCliente.fxml"));
		Parent root = loader.load();
		
		EditarClienteController controller = loader.getController();
		controller.Initialize(cli); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuServicoGerente(Gerente ger) throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuServicoGerente.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuAutos() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuAutos.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
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
	
	
	public static void telaEditarPecasFuncionario(Pecas pc) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarPecasFuncionario.fxml"));
		Parent root = loader.load();
		
		EditarPecasFuncionarioController controller = loader.getController();
		controller.Initialize(pc); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
		
	}
	public static void telaEditarPecasGerente(Pecas pc) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarPecasGerente.fxml"));
		Parent root = loader.load();
		
		EditarPecasGerenteController controller = loader.getController();
		controller.Initialize(pc); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaMenuOrcamentos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaMenuOrcamento.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroAuto() throws Exception {
	Parent root = FXMLLoader.load(Telas.class.getResource("PopUpCadastroAuto.fxml"));
	Scene cena = new Scene(root);		
	primaryStage.setScene(cena);
	}
	
	public static void telaEditarAuto(Automovel auto) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarAuto.fxml"));
		Parent root = loader.load();
		
		EditarAutoController controller = loader.getController();
		controller.Initialize(auto); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaEditarServico(Servico serv) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarServico.fxml"));
		Parent root = loader.load();
		
		EditarServicoController controller = loader.getController();
		controller.Initialize(serv); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaCadastroOrcamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telaCadastrarOrcamento.fxml"));
		Scene cena = new Scene(root);		
		primaryStage.setScene(cena);
	}
	
	
	
	public static void telaVisualizarOrcamento(Orcamento orc) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaVisualizarOrcamento.fxml"));
		Parent root = loader.load();
		
		VisualizarOrcamentoController controller = loader.getController();
		controller.Initialize(orc); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaEditarOrcamento(Orcamento orc) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("telaEditarOrcamento.fxml"));
		Parent root = loader.load();
		
		EditarOrcamentoController controller = loader.getController();
		controller.Initialize(orc); 
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void main(String ... args) {
		launch();
	}

}