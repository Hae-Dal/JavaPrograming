package JavaFinalTest2020;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JListClickDialog extends JDialog {
    private ArrayList<StudentStatus> studentList;
    private StudentStatus student;
    private JList jList;
    private int index;
    private DefaultListModel listContent;

    private JPanel statusPane;
    private JTextField tbName = new JTextField(7);
    private String[] cbScoreContent = {"100", "90", "80", "70", "60", "50"};
    private JComboBox cbMathScore = new JComboBox(cbScoreContent);
    private JComboBox cbScienceScore = new JComboBox(cbScoreContent);

    private  JPanel buttonPane;
    private JButton btnCancel;
    private JButton btnDelete;
    private JButton btnRetouch;
    private JFrame owner;

    public JListClickDialog(JFrame owner, ArrayList<StudentStatus> studentList, JList jList, DefaultListModel listContent) {
        this.owner = owner;
        this.studentList = studentList;
        this.jList = jList;
        this.index = jList.getSelectedIndex();
        this.student = studentList.get(index);
        this.listContent = listContent;

        setTitle("항목 수정, 삭제");
        setSize(400,150);
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        Container c = getContentPane();

        c.add(getStatusPane(), BorderLayout.NORTH);
        c.add(getButtonPane(),BorderLayout.SOUTH);


        setLocation(
                owner.getLocationOnScreen().x + (owner.getWidth()-getWidth())/2,
                owner.getLocationOnScreen().y + (owner.getHeight()-getHeight())/2
        );
    }

    public JPanel getStatusPane() {
        if (statusPane == null) {
            statusPane = new JPanel();

            statusPane.add(new JLabel("성명"));
            tbName.setEnabled(false);
            statusPane.add(tbName);
            tbName.setText(student.getName());

            statusPane.add(new JLabel("수학점수"));
            statusPane.add(cbMathScore);
            cbMathScore.getModel().setSelectedItem(student.getMathScore());

            statusPane.add(new JLabel("과학점수"));
            statusPane.add(cbScienceScore);
            cbScienceScore.getModel().setSelectedItem(student.getScienceScore());
        }

        return statusPane;
    }

    public JPanel getButtonPane() {
        if (buttonPane == null) {
            buttonPane = new JPanel();

            btnCancel = new JButton("취소");
            btnDelete = new JButton("삭제");
            btnRetouch = new JButton("수정");

            buttonPane.add(btnCancel);
            btnCancel.addActionListener(buttonListener);
            buttonPane.add(btnDelete);
            btnDelete.addActionListener(buttonListener);
            buttonPane.add(btnRetouch);
            btnRetouch.addActionListener(buttonListener);
        }
        return buttonPane;
    }

    public ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCancel) {
                dispose();
            } else if (e.getSource() == btnDelete) {
                dispose();
                studentList.remove(index);
                listContent = new DefaultListModel();
                for(int i = 0; i < studentList.size(); i++) {
                    listContent.addElement(studentList.get(i).getContent());
                }
                jList.removeAll();
                jList.setModel(listContent);


            } else if (e.getSource() == btnRetouch) {

            }
        }
    };
}