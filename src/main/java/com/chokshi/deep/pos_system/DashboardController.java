package com.chokshi.deep.pos_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class DashboardController {

    FxmlLoaderUtil FXMLLoaderUtil = FxmlLoaderUtil.getInstance();

    @FXML
    protected void onSalesButtonClick(ActionEvent event) throws IOException {
        FXMLLoaderUtil.loadFXML(event, "sales-view.fxml");
    }

    @FXML
    protected void onReportButtonClick(ActionEvent event) throws IOException {
        FXMLLoaderUtil.loadFXML(event, "report-view.fxml");
    }

    @FXML
    protected void onHistoryButtonClick(ActionEvent event) throws IOException {
        FXMLLoaderUtil.loadFXML(event, "history-view.fxml");
    }

    @FXML
    protected void onAdminButtonClick(ActionEvent event) throws IOException {
        FXMLLoaderUtil.loadFXML(event, "admin-view.fxml");
    }

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
        FXMLLoaderUtil.loadFXML(event, "login-view.fxml");
    }
}
