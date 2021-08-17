import java.sql.*;

public class SelectMethod {

    public void select() {
        boolean activeMethod = true;
        while (activeMethod) {
            System.out.println("Choose the table:\n" +
                    "[1]. Shop\n" +
                    "[2]. Position\n" +
                    "[3]. Person\n" +
                    "[4]. Back to menu");
            int table = UserParameters.number();
            if (table == 1) {
                Shop shop = new Shop();
                String select_all = "SELECT * FROM SHOP";
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(select_all)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    System.out.println("Shop:");
                    while (resultSet.next()) {
                        shop.setId(resultSet.getInt("ID"));
                        shop.setTitle(resultSet.getString("TITLE"));
                        System.out.println(shop);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 2) {
                Position position = new Position();
                String select_all = "SELECT * FROM POSITION";
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(select_all)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        position.setId(resultSet.getInt("ID"));
                        position.setPositionTitle(resultSet.getString("TITLE_POSITION"));
                        position.setShopId(resultSet.getInt("SHOP_ID"));
                        System.out.println(position);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 3) {
                Person person = new Person();
                String select_all = "SELECT * FROM PERSON";
                try (Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/shop", "root", "23081996ZHEnia");
                     PreparedStatement preparedStatement = conn.prepareStatement(select_all)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        person.setId(resultSet.getInt("ID"));
                        person.setName(resultSet.getString("NAME"));
                        person.setPositionId(resultSet.getInt("POSITION_ID"));
                        System.out.println(person);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Completed");
            }else if(table == 4){
                break;
            }else{
                System.out.println("T4ry again");
                select();
            }
        }
    }
}
class Shop {
    private String title;
    private int id;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
class Position{
    private int id;
    private String positionTitle;
    private int shopId;

    public void setId(int id) {
        this.id = id;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionTitle='" + positionTitle + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}
class Person{
    private int id;
    private String name;
    private int positionId;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positionId=" + positionId +
                '}';
    }
}