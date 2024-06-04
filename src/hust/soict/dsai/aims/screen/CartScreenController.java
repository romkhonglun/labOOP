package hust.soict.dsai.aims.screen;

import hust.soict.dsai.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CartScreenController {
    private Cart cart;

    private StringProperty totalcoststring;
    @FXML
    private Button btnPlay;
    @FXML
    private Label lblTotalCost;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TextField tfFilter;


    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        this.totalcoststring = new SimpleStringProperty();
    }
    @FXML
    private void initialize() {
        totalcoststring.set(Float.toString(cart.totalCost())+"$");
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        this.cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> c) {
                updateCost();
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            new ChangeListener<Media>(){
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);                    }                }            };        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue , String newValue) {
                showFilteredList(newValue);
            }
        });
        lblTotalCost.textProperty().bind(totalcoststring);
        btnPlay.setOnAction(e -> btnPlayPressed(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null)));
        btnRemove.setOnAction(e -> btnRemovePressed(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
        0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null)));
        btnPlaceOrder.setOnAction(e -> btnPlaceOrderPressed(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null)));
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    @FXML
    void btnRemovePressed(MouseEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalcoststring.set(Float.toString(cart.totalCost())+"$");
    }
    private  void showFilteredList(String filter) {
        if (radioBtnFilterId.isSelected()) {
            tblMedia.setItems(cart.getItemsOrdered().filtered(media -> String.valueOf(media.getId()).contains(filter)));
        } else {
            tblMedia.setItems(cart.getItemsOrdered().filtered(media -> media.getTitle().contains(filter)));
        }
    }
    @FXML
    void btnPlaceOrderPressed(MouseEvent event) {
        Aims.placeOrder();

        // Show a dialog to notify success
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }
    @FXML
    void btnPlayPressed(MouseEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();

            // Show a dialog to notify playing
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Playing Media");
            dialog.setContentText("Now playing: " + media.getTitle());

            ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

            dialog.showAndWait();
        }
    }
    void updateCost() {
        totalcoststring.set(Float.toString(cart.totalCost())+"$");
    }
}
