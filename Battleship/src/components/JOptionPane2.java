/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author lili_work1
 */
public class JOptionPane2
{

    public static JPanel createJPanel(Component parentComponnet, char[][] matrix, String message)
    {
        GridLayout gridLay = null;
        JLabel label = null;
        JPanelBGImage panel = null;

        gridLay = new GridLayout(matrix.length + 1, matrix[0].length + 1, 1, 1);
        panel = new JPanelBGImage(gridLay, "/components/Sea.jpg");
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);

        // ******* Column labels (numbers) *******
        for (int c = 0; c < matrix[0].length; c++)
        {
            label = new JLabel("" + (c + 1));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panel.add(label);
        }
        // ***************************************

        for (int r = 0; r < matrix.length; r++)
        {
            // **** Rows labels (Letters) ********
            label = new JLabel("" + (char) ('A' + r));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panel.add(label);
            // ***********************************

            for (int c = 0; c < matrix[r].length; c++)
            {
                label = new JLabel("");
                addLabel(panel, label, matrix, r, c);
                panel.add(label);
            }
        }

        JPanel panel2 = new JPanel();
        panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel2.add(panel);
        JLabel label2 = new JLabel(message);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel2.add(label2);

        //return JOptionPane.showInputDialog(parentComponent,panel2,"",JOptionPane.PLAIN_MESSAGE);
        return panel2;
    }

    public static JPanel createJPanel(Component parentComponent, char[][] matrix1, char[][] matrix2, String title1, String title2 ,String message)
    {
        GridLayout gridLay = null;
        JLabel label = null;
        JPanel panTitles = new JPanel(new GridLayout(1, 2, 10, 10));;
        JPanelBGImage panBoard1 = null;
        JPanelBGImage panBoard2 = null;
        JPanel panBoards = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel panMain = new JPanel();;

        label = new JLabel(title1);
        label.setFont(label.getFont().deriveFont(32f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        //label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panTitles.add(label);

        label = new JLabel(title2);
        label.setFont(label.getFont().deriveFont(32f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        //label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panTitles.add(label);

        panMain.add(panTitles);

        gridLay = new GridLayout(matrix1.length + 1, matrix1[0].length + 1, 1, 1);
        panBoard1 = new JPanelBGImage(gridLay, "/components/Sea.jpg");
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panBoard1.add(label);

        // ******* Column labels (numbers) *******
        for (int c = 0; c < matrix1[0].length; c++)
        {
            label = new JLabel("" + (c + 1));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panBoard1.add(label);
        }
        // ***************************************

        for (int r = 0; r < matrix1.length; r++)
        {
            // **** Rows labels (Letters) ********
            label = new JLabel("" + (char) ('A' + r));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panBoard1.add(label);
            // ***********************************

            for (int c = 0; c < matrix1[r].length; c++)
            {
                label = new JLabel("");
                addLabel(panBoard1, label, matrix1, r, c);
                panBoard1.add(label);
            }
        }

        panBoards.add(panBoard1);

        gridLay = new GridLayout(matrix2.length + 1, matrix2[0].length + 1, 1, 1);
        panBoard2 = new JPanelBGImage(gridLay, "/components/Sea.jpg");
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panBoard2.add(label);

        // ******* Column labels (numbers) *******
        for (int c = 0; c < matrix2[0].length; c++)
        {
            label = new JLabel("" + (c + 1));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panBoard2.add(label);
        }
        // ***************************************

        for (int r = 0; r < matrix2.length; r++)
        {
            // **** Rows labels (Letters) ********
            label = new JLabel("" + (char) ('A' + r));
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            panBoard2.add(label);
            // ***********************************

            for (int c = 0; c < matrix2[r].length; c++)
            {
                label = new JLabel("");
                addLabel(panBoard2, label, matrix2, r, c);
                panBoard2.add(label);
            }
        }
        

        panBoards.add(panBoard2);

        panMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        panMain.setLayout(new BoxLayout(panMain, BoxLayout.Y_AXIS));

        panMain.add(panBoards);
        JLabel label2 = new JLabel(message);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panMain.add(label2);
        

        return panMain;
    }
    

    // ******************** Customize labels ***************************
    public static void addLabel(JPanel panel, JLabel label, char[][] matrix, int r, int c)
    {
        if (matrix[r][c] == 'X')
        {
            label.setOpaque(true);
            label.setBackground(Color.BLUE);
            label.setForeground(Color.WHITE);
            label.setText("✗");
        }
        else if (matrix[r][c] == 'L')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("⌂");
        }
        else if (matrix[r][c] == 'B')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("▲");
        }
        else if (matrix[r][c] == 'P')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("♖");
        }
        else if (matrix[r][c] == 'A')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("ώ");
        }
        if (matrix[r][c] == 'O')
        {
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setForeground(Color.black);
            label.setText("❆");
        }
        if (matrix[r][c] == 'o')
        {
            label.setOpaque(true);
            label.setBackground(Color.BLUE);
            label.setForeground(Color.WHITE);
            label.setText("✗");
        }
         else if (matrix[r][c] == 'p')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("p");
        }
        else if (matrix[r][c] == 'b')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("b");
        }
        else if (matrix[r][c] == 'l')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("l");
        }
        else if (matrix[r][c] == 'a')
        {
             label.setOpaque(true);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.BLACK);
            label.setText("a");
        }
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

    }
    // *****************************************************************    

    public static void showMessageDialog(Component parentComponent, char[][] matrix, String message)
    {
        JPanel panel = createJPanel(parentComponent, matrix, message);
        JOptionPane.showMessageDialog(parentComponent, panel, "", JOptionPane.PLAIN_MESSAGE);
    }

    public static String showInputDialog(Component parentComponent, char[][] matrix, String message)
    {
        JPanel panel = createJPanel(parentComponent, matrix, message);

        return JOptionPane.showInputDialog(parentComponent, panel, "", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showMessageDialog(Component parentComponent, char[][] matrix1, char[][] matrix2, String title1, String title2 ,String message)
    {
        JPanel panel = createJPanel(parentComponent, matrix1, matrix2, title1, title2, message);
        JOptionPane.showMessageDialog(parentComponent, panel, "", JOptionPane.PLAIN_MESSAGE);
    }

    public static String showInputDialog(Component parentComponent, char[][] matrix1, char[][] matrix2, String title1, String title2 ,String message)
    {
        JPanel panel = createJPanel(parentComponent, matrix1, matrix2, title1, title2, message);

        return JOptionPane.showInputDialog(parentComponent, panel, "", JOptionPane.PLAIN_MESSAGE);
    }

}
