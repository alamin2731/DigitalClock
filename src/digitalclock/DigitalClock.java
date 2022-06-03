/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package digitalclock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Alamin
 */
public class DigitalClock {

   public static void main(String[] arguments) {
    ClockLabel timeLable = new ClockLabel("time");
    JFrame f = new JFrame("Digital Clock");
    f.setSize(300,200);
    //f.setLayout(new GridLayout(1, 1));
    f.add(timeLable);
 
    f.getContentPane().setBackground(Color.black);
 
    f.setVisible(true);
     f.setLocationRelativeTo(null);
  }
}
 
class ClockLabel extends JLabel implements ActionListener {
 
  String type;
  SimpleDateFormat sdf;
 
  public ClockLabel(String type) {
    this.type = type;
    setForeground(Color.green);
 
    switch (type) {
      case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
                    setFont(new Font("century gothic", Font.BOLD, 50));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    break;
      default     : sdf = new SimpleDateFormat();
                    break;
    }
 
    Timer t = new Timer(1000, this);
    
    t.start();
  }
 
  public void actionPerformed(ActionEvent ae) {
    Date d = new Date();
    setText(sdf.format(d));
    
  }
}
