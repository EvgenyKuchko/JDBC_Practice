import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMethod {

    public void insert() {
        String textValue;
        int numValue;
        boolean activeMethod = true;
        while (activeMethod) {
            System.out.println("Choose the table:\n" +
                    "[1]. Shop\n" +
                    "[2]. Position\n" +
                    "[3]. Person\n" +
                    "[4]. Back to menu");
            int table = UserParameters.number();
            if (table == 1) {
                String insert_row = "INSERT INTO SHOP (TITLE) VALUES (?)";
                System.out.println("Enter title:");
                textValue = UserParameters.text();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(insert_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            } else if (table == 2) {
                String insert_row = "INSERT INTO POSITION (TITLE_POSITION, SHOP_ID) VALUES (?,?)";
                System.out.println("Enter title:");
                textValue = UserParameters.text();
                System.out.println("Enter shop position:");
                numValue = UserParameters.number();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(insert_row)) {
                    preparedStatement.setString(2, textValue);
                    preparedStatement.setInt(3, numValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            } else if (table == 3) {
                String insert_row = "INSERT INTO PERSON (NAME, POSITION_ID) VALUES (?,?)";
                System.out.println("Enter name:");
                textValue = UserParameters.text();
                System.out.println("Enter position id:");
                numValue = UserParameters.number();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(insert_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.setInt(2, numValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 4){
                break;
            }else{
                System.out.println("Try again");
                insert();
            }
        }
    }
}
