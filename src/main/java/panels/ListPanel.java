package panels;

import utils.Consumer;
import main.Layout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListPanel extends JPanel {
    JList list;
    Layout parent;
    public ListPanel(Layout parent, ArrayList<Consumer> consumers){

        this.parent = parent;
        setList(consumers);
    }

    public void setList(ArrayList<Consumer> consumers){
        this.removeAll();
        JLabel title = new JLabel("All Consumers");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        add(title);

        list = new JList(consumers.toArray());
        list.setFixedCellWidth(parent.FRAME_SIZE - 100);
        list.setLayoutOrientation(JList.VERTICAL);

        add(new JScrollPane(list));
    }
}
