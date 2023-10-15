package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import view.Telas;
import view.util.Alerts;

public class VisualizarOrcamentoController {

    @FXML
    private Button botaoConcluir;

    @FXML
    private Button botaoPagar;

    @FXML
    private Label dataOrc;

    @FXML
    private Label nomeCliente;

    @FXML
    private TableColumn<?, ?> nomePecasOrc;

    @FXML
    private TableColumn<?, ?> nomeServicoOrc;

    @FXML
    private Label orcamentoEstaPago;

    @FXML
    private Label placaAutoOrc;

    @FXML
    private TableColumn<?, ?> precoPecaOrc;

    @FXML
    private TableColumn<?, ?> precoServicoOrc;

    @FXML
    private Label precoTotalOrc;

    @FXML
    void irParaTelaMenuOrcamento(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void pagarOrcamento(ActionEvent event) {
    	Alerts.showAlert("Sucesso!", "Pagamento Concluído", "O orçamento foi pago com sucesso", AlertType.INFORMATION);
        botaoPagar.setManaged(false);
        botaoPagar.setVisible(false);
        orcamentoEstaPago.setManaged(true);
        orcamentoEstaPago.setVisible(true);
        
    }

}
