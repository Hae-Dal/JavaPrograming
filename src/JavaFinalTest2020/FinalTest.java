package JavaFinalTest2020;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FinalTest extends JFrame {

    private FinalTest owner;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenu jMenuProgramInfo;
    private JMenuItem jMenuItemAverage =  new JMenuItem("점수통계보기");
    private JMenuItem jMenuItemExit = new JMenuItem("종료");
    private JMenuItem jMenuItemExplane = new JMenuItem("설명");

    private JPanel inputPane;
    private JTextField tbName = new JTextField(7);
    private ButtonGroup rbGroup = new ButtonGroup();
    private JRadioButton rbFemale = new JRadioButton("여", true);
    private JRadioButton rbMale = new JRadioButton("남");
    private String[] cbGradeContent = {"1학년", "2학년", "3학년", "4학년"};
    private JComboBox cbGrade = new JComboBox(cbGradeContent);
    private String[] cbScoreContent = {"100", "90", "80", "70", "60", "50"};
    private JComboBox cbMathScore = new JComboBox(cbScoreContent);
    private JComboBox cbScienceScore = new JComboBox(cbScoreContent);
    private JButton btnAdd = new JButton("추가하기");
    private static ArrayList<StudentStatus> studentList = new ArrayList<>();

    private JScrollPane listScrollPane;
    private DefaultListModel listContent = new DefaultListModel();
    private JList jList = new JList(listContent);

    FinalTest() {
        owner = this;
        this.setTitle("JavaFinalTest2020.FinalTest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        this.setJMenuBar(getJMenuBar());
        c.add(getInputPane(), BorderLayout.NORTH);
        c.add(getListScrollPane(), BorderLayout.CENTER);

        setSize(400,300);
        setVisible(true);
    }

    //메뉴 바 설정========================================================================================================
    @Override
    public JMenuBar getJMenuBar() { //메뉴 바
        if(jMenuBar == null) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(getJMenu());
            jMenuBar.add(getJMenuProgramInfo());
        }
        return jMenuBar;
    }

    public JMenu getJMenu() { //메뉴 - 메뉴
        if(jMenu == null) {
            jMenu = new JMenu("메뉴");
            jMenu.add(jMenuItemAverage);
            jMenu.add(jMenuItemExit);
            jMenuItemAverage.addActionListener(menuActionListener);
            jMenuItemExit.addActionListener(menuActionListener);
        }
        return jMenu;
    }

    public JMenu getJMenuProgramInfo() { //메뉴 - 프로그램 정보
        if(jMenuProgramInfo == null) {
            jMenuProgramInfo = new JMenu("프로그램정보");
            jMenuProgramInfo.add(jMenuItemExplane);
            jMenuItemExplane.addActionListener(menuActionListener);
        }
        return jMenuProgramInfo;
    }

    private ActionListener menuActionListener = new ActionListener() { //메뉴 클릭 리스너
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jMenuItemExit) {
                System.exit(0);
            } else if (e.getSource() == jMenuItemAverage) {
                MenuAverageDialog menuAverageDialog = new MenuAverageDialog(calcAverage());
            } else if (e.getSource() == jMenuItemExplane) {
                JOptionPane.showMessageDialog(null, "이 프로그램은 Swing을 이용한 성적관리 프로그램입니다.", "프로그램설명", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    };

    private double[] calcAverage() {
        double mSum = 0;
        double sSum = 0;
        double[] result = new double[2];
        result[0] = 0;
        result[1] = 0;

        for(int i = 0; i < studentList.size(); i++) {
            mSum += studentList.get(i).getMathScore();
            sSum += studentList.get(i).getScienceScore();
        }

        result[0] = mSum / studentList.size();
        result[1] = sSum / studentList.size();
        return result;
    }

    //입력 팬 설정========================================================================================================
    public JPanel getInputPane() { //입력 팬 구성
        if (inputPane == null) {
            inputPane = new JPanel();
            GridLayout gridLayout = new GridLayout(2,3);
            inputPane.setLayout(gridLayout);

            JPanel inputNamePanel = new JPanel();
            inputNamePanel.add(new JLabel("성명"));
            inputNamePanel.add(tbName);

            JPanel inputSexPanel = new JPanel();
            rbGroup.add(rbFemale);
            rbGroup.add(rbMale);
            inputSexPanel.add(rbFemale, BorderLayout.WEST);inputSexPanel.add(rbMale, BorderLayout.WEST);

            JPanel inputGradePanel = new JPanel();
            inputGradePanel.add(new JLabel("학년"));
            inputGradePanel.add(cbGrade);

            JPanel inputMathScorePanel = new JPanel();
            inputMathScorePanel.add(new JLabel("수학점수"));
            cbMathScore.setSelectedIndex(1);
            inputMathScorePanel.add(cbMathScore);

            JPanel inputScienceScorePanel = new JPanel();
            inputScienceScorePanel.add(new JLabel("과학점수"));
            cbScienceScore.setSelectedIndex(1);
            inputScienceScorePanel.add(cbScienceScore);

            inputPane.add(inputNamePanel);
            inputPane.add(inputSexPanel);
            inputPane.add(inputGradePanel);
            inputPane.add(inputMathScorePanel);
            inputPane.add(inputScienceScorePanel);
            inputPane.add(btnAdd);
            btnAdd.setSize(5,3);
            btnAdd.addActionListener(btnActionListener);
        }
        return inputPane;
    }

    public ActionListener btnActionListener = new ActionListener() { //버튼 클릭 리스너
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(tbName.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "성명을 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
            } else {
                String sex;
                if (rbMale.isSelected()) {
                    sex = "남";
                } else {
                    sex = "여";
                }
                StudentStatus student = new StudentStatus(tbName.getText(),  cbGrade.getSelectedItem().toString(), sex, Integer.valueOf(cbMathScore.getSelectedItem().toString()), Integer.valueOf(cbScienceScore.getSelectedItem().toString()));
                studentList.add(student);
                listContent.addElement(student.getContent());
                getContentPane().repaint();
            }
        }
    };

    //스크롤 팬 설정 ====================================================================================================
    public JScrollPane getListScrollPane() {
        if(listScrollPane == null) {
            listScrollPane = new JScrollPane(jList);
            jList.addListSelectionListener(listSelectionListener);
            listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
        return listScrollPane;
    }

    public ListSelectionListener listSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(jList.getSelectedIndex() == -1) {
                return;
            }
            JListClickDialog jDialog = new JListClickDialog(owner, studentList, jList, listContent);
            jDialog.setVisible(true);
            getListScrollPane();
        }
    };


    public static void main(String[] args) {
        FinalTest JFrame = new FinalTest();
    }
}
