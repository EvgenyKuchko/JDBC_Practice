public class DataBaseMenu {
    InsertMethod insertMethod = new InsertMethod();
    UpdateMethod updateMethod = new UpdateMethod();
    SelectMethod selectMethod = new SelectMethod();
    DeleteMethod deleteMethod = new DeleteMethod();
    private boolean operationsMenu = true;

    boolean activeMenu = true;

    public void menu() {
        while (activeMenu) {
            System.out.println("Enter method:\n" +
                    "[1]. Insert\n" +
                    "[2]. Update\n" +
                    "[3]. Select\n" +
                    "[4]. Delete\n" +
                    "[5]. Exit");
            int method = UserParameters.number();
            switch(method) {
                case 1:
                    insertMethod.insert();
                    break;
                case 2:
                    updateMethod.update();
                    break;
                case 3:
                    selectMethod.select();
                    break;
                case 4:
                    deleteMethod.delete();
                    break;
                case 5:
                    System.out.println("bye");
                    activeMenu = false;
                    break;
            }
        }
    }
}
