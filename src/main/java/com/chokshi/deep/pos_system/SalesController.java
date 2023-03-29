package com.chokshi.deep.pos_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SalesController {

    @FXML
    TextField quantityText;

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    protected void onMainMenuButtonClick(ActionEvent event) throws IOException {
        fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
    }

    @FXML
    protected void onInputButtonClick(ActionEvent event) {
        fxmlLoaderUtil.setValueToTextField(quantityText, event);
    }

    @FXML
    protected void onClearButtonClick(ActionEvent event) {
        if (quantityText.getText().length() > 0)
            quantityText.deleteText(0, quantityText.getLength());
    }

    @FXML
    protected void onEnterButtonClick(ActionEvent event) {

    }
}
