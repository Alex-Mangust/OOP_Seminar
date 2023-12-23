package servis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class HolderJframe {
    private static boolean proof = false;
    protected void proofInWork(boolean dispenserPay){
        HolderJframe.proof = dispenserPay;
    }
    public int work(int count){
        if (proof) {
            JFrame workFrame = new JFrame("Работа");
            JTextComponent workText = new JTextArea();
            JPanel workJPanel = new JPanel();
            workFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Toolkit toolKit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolKit.getScreenSize();
            workFrame.setBounds(dimension.width / 2 - 225, dimension.height / 2 - 225, 450, 450);
            workFrame.setVisible(true);
            if (count > 0) {
                String worked = "Гудение...";
                workText.setText(worked);
                workJPanel.add(workText);
                workFrame.getContentPane().add(BorderLayout.CENTER, workJPanel);
                workText.setBackground(Color.black);
                workJPanel.setBackground(Color.black);
                workText.setEditable(false);
                workText.setForeground(Color.red);
                count--;
                try {
                    TimeUnit.SECONDS.sleep(1);
                    workFrame.dispose();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                return work(count);
            } else {
                String worked = "Выдача продукта!\nПоздравляем с покупкой!";
                workText.setText(worked);
                workJPanel.add(workText);
                workFrame.getContentPane().add(BorderLayout.CENTER, workJPanel);
                workText.setBackground(Color.black);
                workJPanel.setBackground(Color.black);
                workText.setEditable(false);
                workText.setForeground(Color.red);
                try {
                    TimeUnit.SECONDS.sleep(5);
                    workFrame.dispose();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                return 0;
            }
        }
        return 0;
    }
    public int work() {
        int count = 5;
        return work(count);
    }
}
