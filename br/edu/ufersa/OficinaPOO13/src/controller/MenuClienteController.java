package controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.BO.ClienteBO;
import model.VO.Cliente;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuClienteController {

    @FXML
    private Button botaoAutomovel;

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private ImageView botaoParaBuscar;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private ChoiceBox<String> choiceboxBusca;

    @FXML private TableView<Cliente> tableviewClientes = new TableView<Cliente>();
    @FXML private TableColumn <Cliente, String>tableColumnCPF = new TableColumn<Cliente, String>("cpf_cliente");
    @FXML private TableColumn <Cliente, String>tableColumnNome = new TableColumn<Cliente, String>("nome_cliente");
    @FXML private TableColumn <Cliente, String>tableColumnEndereco  = new TableColumn<Cliente, String>("endereco_cliente");

   
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

//=========================================================================================
    
	public void initialize() {
		ClienteBO cliBO = new ClienteBO();
    	
    	tableColumnCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        
        tableviewClientes.getColumns().add(tableColumnCPF);
        tableviewClientes.getColumns().add(tableColumnNome);
        tableviewClientes.getColumns().add(tableColumnEndereco);
        
        try
        {
            List<Cliente> listaClientes = cliBO.listar();

            while(!listaClientes.isEmpty())
            {
                tableviewClientes.getItems().add(listaClientes.get(0));
                listaClientes.remove(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}
//=========================================================================================
	
    public void updateTable(List<Cliente> list)
    {
        tableviewClientes.getItems().clear();
        while(!list.isEmpty())
        {
        	tableviewClientes.getItems().add(list.get(0));
            list.remove(0);
        }
    }

    
    public void stableTable()
    {
    	tableviewClientes.getItems().clear();
    	ClienteBO cliBO = new ClienteBO();
        try
        {
            List<Cliente> cliList = cliBO.listar();

            while(!cliList.isEmpty())
            {
            	tableviewClientes.getItems().add(cliList.get(0));
            	cliList.remove(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    

    @FXML
    void deletar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void realizarBusca(MouseEvent event) {

    }


    @FXML
    void trocarParaTelaAuto(ActionEvent event) {

    }


}
