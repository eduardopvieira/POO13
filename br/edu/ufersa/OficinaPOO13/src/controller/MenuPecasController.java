package controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TextField textfieldBusca;


	    @FXML private TableView<Pecas> tableviewPecas = new TableView<Pecas>();
	    @FXML private TableColumn <Pecas, Integer>tableColumnIDPeca = new TableColumn<Pecas, Integer>("id_peca");
	    @FXML private TableColumn <Pecas, String>tableColumnNomePeca= new TableColumn<Pecas, String>("desc_peca");
	    @FXML private TableColumn <Pecas, String>tableColumnFabricantePeca = new TableColumn<Pecas, String>("fab_peca");
	    @FXML private TableColumn <Pecas, Integer>tableColumnEstoquePeca = new TableColumn<Pecas, Integer>("estoque_peca");
	    @FXML private TableColumn <Pecas, Double>tableColumnValorPeca = new TableColumn<Pecas, Double>("modelo");
	    
	    public void initialize() {
	    	
	        tableviewPecas.getColumns().clear();

	    	
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
	    void irTelaMenuAutos(ActionEvent event)throws Exception {
	    	Telas.telaMenuAutos();
	    }

	@FXML
	void realizarBusca(MouseEvent event) {
		Pecas pc = new Pecas();
        if (textfieldBusca.getText() != null && !textfieldBusca.getText().isEmpty())
        {
        	pc.setDescricaoItem(textfieldBusca.getText());

            PecasBO pcBO = new PecasBO();
            List<Pecas> pcFab = null;
            try
            {
                pcFab = pcBO.buscarPorNomeOuFab(pc);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
                if (!pcFab.isEmpty())
                {
                    updateTable(pcFab);
                }
        }
        else
        {
            stableTable();
        }
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

    public void updateTable(List<Pecas> list)
    {
        tableviewPecas.getItems().clear();
        while(!list.isEmpty())
        {
        	tableviewPecas.getItems().add(list.get(0));
            list.remove(0);
        }
    }
    
    @FXML
    void deletarLinha(ActionEvent event) {
    	{
            PecasBO pcBO = new PecasBO();

            try
            {
            	pcBO.deletar(tableviewPecas.getSelectionModel().getSelectedItem());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            tableviewPecas.getItems().removeAll(tableviewPecas.getSelectionModel().getSelectedItem());
            stableTable();
        }
    }
    
    
    @FXML
    void irTelaEditarPeca(ActionEvent event) {
    	
    	try {
            Pecas pc = tableviewPecas.getSelectionModel().getSelectedItem();

        if (UsuarioAutenticado.getGerenteAutenticado() != null) {
            Telas.telaEditarPecasGerente(pc);
        } else {
        	Telas.telaEditarPecasFuncionario(pc);
        }
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void stableTable()
    {
    	tableviewPecas.getItems().clear();
    	PecasBO pcBO = new PecasBO();
        try
        {
            List<Pecas> pcList = pcBO.listar();

            while(!pcList.isEmpty())
            {
            	tableviewPecas.getItems().add(pcList.get(0));
            	pcList.remove(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
