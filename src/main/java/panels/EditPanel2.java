package panels;

import utils.Consumer;
import main.Layout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel2 extends JPanel {

    JLabel name, address, vatId, title;
    JTextField nameField, addressField, vatField;
    JButton submit;
    Layout parent;
    public EditPanel2(Layout parent){
        this.parent = parent;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Edit Consumer");

        name = new JLabel("New Name");
        name.setFont(new Font("Arial", Font.PLAIN, 30));

        address = new JLabel("New Address");
        address.setFont(new Font("Arial", Font.PLAIN, 30));

        vatId = new JLabel("New vatId");
        vatId.setFont(new Font("Arial", Font.PLAIN, 30));

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));

        addressField = new JTextField();
        addressField.setFont(new Font("Arial", Font.PLAIN, 25));

        vatField = new JTextField();
        vatField.setFont(new Font("Arial", Font.PLAIN, 25));

        submit = new JButton("Submit");
        submit.setSize(50, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                nameField.setText("");

                String address = addressField.getText();
                addressField.setText("");

                String vat = vatField.getText();
                vatField.setText("");

                parent.getConsumers().add(new Consumer(name, address, vat));
                parent.getListPanel().setList(parent.getConsumers());

                parent.getLayout().show(parent.getMainPanel(), "Edit1");
            }
        });
        setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(name);
        this.add(Box.createVerticalStrut(20));
        this.add(nameField);
        this.add(Box.createVerticalStrut(20));
        this.add(address);
        this.add(Box.createVerticalStrut(20));
        this.add(addressField);
        this.add(Box.createVerticalStrut(20));
        this.add(vatId);
        this.add(Box.createVerticalStrut(20));
        this.add(vatField);
        add(submit);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getVatField() {
        return vatField;
    }
}