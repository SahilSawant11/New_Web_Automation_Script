package SmokTesting;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Testdb {
    // Instance variables to store each row's data
    private String id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12;
    private String name1, name2, name3, name4, name5, name6, name7, name8, name9, name10 , name11, name12;
    private String Partition1, Partition2, Partition3, Partition4, partition5, partition6, partition7, partition8, partition9, partition10;
    private String Ward;
    private String server;
    private String Database;
    private String LGNusername;
    private String LGNpassword;
    private String URL;
    private String username;
    private String password;
    private String query;
    
    // Method to fetch data from the database
    public void fetchData() {
       
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 5)); // 3 rows, 2 columns
        
        // Add JComboBox for selection list
        String[] options = {"Bramati Municipal", "Panvel Municipal", "Pimpri Chinchwad Municipal"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(new JLabel("Select :"));
        panel.add(comboBox);
        
        // Add first JTextField for URL
        JTextField textField = new JTextField("http://testbaramatimc.ptaxcollection.com:8080/pages/login.aspx");
        panel.add(new JLabel("Enter URL"));
        panel.add(textField);
        
        // Add first JTextField for input
        JTextField textField1 = new JTextField("NTIS_4052_31_07_2024");
        panel.add(new JLabel("Enter DB NAME"));
        panel.add(textField1);
        
        // Add second JTextField for input username
        JTextField textField2 = new JTextField("jagdish.d");
        panel.add(new JLabel("Username:"));
        panel.add(textField2);
        
     // Add second JTextField for input username
        JTextField textField3 = new JTextField("123");
        panel.add(new JLabel("Password:"));
        panel.add(textField3);

        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                switch (selectedOption) {
                    case "Bramati Municipal":
                    	textField.setText("http://testbaramatimc.ptaxcollection.com:8080/pages/login.aspx");
                        textField1.setText("NTIS_4052_31_07_2024");
                        textField2.setText("jagdish.d");
                        textField3.setText("User@12345");
                        break;
                    case "Panvel Municipal":
                    	textField.setText("http://testpanvelmc.ptaxcollection.com:8080/Pages/Login.aspx");
                        textField1.setText("NTIS_4030_18062024");
                        textField2.setText("jagdish.d");
                        textField3.setText("123");
                        break;
                    case "Pimpri Chinchwad Municipal":
                    	textField.setText("http://testpcmc.ptaxcollection.com:8080/Pages/Login.aspx");
                        textField1.setText("NTIS_4050_22102024");
                        textField2.setText("sagar.m");
                        textField3.setText("Sagar@123");
                        break;
                }
            }
        });
        
        
        

        
        
        
        
        // Show the panel in a JOptionPane dialog
        int option = JOptionPane.showConfirmDialog(null, panel, "Configure Environment for Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Get selected value from comboBox
            String selectedOption = (String) comboBox.getSelectedItem();
            String bmc="Bramati Municipal";
            String PMC="Panvel Municipal";
            String pcmc="Pimpri Chinchwad Municipal";
            
//            if (selectedOption.equals(bmc)) {
//            	Ward="BMC";
//			} else {
//				Ward="KH";
//			}
            
            
            if (selectedOption.equals(bmc)) {
            	Ward="BMC";
            	username="uatuser";
            	password="UserUat@890";
            	server="192.168.1.8:1433";
            	query = "select top 12 NewWardNo, concat(NewPropertyNo,'-',NewPartitionNo) as propertyno from PropertyMast pm join ViewfunAMCGetPendingBalance vm on pm.ownerid=vm.ownerid left join BillTransactionDetails bt  on pm.ownerid=bt.ownerid  where vm.taxtotal>0 and vm.FinanceYear=2024 and bt.ownerid is null and NewWardNo not like '%D_%' and NewWardNo  like '%BMC%' and NewPartitionNo!=''";
            } else if (selectedOption.equals(PMC)) {
            	Ward="KH";
            	username="uatuser";
            	password="UserUat@890";
            	server="192.168.1.8:1433";
            	query = "select top 12 NewWardNo, concat(NewPropertyNo,'-',NewPartitionNo) as propertyno from PropertyMast pm join ViewfunAMCGetPendingBalance vm on pm.ownerid=vm.ownerid left join BillTransactionDetails bt  on pm.ownerid=bt.ownerid  where vm.taxtotal>0 and vm.FinanceYear=2024 and bt.ownerid is null and NewWardNo not like '%D_%' and NewWardNo  like '%KH%' and NewPartitionNo!=''";
            } else if (selectedOption.equals(pcmc)) {
            	Ward="KH";
            	username="rutuja.k";
            	password="Rutu@5555";
            	server="192.168.1.21:1433";
            	query = "select top 12  pm.NewWardNo,concat(pm.NewPropertyNo,'-',pm.NewPartitionNo) as propertyno from ViewfunAMCGetCurrentNPendingBalance VCP  INNER JOIN Assessment.AssessmentTracker AT on VCP.OwnerID=AT.PartOwnerID INNER JOIN PropertyMast PM on PM.OwnerID=AT.PartOwnerID INNER JOIN Survey.NoticeDistributionDetails NDD on PM.OwnerID=NDD.OwnerID  where TaxTotal > 0 and Result=1 and PropertyVisitStatusID=6 and  PM.NewPartitionNo!=''";
            }

            
            // Get input values from text fields
            
            URL= textField.getText();
            Database=textField1.getText();
             LGNusername=textField2.getText();
             LGNpassword=textField3.getText();
             
             
        } else {
            System.out.println("User canceled the input.");
        }
	       
        
        String url = "jdbc:sqlserver://"+server+";databaseName="+Database+";encrypt=true;trustServerCertificate=true"; 
      
        

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int row = 1;  // Row counter
            while (resultSet.next() && row <= 12) {
                String id = resultSet.getString("NewWardNo");
                String name = resultSet.getString("propertyno");

                
                // Store values in specific variables based on row number
                switch (row) {
                    case 1:
                        id1 = id;
                        name1 = name;
                        break;
                    case 2:
                        id2 = id;
                        name2 = name;
                        break;
                    case 3:
                        id3 = id;
                        name3 = name;
                        break;
                    case 4:
                        id4 = id;
                        name4 = name;
                        break;
                    case 5:
                        id5 = id;
                        name5 = name;
                        break;
                    case 6:
                        id6 = id;
                        name6 = name;
                        break;
                    case 7:
                        id7 = id;
                        name7 = name;
                        break;
                    case 8:
                        id8 = id;
                        name8 = name;
                        break;
                    case 9:
                        id9 = id;
                        name9 = name;
                        break;
                    case 10:
                        id10 = id;
                        name10 = name;
                        break;
                    case 11:
                    	id11 = id;
                    	name11 = name;
                    	break;
                    case 12:
                    	id12 = id;
                    	name12 = name;
                    	break;
                }
               
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String Geturl() { return URL; }
    public String GetWard() { return Ward; }
    public String Getusername() { return LGNusername; }
    public String Getpassword() { return LGNpassword; }

    // Getter methods to retrieve the data
    public String getId1() { return id1; }
    public String getName1() { return name1;}
    public String getId2() { return id2; }
    public String getName2() { return name2; }
    public String getId3() { return id3; }
    public String getName3() { return name3; }
    public String getId4() { return id4; }
    public String getName4() { return name4; }
    public String getId5() { return id5; }
    public String getName5() { return name5; }
    public String getId6() { return id6; }
    public String getName6() { return name6; }
    public String getId7() { return id7; }
    public String getName7() { return name7; }
    public String getId8() { return id8; }
    public String getName8() { return name8; }
    public String getId9() { return id9; }
    public String getName9() { return name9; }
    public String getId10() { return id10; }
    public String getName10() { return name10; }
    public String getId11() { return id11; }
    public String getName11() { return name11; }
    public String getId12() { return id12; }
    public String getName12() { return name12;}
    }
