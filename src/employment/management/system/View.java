/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employment.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author HP
 */
public class View extends JFrame implements ActionListener
{
    JTable table;
    Choice cemployeeId;
    
    JButton search, print, update, back;
     
    View()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);    
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from employee");
            while(rs.next())
            {
                cemployeeId.add(rs.getString("empId"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        table = new JTable();
        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select *  from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String query = "select *  from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try 
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else 
        if(ae.getSource()==print)
        {
            try {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else 
        if(ae.getSource()==update)
        {
            setVisible(false);
            new Update(cemployeeId.getSelectedItem());
        }
        else 
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args)
    {
        new View();
    }
    
}
