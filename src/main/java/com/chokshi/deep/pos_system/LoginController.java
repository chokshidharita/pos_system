package com.chokshi.deep.pos_system;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    PasswordField pinInput;

    @FXML
    Label errorLabel;

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        int password = Integer.parseInt(pinInput.getText());

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_info where user_pin=" + password);

            if (rs.next()) {
                fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
            } else {
                onClearButtonClick();
                errorLabel.setText("Invalid pin");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
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
        if (pinInput.getLength() > 0)
            pinInput.deleteText(0, pinInput.getLength());
    }

    @FXML
    protected void onShutdownButtonClick() {
        Platform.exit();
    }
}

