package com.chokshi.deep.pos_system;

import javafx.event.ActionEvent;

import java.io.IOException;

public class HistoryController {

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();

    protected void onMainMenuButtonClick(ActionEvent event) throws IOException {
        fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
    }
}
