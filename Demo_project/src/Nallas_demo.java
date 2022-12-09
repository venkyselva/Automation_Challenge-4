import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.netty.util.internal.ThreadLocalRandom;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="Yet to start";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static  String  finalstring="";
	public static  int count;  
	public static Integer [] int_array;
	public static JButton number;
	public static JButton reset;
	public static String finalvalue="empty";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static int a[][];
	public static void main(String[] args) 
	{
					
     try
     {

    	 final JFrame frame = new JFrame();
 		frame.setTitle("-----Welcome to NALLAS-----");
 		JPanel pane1 = new JPanel();

 		//---to identify system resolution----
 		int[] scrn_resln = system_resolution();
 		 int width = scrn_resln[0];
 		 int height = scrn_resln[1];
 		 frame.setSize(width/2,height/2);
 		//---Element initialization----
 		 JLabel list_label = new JLabel("Enter Matrix length");
          userEnt = new JTextField("", 10);
          number = new JButton("Generate Table");
          reset = new JButton("Data formation");
          Set1 ="Yet to Start";
          Set_list1  = new JLabel("<html><br>"+"Matrix Generation **"+Set1+" --**</html>");
          pane1.add(list_label);
          pane1.add(userEnt);
          pane1.add(number);
          pane1.add(reset);
          pane1.add(Set_list1);
          frame.add(pane1);
           frame.setVisible(true);
    	 
           number.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  reset.setEnabled(true);
 				  userEnt.setEditable(false);
 				  number.setEnabled(false);
 				 finalstring = userEnt.getText();
 				 try
 				 {
 				
 				Set_list1.setText("<html><br>"+"Matrix Generation format---  "+finalstring+" * "+ finalstring+" --**</html>");
 					count = Integer.parseInt(finalstring);
 					final JFrame f = new JFrame();
 					JPanel container = new JPanel();
 					container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

 					JPanel panel1 = new JPanel();
 					JPanel panel2 = new JPanel();
 					container.add(panel2);
 					
 					 DefaultTableModel m = new DefaultTableModel(count,count);
 				     final JTable t = new JTable(m);
 			        JButton btn = new JButton("Generate");
 			        panel1.add(new JScrollPane(t), BorderLayout.CENTER);
 				    panel2.add(btn);
 				    container.add(panel1);
 				    container.add(panel2);
 				    f.add(container);
 				    f.setVisible(true);
 				    f.pack();
 				    btn.addActionListener(new ActionListener()
 				    {  
 						  public void actionPerformed(ActionEvent e)
 						  {
 							  System.out.println("generate event");
 							
 							  t.getCellEditor().stopCellEditing(); 
 							  t.repaint();
 							  for(int a =0; a<count;a++)
 							  {
 								  for(int b=0; b<count; b++)
 								  {
 									  String val = (String) t.getModel().getValueAt(a, b);
 									  System.out.println("table"+val);
 									  int valueint = Integer.parseInt(val);
 								       value.add(valueint);
 								  }
 							  }
 							 f.dispose();
 						  }
 				    });
 				    
 				 }
 				    catch(Exception k)
 				    {
 				    	finalstring = "invalid data";
 				    	Set_list1.setText("<html><br>"+"OutPut---  "+finalstring+" --**</html>");
 				    }
 				   
 		}});  

           
          reset.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  number.setEnabled(true);
 				  userEnt.setEditable(true);
 				  userEnt.setText("");
 				  reset.setEnabled(false);
 				 System.out.println("Tfor invalue"+finalstring);
 				  if(!finalstring.equalsIgnoreCase("invalid data"))
 				  {
 				 finalstring = "process completed : ";
 				 Set_list1.setText("<html><br>"+"OutPut---  "+finalstring+" --**</html>");
  				System.out.println("Test Demo");
  				 int[] array = new int[value.size()];
  			      for(int i=0;i<array.length;i++) 
  			      {
  			         array[i] = value.get(i);
  			         System.out.println(array[i]);
  			      }
  			    matrix_conversion(array);
  			    
  			  Set_list1.setText("<html><br>"+"OutPut---  "+finalstring+" --**</html>");
 				  }
 				  else
 				  {
 					 finalstring = "Reset Completed";
 					 Set_list1.setText("<html><br>"+"OutPut---  "+finalstring+" --**</html>");
 				  }
 			  }});
          
          
	}
	catch(Exception g)
	{
		System.out.println(g.toString());
	}
	}
 	
     public static void matrix_conversion(int[] arry)
     {
    	 int m = count;
    	 int a[][]=new int[count][count];
    	 int b=0;
    	 for(int i=0;i<count;i++)
         {
    		
             for(int j=0;j<count;j++)
             {
             a[i][j]=arry[b];

             System.out.printf("a[%d][%d]= %d\n",i,j,a[i][j]);
             b++;
              }
           }
    	 printSpiralOrder(a);
     }
	
     private static void printSpiralOrder(int[][] mat)
     {
         // base case
         if (mat == null || mat.length == 0) {
             return;
         }
  
         int top = 0, bottom = mat.length - 1;
         int left = 0, right = mat[0].length - 1;
  
         while (true)
         {
             if (left > right) {
                 break;
             }
  
             // print top row
             for (int i = left; i <= right; i++) {
            	 finalstring+=mat[top][i]+" ,";
                 System.out.print(mat[top][i] + " ");
             }
             top++;
  
             if (top > bottom) {
                 break;
             }
  
             // print right column
             for (int i = top; i <= bottom; i++) {
            	 finalstring+=mat[i][right]+" ,";
                 System.out.print(mat[i][right] + " ");
             }
             right--;
  
             if (left > right) {
                 break;
             }
  
             // print bottom row
             for (int i = right; i >= left; i--) {
            	 finalstring+=mat[bottom][i]+" ,";
                 System.out.print(mat[bottom][i] + " ");
             }
             bottom--;
  
             if (top > bottom) {
                 break;
             }
  
             // print left column
             for (int i = bottom; i >= top; i--)
             {
            	 finalstring+=mat[i][left]+" ,";
                 System.out.print(mat[i][left] + " ");
             }
             left++;
         }
         System.out.println(finalstring);
     }
  
     
	
	
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
	
	
	

}
