import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMethod {

    public void delete() {
        String textValue;
        boolean activeMethod = true;
        while (activeMethod) {
            System.out.println("Choose the table:\n" +
                    "[1]. Shop\n" + "[2]. Position\n" +
                    "[3]. Person\n" + "[4]. Back to menu");
            int table = UserParameters.number();
            if (table == 1) {
                String delete_row = "DELETE FROM SHOP WHERE TITLE=?";
                System.out.println("Enter title for delete:");
                textValue = UserParameters.text();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(delete_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 2) {
                String delete_row = "DELETE FROM POSITION WHERE TITLE_POSITION=?";
                System.out.println("Enter title position for delete");
                textValue = UserParameters.text();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(delete_row)) {
                    preparedStatement.setString(1, textValue);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 3) {
                String delete_row = "DELETE FROM PERSON WHERE NAME=?";
                System.out.println("Enter name for delete:");
                textValue = UserParameters.text();
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(delete_row)) {
                    preparedStatement.setString(1, textValue);
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
                delete();
            }
        }
    }
}
