package com.chokshi.deep.pos_system;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class LoginController {

    @FXML
    PasswordField pinInput;

    @FXML
    Label errorLabel;

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        int password = Integer.parseInt(pinInput.getText());
        //TODO: to be removed once database is integrated
        System.out.println("Password: " + password);
        if (password == 1234)
            fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
        else {
            onClearButtonClick();
            errorLabel.setText("Invalid pin");
        }
    }

    @FXML
    protected void onInputButtonClick(ActionEvent event) {
        if (errorLabel.getText().isBlank())
            errorLabel.setText(" ");

        fxmlLoaderUtil.setValueToTextField(pinInput, event);
    }

    @FXML
    protected void onClearButtonClick() {
        //TODO: sales controller
        if (pinInput.getLength() > 0)
            pinInput.deleteText(0, pinInput.getLength());
    }

    @FXML
    protected void onShutdownButtonClick() {
        Platform.exit();
    }
}

