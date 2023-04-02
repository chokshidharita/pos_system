package com.chokshi.deep.pos_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;

public class HistoryController {

    @FXML
    DatePicker startDatePicker;
    @FXML
    DatePicker endDatePicker;
    @FXML
    Label errorLabel;

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    @FXML
    protected void onMainMenuButtonClick(ActionEvent event) throws IOException {
        fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
    }

    @FXML
    protected void onSearchButtonClick() {
        if (null == startDatePicker.getValue()) {
            errorLabel.setText("Select Start date");
        }
        if (null == endDatePicker.getValue()) {
            errorLabel.setText("Select End date");
        }
    }
}
