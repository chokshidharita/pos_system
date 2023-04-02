package com.chokshi.deep.pos_system;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class SalesController {

    @FXML
    TextField quantityText;
    @FXML
    TableView salesTable;
    @FXML
    AnchorPane numpadAnchorPane;
    @FXML
    Label errorLabel;
    @FXML
    ToggleGroup productToggleGroup;
    @FXML
    Label totalAmountLabel;

    FxmlLoaderUtil fxmlLoaderUtil = FxmlLoaderUtil.getInstance();
    int totalPrice = 0;

    public void initialize() {
        productToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Handle button click event here
                System.out.println("Button " + ((ToggleButton) newValue).getText() + " clicked");
                numpadAnchorPane.setDisable(Boolean.FALSE);
            }
        });
    }

    @FXML
    protected void onMainMenuButtonClick(ActionEvent event) throws IOException {
        fxmlLoaderUtil.loadFXML(event, "dashboard-view.fxml");
    }

    @FXML
    protected void onInputButtonClick(ActionEvent event) {
        fxmlLoaderUtil.setValueToTextField(quantityText, event);
    }

    @FXML
    protected void onClearButtonClick() {
        if (quantityText.getLength() > 0)
            quantityText.deleteText(0, quantityText.getLength());
    }

    @FXML
    protected void onEnterButtonClick() {
        if (Objects.isNull(quantityText.getText()) || quantityText.getLength() == 0) {
            errorLabel.setText("Please select number of tickets");
        } else {
            int quantity = parseInt(quantityText.getText());
            totalPrice = parseInt(totalAmountLabel.getText());
            String[] productDetails = ((ToggleButton) productToggleGroup.getSelectedToggle()).getText().split(" ");
            String productName = productDetails[0];
            int productPrice = parseInt(productDetails[1]);

            // generate products based on quantity
            List<Product> data = new ArrayList<>();
            IntStream.range(0, quantity).mapToObj(i -> new Product(1, productName, productPrice)).forEach(product -> {
                data.add(product);
                totalPrice += productPrice;
            });
            salesTable.getItems().addAll(data);
            totalAmountLabel.setText(String.valueOf(totalPrice));

            onClearButtonClick();
            numpadAnchorPane.setDisable(Boolean.TRUE);
        }
    }

    @FXML
    protected void onPrintButtonClick() throws SQLException {
        ObservableList<Product> products = salesTable.getItems();

        // insert into database
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ticket(product_name, price, quantity) VALUES (?, ?, ?)");

        for (Product product : products) {
            preparedStatement.setString(1, product.getProduct());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        // connect printer to get print

        // reset values
        totalAmountLabel.setText("0");
        salesTable.getItems().clear();
        salesTable.refresh();
        errorLabel.setText("");
    }

    @FXML
    protected void onDeleteButtonClick() {
        if (salesTable.getSelectionModel().isEmpty()) {
            errorLabel.setText("Please select ticket to delete");
        } else {
            Product deleteProduct = (Product) salesTable.getSelectionModel().getSelectedItem();
            totalPrice -= deleteProduct.getPrice();
            totalAmountLabel.setText(String.valueOf(totalPrice));
            salesTable.getItems().remove(salesTable.getSelectionModel().getSelectedIndex());
        }
    }
}


