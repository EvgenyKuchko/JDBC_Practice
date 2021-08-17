import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMethod {

    public void update() {
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
                String update_row = "UPDATE SHOP SET TITLE=? WHERE ID=?";
                System.out.println("Enter new  title:");
                textValue = UserParameters.text();
                System.out.println("Enter id, which will be update:");
                numValue = UserParameters.number();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(update_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.setInt(2, numValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 2) {
                String update_row = "UPDATE POSITION SET TITLE_POSITION=? WHERE ID=?";
                System.out.println("Enter new  title:");
                textValue = UserParameters.text();
                System.out.println("Enter id, which will be update:");
                numValue = UserParameters.number();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(update_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.setInt(2, numValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 3) {
                String update_row = "UPDATE PERSON SET POSITION_ID=? WHERE NAME=?";
                System.out.println("Enter new position id:");
                numValue = UserParameters.number();
                System.out.println("Enter name, which will be update:");
                textValue = UserParameters.text();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(update_row)) {
                    preparedStatement.setInt(1, numValue);
                    preparedStatement.setString(2, textValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if(table == 4){
                break;
            }else{
                System.out.println("Try again");
                update();
            }
        }
    }
}

