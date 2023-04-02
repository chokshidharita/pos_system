package com.chokshi.deep.pos_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ReportController {


    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    @FXML
    protected void onMainMenuButtonClick(ActionEvent event) throws IOException {
        fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
    }
}
