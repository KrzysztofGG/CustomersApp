package main;

import panels.*;
import utils.Consumer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Layout extends JFrame {

    public  int FRAME_SIZE = 500;
    //buttons
    private JButton showList, addConsumer, deleteConsumer, editConsumer;
    //layout
    private CardLayout layout;
    //panels
    JPanel buttonPanel;
    JPanel mainPanel;
    private ListPanel listPanel;
    private AddPanel addPanel;
    private DeletePanel deletePanel;
    private EditPanel1 editPanel1;
    private EditPanel2 editPanel2;
    private ArrayList<Consumer> consumers;
    private List<String> names;
    Layout(){
        this.setSize(FRAME_SIZE, FRAME_SIZE);
        this.setResizable(false);
        consumers = new ArrayList<>();
//        consumers.add(new Consumer("a", "", ""));
//        consumers.add(new Consumer("b", "", ""));
        names = new ArrayList<>();
        createLayout();

    }
    private void createListPanel(){
        listPanel = new ListPanel(this, consumers);
        mainPanel.add(listPanel, "List");
    }

    private void createAddPanel(){
        addPanel = new AddPanel(this);
        mainPanel.add(addPanel, "Add");
    }
    private void createDeletePanel(){
        deletePanel = new DeletePanel(this);
        mainPanel.add(deletePanel, "Delete");
    }

    private void createEditPanel1(){
        editPanel1 = new EditPanel1(this);
        mainPanel.add(editPanel1, "Edit1");
    }

    private void createEditPanel2(){
        editPanel2 = new EditPanel2(this);
        mainPanel.add(editPanel2, "Edit2");
    }
    public void createLayout(){

        layout = new CardLayout();

        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        mainPanel.setLayout(layout);

        createAddPanel();
        createListPanel();
        createDeletePanel();
        createEditPanel1();
        createEditPanel2();
        createButtons();

        add(mainPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createButtons(){

        showList = new JButton("List");
        showList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "List");
            }
        });
        buttonPanel.add(showList);

        addConsumer = new JButton("Add");
        addConsumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Add");
            }
        });
        buttonPanel.add(addConsumer);

        deleteConsumer = new JButton("Delete");
        deleteConsumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Delete");
            }
        });
        buttonPanel.add(deleteConsumer);

        editConsumer = new JButton("Edit");
        editConsumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Edit1");
            }
        });
        buttonPanel.add(editConsumer);

    }
    public static void main(String[] args){
        Layout l = new Layout();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setVisible(true);
    }
    public ListPanel getListPanel() {
        return listPanel;
    }

    public ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    @Override
    public CardLayout getLayout() {
        return layout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public EditPanel2 getEditPanel2(){
        return editPanel2;
    }
    public List<String> getNames(){return names;}

    public void setConsumers(ArrayList<Consumer> consumers) {
        this.consumers = consumers;
    }
}
