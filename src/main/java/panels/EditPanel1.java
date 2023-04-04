package panels;

import utils.Consumer;
import main.Layout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditPanel1 extends JPanel {
    JLabel textLabel;
    JTextField inputField;
    JButton submit;
    Layout parent;
    public EditPanel1(Layout parent){
        this.parent = parent;
        setUpPanel();
    }

    private void setUpPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(100, 10, 100, 10));
        textLabel = new JLabel("Put in name of consumer to edit:");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        textLabel.setBounds(parent.FRAME_SIZE/2, parent.FRAME_SIZE, 200, 50);

        inputField = new JTextField();
        inputField.setBounds(0, 40, 200, 30);
        inputField.setFont(new Font("Arial", Font.PLAIN, 25));

        submit = new JButton("submit");
        submit.setSize(50, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                ArrayList<Consumer> list = parent.getConsumers();
                boolean found = false;
                Consumer c = null;
                for(int i=0; i<list.size(); ++i){
                    if(list.get(i).getName().equals(name)){
                        found = true;
                        c = list.get(i);
                        break;
                    }
                }
                if(!found)
                    textLabel.setText("No such Consumer");
                else{
                    textLabel.setText("Put in name of consumer to edit:");
                    inputField.setText("");
                    EditPanel2 editPanel2 = parent.getEditPanel2();
                    editPanel2.getNameField().setText(c.getName());
                    editPanel2.setOldName(c.getName());
                    editPanel2.getAddressField().setText(c.getAddress());
                    editPanel2.getVatField().setText(c.getVatId());
                    parent.getLayout().show(parent.getMainPanel(), "Edit2");
                }



            }
        });

        this.add(textLabel);
        this.add(inputField);
        this.add(submit);
    }
}
