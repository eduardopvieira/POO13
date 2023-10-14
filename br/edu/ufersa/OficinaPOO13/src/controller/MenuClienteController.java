package controller;

import java.util.List;

import Exceptions.InfoNaoCompativelException;
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

    @FXML private TableView<Cliente> tableviewClientes = new TableView<>();
    @FXML private TableColumn<Cliente, String> tableColumnCPF = new TableColumn<>("CPF");
    @FXML private TableColumn<Cliente, String> tableColumnNome = new TableColumn<>("Nome");
    @FXML private TableColumn<Cliente, String> tableColumnEndereco = new TableColumn<>("Endereço");


   
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
    	Funcionario f = UsuarioAutenticado.getFuncAutenticado();
    	if (f == null) {
    		Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Telas.telaMenuServicoFuncionario(f);
    	}
    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception{
    	Telas.telaLogin();
    }

//=========================================================================================
    
	public void initialize() {
		ClienteBO cliBO = new ClienteBO();
    	
		tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
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
//================================= BUSCAR POR NOME OU CPF ==========================================================
    @FXML
    void realizarBusca(MouseEvent event) throws InfoNaoCompativelException {
    	Cliente cli = new Cliente();
        if (botaoBuscar.getText() != null && !botaoBuscar.getText().isEmpty())
        {
            cli.setCPF(botaoBuscar.getText());
            cli.setNome(botaoBuscar.getText());

            ClienteBO cliBO = new ClienteBO();
            List<Cliente> cliCPF = null;
            try
            {
                cliCPF = cliBO.buscarPorPK(cli);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            List<Cliente> cliNome = null;
            try
            {
                cliNome = cliBO.buscarPorNome(cli);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            try
            {
                if (!cliCPF.isEmpty())
                {
                    updateTable(cliCPF);
                }
                else
                {
                    if (!cliNome.isEmpty())
                    {
                        updateTable(cliNome);
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        else
        {
            stableTable();
        }
    }


    @FXML
    void trocarParaTelaAuto(ActionEvent event) throws Exception {
    	Telas.telaMenuAutos();
    }


}
