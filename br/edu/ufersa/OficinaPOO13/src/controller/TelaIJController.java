package controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.CadastradoDAO;
import model.VO.OrcIJ;
import view.Telas;

public class TelaIJController {

    @FXML
    private Button botaoCadastroFunc;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoTodosCadastrados;

    @FXML private TableView<OrcIJ> tableviewIJ = new TableView<OrcIJ>();
    @FXML private TableColumn <OrcIJ, String>tableColumnCPF = new TableColumn<OrcIJ, String>("cpf_cliente");
    @FXML private TableColumn <OrcIJ, String>tableColumnNome= new TableColumn<OrcIJ, String>("nome_cliente");
    @FXML private TableColumn <OrcIJ, Integer>tableColumnId = new TableColumn<OrcIJ, Integer>("id_orcamento");
   
    public void initialize() {
    	
    	tableviewIJ.getColumns().clear();

    	
    	tableColumnCPF.setCellValueFactory(new PropertyValueFactory<OrcIJ, String>("Cpf"));
    	tableColumnNome.setCellValueFactory(new PropertyValueFactory<OrcIJ, String>("Nome"));
    	tableColumnId.setCellValueFactory(new PropertyValueFactory<OrcIJ, Integer>("Id"));
    	
		
        
    	tableviewIJ.getColumns().add(tableColumnCPF);
    	tableviewIJ.getColumns().add(tableColumnNome);
    	tableviewIJ.getColumns().add(tableColumnId);

        
        try
        {
        	CadastradoDAO cadAO = new CadastradoDAO();
        	List<OrcIJ> listaPecas = cadAO.listarInnerJoin();

            while(!listaPecas.isEmpty())
            {
            	tableviewIJ.getItems().add(listaPecas.get(0));
            	listaPecas.remove(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}
    
    @FXML
    void irTelaCadastroFunc(ActionEvent event) throws Exception {
    	Telas.telaCadastroFunc();
    }

    @FXML
    void irTelaTodosCadastrados(ActionEvent event) throws Exception{
    	Telas.telaTodosCadastrados();
    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception{
    	Telas.telaLogin();
    }

}
