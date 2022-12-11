package JavaFinalTest2021;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenu = new JMenu("메뉴");
    private JMenuItem saleShow = new JMenuItem("매출보기");
    private JMenuItem exit = new JMenuItem("종료");
    private JMenu jMenuProgramInfo = new JMenu("프로그램정보");
    private JMenuItem explain = new JMenuItem("설명");

    private JPanel orderPane;
    private JTextField tbMemberNum = new JTextField(7);
    private ButtonGroup rbGroup = new ButtonGroup();
    private JRadioButton rbMember = new JRadioButton("회원");
    private JRadioButton rbNotMember = new JRadioButton("비회원");
    private JButton btnAddCakeAndDrink = new JButton("케이크와 음료 추가");
    private JLabel lblOrderStatus = new JLabel("0조각, 0잔");
    private JTextField tbTotal = new JTextField("0원",7);
    private JButton btnOrder = new JButton("주문하기");
    private JButton btnRemove = new JButton("삭제하기");

    private JScrollPane jScrollPane;
    private JList jList = new JList<>();

    Main() {
        setTitle("자바 기말시험");
        setSize(400,300);
        setJMenuBar(getJMenuBar());
        Container c = getContentPane();
        c.add(getOrderPane(),BorderLayout.NORTH);

        setVisible(true);
    }

    //메뉴바 설정 =======================================================================================================
    @Override
    public JMenuBar getJMenuBar() {
        if(jMenuBar == null) {
            jMenuBar = new JMenuBar();

            jMenu.add(saleShow);
            jMenu.add(exit);

            jMenuProgramInfo.add(explain);

            jMenuBar.add(jMenu);
            jMenuBar.add(jMenuProgramInfo);
        }

        return jMenuBar;
    }

    public ActionListener menuActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == saleShow) {

            } else if (e.getSource() == explain) {

            }
        }
    };
    // 주문 팬 설정 =====================================================================================================
    public JPanel getOrderPane() {
        if(orderPane == null) {
            orderPane = new JPanel();
            orderPane.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1.0;
            gbc.weightx = 1.0;

            JPanel numberPane = new JPanel();
            numberPane.add(new JLabel("회원번호"));
            numberPane.add(tbMemberNum);

            rbGroup.add(rbMember);
            rbGroup.add(rbNotMember);
            JPanel rbPane = new JPanel();
            rbPane.add(rbMember);
            rbPane.add(rbNotMember);

            JPanel totalPane = new JPanel();
            totalPane.add(new JLabel("총액"));
            totalPane.add(tbTotal);
            tbTotal.setEnabled(false);

            JPanel btnPane = new JPanel();
            btnPane.add(btnOrder);
            btnOrder.addActionListener(btnActionListener);
            btnPane.add(btnRemove);
            btnRemove.addActionListener(btnActionListener);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(numberPane,gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(rbPane, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(new JPanel(), gbc);

            gbc.weighty = 0.3;
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(btnAddCakeAndDrink,gbc);
            btnAddCakeAndDrink.addActionListener(btnActionListener);

            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(lblOrderStatus, gbc);

            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(new JPanel(), gbc);

            gbc.weighty = 1;
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(totalPane,gbc);

            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            orderPane.add(btnPane,gbc);
        }
        return orderPane;
    }

    public ActionListener btnActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAddCakeAndDrink) {

            } else if (e.getSource() == btnOrder) {

            } else if (e.getSource() == btnRemove) {

            }
        }
    };

    //스크롤바 JList 설정 ================================================================================================

    public JScrollPane getjScrollPane() {
        if(jScrollPane == null) {
            jScrollPane = new JScrollPane();

            jScrollPane.add(jList);
            jList.addListSelectionListener(selectionListener);
        }
        return jScrollPane;
    }

    private ListSelectionListener selectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(jList.getSelectedIndex() == -1) {
                return;
            }
        }
    };

    public static void main(String[] args) {
        Main main = new Main();
    }
}
