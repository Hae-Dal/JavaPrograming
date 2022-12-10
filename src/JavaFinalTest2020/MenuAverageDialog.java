package JavaFinalTest2020;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAverageDialog extends JDialog {
    double mAverage;
    double sAverage;
    private Graph averageGraph;
    private final JButton okButton = new JButton("확인");

    MenuAverageDialog(double[] averages) {
        this.mAverage = averages[0];
        this.sAverage = averages[1];
        setTitle("점수 통계 보기");
        setSize(400,300);
        Container c = getContentPane();
        c.add(drawGraph(),BorderLayout.CENTER);

        setVisible(true);
    }

    private Graph drawGraph() {
        if(averageGraph == null) {
            averageGraph = new Graph();
        }
        return averageGraph;
    }

    private class Graph extends JPanel {
        public Graph() {
            setLayout(null);

            okButton.setSize(100,30);
            okButton.addActionListener(btnListener);
            add(okButton);
            okButton.setLocation(150, 220);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(40,190,360,190); //x축
            g.drawLine(60,20,60,210); //y축

            g.drawLine(58,160,62,160); //구분선 50
            g.drawLine(58,130,62,130); //~
            g.drawLine(58,100,62,100); //~
            g.drawLine(58,70,62,70); //~
            g.drawLine(58,40,62,40); //구분선 100

            g.drawString("50",42,190);
            g.drawString("60",42,160);
            g.drawString("70",42,130);
            g.drawString("80",42,100);
            g.drawString("90",42,70);
            g.drawString("100",36,40);

            g.setColor(Color.BLUE);
            g.drawString("수학",150,210); //범례 수학
            g.drawString(String.valueOf((int)mAverage), 150,20); //값 수학
            g.fillRect(150, ((int)mAverage * -3 + 340),22,  190 - ((int)mAverage * -3 + 340)); //그래프 수학

            g.setColor(Color.GREEN);
            g.drawString("과학",250,210); //범례 과학
            g.drawString(String.valueOf((int)sAverage), 250,20); //값 과학
            g.fillRect(250, ((int)sAverage * -3 + 340),22,  190 - ((int)sAverage * -3 + 340)); //그래프 과학
        }
    }

    private ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };
}
