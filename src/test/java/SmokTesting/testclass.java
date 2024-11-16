package SmokTesting;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.testng.TestNG;

public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 TestNG testng = new TestNG();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5)); // 3 rows, 2 columns
        
        // Add JComboBox for selection list
        String[] options = {"TEST PAYMENT", "TEST ALL"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(new JLabel("Select :"));
        panel.add(comboBox);
        
        int option = JOptionPane.showConfirmDialog(null, panel, "Select What Uh want To Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Get selected value from comboBox
            String selectedOption = (String) comboBox.getSelectedItem();
           
            String bmc="TEST PAYMENT";
            if (selectedOption.equals(bmc)) {
            	 // Set the path to the TestNG XML file
    	        testng.setTestSuites(List.of("TEST-PAYMENT.xml"));

    	        // Run the tests
    	        testng.run();
    		
			}  else  {
				 // Set the path to the TestNG XML file
		        testng.setTestSuites(List.of("TEST-ALL-SCENARIOS.xml"));

		        // Run the tests
		        testng.run();
			
			}
        
             
        } else {
            System.out.println("User canceled the input.");
        }
		
		 

	       
		
	}

}
