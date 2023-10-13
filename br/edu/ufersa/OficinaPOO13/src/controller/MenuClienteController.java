package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ClienteBO;
import model.VO.Automovel;
import model.VO.Cliente;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuClienteController implements Initializable {

	
    private ClienteBO cliBO = new ClienteBO();
    public static ArrayList<Cliente> listaClientes;
    static ObservableList<Cliente> clientesCadastrados;
    
	@FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TableColumn<?,?> tableColumnAuto;

    @FXML
    private TableColumn<Cliente, String> tableColumnCPF;

    @FXML
    private TableColumn<Cliente, String> tableColumnCliente;

    @FXML
    private TableColumn<Cliente, Button> tableColumnDeletar;

    @FXML
    private TableColumn<Cliente, Button> tableColumnEditar;

    @FXML
    private TableColumn<?,?> tableColumnPlaca;
    
    @FXML
    private TableView<?> tableviewAutomoveis;

    @FXML
    private TableView<Cliente> tableviewClientes;

    @FXML
    private TableView<?> tableviewGenerica;
    
    @FXML
    void abrirCadastroCliente(ActionEvent event) throws Exception {
    	Telas.telaCadastroCliente();
    }

    @FXML
    void buscarCliente(ActionEvent event)throws Exception {
    	
    }

    @FXML
    void trocarParaMenuOrcamentos(ActionEvent event)throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void trocarParaMenuPecas(ActionEvent event) throws Exception{
    	Telas.telaMenuPecas();
    }

    @FXML
    void trocarParaMenuServicos(ActionEvent event) throws Exception{
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception{
    	Telas.telaLogin();
    }
    
    private void carregarDados() {
    	 tableColumnCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
         tableColumnCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
         tableviewClientes.setItems(clientesCadastrados);
    }
	
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
			listaClientes = this.cliBO.listar();
		} catch (InsertException e) {
		
			e.printStackTrace();
		}
        clientesCadastrados = FXCollections.observableArrayList(listaClientes);
        carregarDados();
		
	}

}
