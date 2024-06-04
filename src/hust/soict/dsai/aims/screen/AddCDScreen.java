package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCDScreen extends JFrame{
    private Store store;

    public AddCDScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add Book");
        setSize(800, 600);
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());

        JTextField titleField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = titleField.getText();
            // Add a new book to the store
            store.addMedia(new CompactDisc(title, 0.0f));
        });

        center.add(new JLabel("Title:"));
        center.add(titleField);
        center.add(submitButton);

        return center;
    }
}
