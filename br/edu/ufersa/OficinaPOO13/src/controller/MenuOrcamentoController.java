package controller;

import java.util.Date;
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
import model.BO.OrcamentoBO;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.Orcamento;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuOrcamentoController {

	@FXML
    private Button botaoAutomovel;

    @FXML
    private ImageView botaoBuscarEntreDatas;

    @FXML
    private ImageView botaoBuscarOrcamento;

    @FXML
    private Button botaoCadastrarOrcamento;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoVisualizar;
    
    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;
    
    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TextField buscarOrcamento;

    @FXML
    private TextField textfieldDataFinal;

    @FXML
    private TextField textfieldDataInicial;
    
    @FXML private TableView<Orcamento> tabelaOrcamentos = new TableView<Orcamento>();
    @FXML private TableColumn <Orcamento, String>tableColumnCliente = new TableColumn<Orcamento, String>("cpf");
    @FXML private TableColumn <Orcamento, Date>tableColumnDataOrc= new TableColumn<Orcamento, Date>("data_orc");
    @FXML private TableColumn <Orcamento, Integer>tableColumnIdOrc = new TableColumn<Orcamento, Integer>("id_orcamento");
    @FXML private TableColumn <Orcamento, Boolean>tableColumnIsPago = new TableColumn<Orcamento, Boolean>("ispago");
    @FXML private TableColumn <Orcamento, Integer>tableColumnPecaOrc = new TableColumn<Orcamento, Integer>("id_peca");
    @FXML private TableColumn <Orcamento, String>tableColumnPlacaOrc = new TableColumn<Orcamento, String>("placa");
    @FXML private TableColumn <Orcamento, Double>tableColumnPrecoOrc = new TableColumn<Orcamento, Double>("precototal");
    @FXML private TableColumn <Orcamento, Integer>tableColumnServicoOrc = new TableColumn<Orcamento, Integer>("servico_id");

    
public void initialize() {
		
    	OrcamentoBO orcBO = new OrcamentoBO();

    	
    	tableColumnCliente.setCellValueFactory(new PropertyValueFactory<Orcamento, String>("CPFClienteOrcamento"));
    	tableColumnDataOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, Date>("DataOrcamento"));
    	tableColumnIdOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, Integer>("IdOrcamento"));
    	tableColumnIsPago.setCellValueFactory(new PropertyValueFactory<Orcamento, Boolean>("IsPago"));
    	tableColumnPecaOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, Integer>("IdPecaOrcamento"));
    	tableColumnPlacaOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, String>("PlacaOrc"));
    	tableColumnPrecoOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, Double>("TotalOrcamento"));
    	tableColumnServicoOrc.setCellValueFactory(new PropertyValueFactory<Orcamento, Integer>("IdServOrc"));
        
        tabelaOrcamentos.getColumns().add(tableColumnCliente);
        tabelaOrcamentos.getColumns().add(tableColumnDataOrc);
        tabelaOrcamentos.getColumns().add(tableColumnIdOrc);
        tabelaOrcamentos.getColumns().add(tableColumnIsPago);
        tabelaOrcamentos.getColumns().add(tableColumnPecaOrc);
        tabelaOrcamentos.getColumns().add(tableColumnPlacaOrc);
        tabelaOrcamentos.getColumns().add(tableColumnPrecoOrc);
        tabelaOrcamentos.getColumns().add(tableColumnServicoOrc);
        
        

        
        try
        {
            List<Orcamento> listaOrc = orcBO.listar();

            while(!listaOrc.isEmpty())
            {
                tabelaOrcamentos.getItems().add(listaOrc.get(0));
                listaOrc.remove(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}
   //=================================================================================================================
    
    
    @FXML
    void buscarEntreDatas(MouseEvent event) {

    }
  //============================================================================================

    @FXML
    void buscarOrcamento(MouseEvent event) {

    }
  //============================================================================================
 
    @FXML
    void irTelaCadastroOrc(ActionEvent event)throws Exception{
    	Telas.telaCadastroOrcamento();
    }
  //============================================================================================
    @FXML
    void irTelaGerarRelatorio(ActionEvent event) throws Exception{

    }
  //============================================================================================

    @FXML
    void irTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }
  //============================================================================================

    @FXML
    void irTelaMenuClientes(ActionEvent event)throws Exception {
    	Telas.telaMenuClientes();
    }
  //============================================================================================

    @FXML
    void irTelaMenuPecas(ActionEvent event)throws Exception {
    	Telas.telaMenuPecas();
    }
  //============================================================================================

    @FXML
    void irTelaMenuServicos(ActionEvent event) throws Exception{
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }
    
  //============================================================================================
 @FXML
    void irTelaMenuAutomovel(ActionEvent event) throws Exception{
    	Telas.telaMenuAutos();
    }
  //============================================================================================
    
    @FXML
    void visualizarOrcamento(ActionEvent event) throws Exception {
    	try {
            Orcamento pc = tabelaOrcamentos.getSelectionModel().getSelectedItem();            
        	Telas.telaVisualizarOrcamento(pc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    	
    }
    
  //============================================================================================

    @FXML
    void deletarOrcamento(ActionEvent event) {
    	OrcamentoBO orcBO = new OrcamentoBO();

        try
        {
        	orcBO.deletar(tabelaOrcamentos.getSelectionModel().getSelectedItem());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        tabelaOrcamentos.getItems().removeAll(tabelaOrcamentos.getSelectionModel().getSelectedItem());
        stableTable();
    }
//============================================================================================
    @FXML
    void irTelaEditarOrcamento(ActionEvent event) {
    	try {
            Orcamento pc = tabelaOrcamentos.getSelectionModel().getSelectedItem();            
            Telas.telaEditarOrcamento(pc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void stableTable()
    {
    	tabelaOrcamentos.getItems().clear();
    	OrcamentoBO orcBO = new OrcamentoBO();
        try
        {
            List<Orcamento> pcList = orcBO.listar();

            while(!pcList.isEmpty())
            {
            	tabelaOrcamentos.getItems().add(pcList.get(0));
            	pcList.remove(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    public void updateTable(List<Orcamento> list)
    {
        tabelaOrcamentos.getItems().clear();
        while(!list.isEmpty())
        {
        	tabelaOrcamentos.getItems().add(list.get(0));
            list.remove(0);
        }
    }

}
