package SmokTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testdb {
    // Instance variables to store each row's data
    private String id1, id2, id3, id4;
    private String name1, name2, name3, name4;
    private String Partition1, Partition2, Partition3, Partition4;

    // Method to fetch data from the database
    public void fetchData() {
        String url = "jdbc:sqlserver://192.168.1.8:1433;databaseName=NTIS_4030_18062024;encrypt=true;trustServerCertificate=true";
        String username = "uatuser";
        String password = "UserUat@890";
        String query = "select top 4 NewWardNo, concat(NewPropertyNo,'-',NewPartitionNo) as propertyno from PropertyMast pm join ViewfunAMCGetPendingBalance vm on pm.ownerid=vm.ownerid left join BillTransactionDetails bt  on pm.ownerid=bt.ownerid  where vm.taxtotal>0 and vm.FinanceYear=2024 and bt.ownerid is null and NewWardNo not like '%D_%' and NewWardNo  like '%KH%' and NewPartitionNo!=''";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int row = 1;  // Row counter
            while (resultSet.next() && row <= 4) {
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
                }
               
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter methods to retrieve the data
    public String getId1() { return id1; }
    public String getName1() { return name1;}
    public String getId2() { return id2; }
    public String getName2() { return name2; }
    public String getId3() { return id3; }
    public String getName3() { return name3; }
    public String getId4() { return id4; }
    public String getName4() { return name4; }
}
