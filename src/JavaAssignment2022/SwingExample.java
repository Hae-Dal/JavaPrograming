package JavaAssignment2022;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SwingExample extends JFrame {
    public Container c;
    private JTextField TBKorean = new JTextField(5);
    private JTextField TBEnglish = new JTextField(5);;
    private JTextField TBMath = new JTextField(5);;

    private int KoreanScore,EnglishScore,MathScore;
    public double KoreanAng,EnglishAng,MathAng;
    int Sum;

    SwingExample() {
        this.setTitle("자바 프로젝트 과제");
        this.setDefaultCloseOperation(3);
        c = this.getContentPane();
        DrawGraph d = new DrawGraph(c);
        JButton btn = new JButton("그래프 그리기");
        JPanel textPanel = new JPanel();

        c.add(textPanel, "Last");
        textPanel.add(new JLabel("국어"));
        textPanel.add(TBKorean);
        textPanel.add(new JLabel("영어"));
        textPanel.add(TBEnglish);
        textPanel.add(new JLabel("수학"));
        textPanel.add(TBMath);
        textPanel.add(btn);
        btn.addActionListener(d);
        TBKorean.addKeyListener(d);
        TBEnglish.addKeyListener(d);
        TBMath.addKeyListener(d);

        textPanel.setSize(300, 200);
        this.setSize(500, 500);
        this.setVisible(true);


    }
    class EnterPress extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(TBKorean.getText().equals("") || TBEnglish.getText().equals("") || TBMath.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "텍스트 박스에 숫자를 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    DrawGraph drawGraph = new DrawGraph(c);
                    drawGraph.Repainting();
                }
            }
        }
    }
    public class DrawGraph extends KeyAdapter  implements ActionListener {
        private Container c;
        private CircleGraph canvas = new CircleGraph();

        DrawGraph(Container c) {
            this.c = c;
            this.c.add(this.canvas, "Center");
        }

        public void actionPerformed(ActionEvent actionEvent) {
            if(isNumeric(TBKorean.getText()) && isNumeric(TBEnglish.getText()) && isNumeric(TBMath.getText())){
                Repainting();
            } else {
                JOptionPane.showMessageDialog(null, "텍스트 박스에 숫자를 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(TBKorean.getText().equals("") || TBEnglish.getText().equals("") || TBMath.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "텍스트 박스에 숫자를 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    Repainting();
                }
            }
        }

        public void Repainting() {
            KoreanScore = Integer.valueOf(TBKorean.getText());
            EnglishScore = Integer.valueOf(TBEnglish.getText());
            MathScore = Integer.valueOf(TBMath.getText());
            Sum = KoreanScore + EnglishScore + MathScore;

            KoreanAng = getAngle(getRatio(Sum, KoreanScore));
            EnglishAng = getAngle(getRatio(Sum, EnglishScore));
            MathAng = getAngle(getRatio(Sum,MathScore));

            this.canvas.repaint();
        }

        public double getRatio(int numWhole, int numPart) {
            double ratio = ((double) numPart/ (double) numWhole) * 100;
            return ratio;
        }
        public double getAngle(double ratio) {
            double angle = 3.6 * ratio;
            return angle;
        }

        private static boolean isNumeric(String str){
            return str != null && str.matches("[0-9.]+");
        }
    }

    public class CircleGraph extends Canvas {
        public CircleGraph() {
        }

        public void paint(Graphics g) {
            super.paint(g);
        }

        @Override
        public void update(Graphics g) {
            super.update(g);
            g.setColor(Color.RED);
            g.fillArc(100,100,200,200,0, (int) KoreanAng);
            g.setColor(Color.GREEN);
            g.fillArc(100,100,200,200,(int) KoreanAng, (int) EnglishAng);
            g.setColor(Color.BLUE);
            g.fillArc(100,100,200,200,(int) EnglishAng + (int) KoreanAng, 360-((int)EnglishAng + (int)KoreanAng));
        }

    }

    public static void main(String[] args) {
        new SwingExample();
    } //메인 함수
}
