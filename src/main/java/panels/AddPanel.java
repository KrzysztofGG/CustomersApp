package panels;

import main.*;
import utils.Consumer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddPanel extends JPanel {

    JLabel name, address, vatId, title;
    JTextField nameField, addressField, vatField;
    JButton submit;

    Layout parent;
    public AddPanel(Layout parent){
        this.parent = parent;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Add new Consumer");
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 30));

        vatId = new JLabel("vatId");
        vatId.setFont(new Font("Arial", Font.PLAIN, 30));

        address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.PLAIN, 30));

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));

        vatField = new JTextField();
        vatField.setFont(new Font("Arial", Font.PLAIN, 25));

        addressField = new JTextField();
        addressField.setFont(new Font("Arial", Font.PLAIN, 25));


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


                if(!parent.getNames().contains(name)){
                Consumer newConsumer = new Consumer(name, vat, address);

                    parent.getNames().add(name);
                    parent.getConsumers().
                            add(newConsumer);

                    parent.getListPanel().
                            setList(parent.getConsumers());

                    title.setText("Add new Consumer");
                }
                else{
                    title.setText("Consumer already present");
                }

            }
        });
        setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(title);
        this.add(Box.createVerticalStrut(15));
        this.add(name);
        this.add(Box.createVerticalStrut(15));
        this.add(nameField);
        this.add(Box.createVerticalStrut(15));
        this.add(address);
        this.add(Box.createVerticalStrut(15));
        this.add(addressField);
        this.add(Box.createVerticalStrut(15));
        this.add(vatId);
        this.add(Box.createVerticalStrut(15));
        this.add(vatField);
        add(submit);
    }

}
