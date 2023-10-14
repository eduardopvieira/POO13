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
import model.BO.PecasBO;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.Pecas;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuPecasController {

	    @FXML
	    private Button botaoAutomovel;

	    @FXML
	    private ImageView botaoBuscar;

	    @FXML
	    private Button botaoCadastrarPeca;

	    @FXML
	    private Button botaoClientes;

	    @FXML
	    private Button botaoOrcamentos;

	    @FXML
	    private Button botaoSair;

	    @FXML
	    private Button botaoServicos;

	    @FXML
	    private ChoiceBox<?> choiceboxBusca;

	    @FXML
	    private TableColumn<?, ?> tableColumnDeletar;

	    @FXML
	    private TableColumn<?, ?> tableColumnEditar;

	    @FXML
	    private TextField textfieldBusca;

	    @FXML private TableView<Pecas> tableviewPecas = new TableView<Pecas>();
	    @FXML private TableColumn <Pecas, Integer>tableColumnIDPeca = new TableColumn<Pecas, Integer>("id_peca");
	    @FXML private TableColumn <Pecas, String>tableColumnNomePeca= new TableColumn<Pecas, String>("desc_peca");
	    @FXML private TableColumn <Pecas, String>tableColumnFabricantePeca = new TableColumn<Pecas, String>("fab_peca");
	    @FXML private TableColumn <Pecas, Integer>tableColumnEstoquePeca = new TableColumn<Pecas, Integer>("estoque_peca");
	    @FXML private TableColumn <Pecas, Double>tableColumnValorPeca = new TableColumn<Pecas, Double>("modelo");
	    
	    public void initialize() {
	    	
	    	tableColumnIDPeca.setCellValueFactory(new PropertyValueFactory<Pecas, Integer>("idItem"));
	    	tableColumnNomePeca.setCellValueFactory(new PropertyValueFactory<Pecas, String>("descricaoItem"));
	    	tableColumnFabricantePeca.setCellValueFactory(new PropertyValueFactory<Pecas, String>("fabricante"));
	    	tableColumnEstoquePeca.setCellValueFactory(new PropertyValueFactory<Pecas, Integer>("estoqueItem"));
	    	tableColumnValorPeca.setCellValueFactory(new PropertyValueFactory<Pecas, Double>("precoItem"));
			
	        
	    	tableviewPecas.getColumns().add(tableColumnIDPeca);
	    	tableviewPecas.getColumns().add(tableColumnNomePeca);
	    	tableviewPecas.getColumns().add(tableColumnFabricantePeca);
	    	tableviewPecas.getColumns().add(tableColumnEstoquePeca);
	    	tableviewPecas.getColumns().add(tableColumnValorPeca);
	       
	        
	        try
	        {
	            PecasBO pecaBO = new PecasBO();
	        	List<Pecas> listaPecas = pecaBO.listar();

	            while(!listaPecas.isEmpty())
	            {
	            	tableviewPecas.getItems().add(listaPecas.get(0));
	            	listaPecas.remove(0);
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }	
		}
	    

	    @FXML
	    void irTelaMenuAutos(ActionEvent event) {

	    }

	    @FXML
	    void realizarBusca(MouseEvent event) {

	}


    @FXML
    void buscarPeca(ActionEvent event)throws Exception {

    }

    @FXML
    void irParaMenuClientes(ActionEvent event)throws Exception {
    	Telas.telaMenuClientes();
    }

    @FXML
    void irParaMenuOrcamento(ActionEvent event)throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void irParaMenuServico(ActionEvent event) throws Exception {
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

    @FXML
    void irParaTelaLogin(ActionEvent event)throws Exception {
    	Telas.telaLogin();
    }

    @FXML
    void irTelaCadastrarPeca(ActionEvent event)throws Exception {
    	Telas.telaCadastrarPecas();
    }

}
