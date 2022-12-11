package JavaFinalTest2021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCakeAndDrinkDialog extends JDialog {
    CakeSelectPane cakeSelectPane;
    AddCakeAndDrinkDialog() {
        setTitle("케이크와 음료 추가");
        setSize(250,200);

        setVisible(true);
    }

    private class CakeSelectPane extends JPanel {
        JButton jButton = new JButton("다음");
        CakeSelectPane() {
            add(new JLabel("케이크조각선택"));
            add(jButton);
            jButton.addActionListener(actionListener);
        }

        private ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == jButton){
                    
                }
            }
        };

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            
        }
    }
}
