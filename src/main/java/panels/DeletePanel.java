package panels;

import main.Layout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel {

    JLabel textLabel;
    JTextField inputField;
    JButton submit;
    Layout parent;
    public DeletePanel(Layout parent){
        this.parent = parent;
        setUpPanel();
    }

    private void setUpPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(100, 10, 100, 10));

        textLabel = new JLabel("Put in name of consumer to delete:");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 25));

        submit = new JButton("submit");
        submit.setSize(50, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                boolean deleted = false;
                for(int i=0; i<parent.getConsumers().size(); ++i){
                    if(parent.getConsumers().get(i).getName().equals(name)){
                        parent.getConsumers().remove(i);
                        parent.getListPanel().setList(parent.getConsumers());
                        deleted = true;
                        break;
                    }
                }
                if(!deleted)
                    textLabel.setText("No such Consumer");
                else
                    textLabel.setText("Put in name od consumer to delete:");
            }
        });

        this.add(textLabel);
        this.add(inputField);
        this.add(submit);
    }


}
