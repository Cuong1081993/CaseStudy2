package Menu;

import Utilities.AppUtils;
import Views.OrderView;
import Views.ProductView;
import Views.SortView;
import Views.UserView;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static ProductView productView = new ProductView();

    public static void shopBakery() {
        try {
            String choose;
            System.out.println();
            System.out.println("==========***Bánh Mỳ Sài Gòn***=========");
            System.out.println("***** 1.        Đăng nhập          *****");
            System.out.println("***** 2.      Tạo tài khoản        *****");
            System.out.println("***** 0.    Thoát chương trình     *****");
            System.out.println("=======  *** SÀI GÒN BAKERY ***  =======");
            System.out.println("Vui lòng chọn chức năng:");
            System.out.print("=>");
            do {
                choose = input.nextLine();

                switch (choose) {
                    case "1":
                        UserView.login();
                        break;
                    case "2":
                        UserView.signIn();
                        break;
                    case "0":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Không có chức năng, vui lòng chọn lại !");
                        System.out.print("=>");
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menuAdmin() {
        boolean check = true;
        String choose;

        System.out.println("================***Menu***================");
        System.out.println("**     1. Quản lý sản phẩm              **");
        System.out.println("**     2. Quản lý đơn hàng              **");
        System.out.println("**     3. Quản lý người dùng            **");
        System.out.println("**     4. Quay lại màn hình đăng nhập   **");
        System.out.println("========  *** SÀI GÒN BAKERY ***  ========");
        System.out.println("Vui lòng chọn chức năng:");
        System.out.print("=>");

        do {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    menuManagerProduct();
                    break;
                case "2":
                    menuManagerOrder();
                    break;
                case "3":
                    menuManagerUsers();
                    break;
                case "4":
                    shopBakery();
                    break;
                default:
                    System.out.println("Không có chức năng, vui lòng chọn lại !");
                    System.out.print("=>");
                    check = false;
            }
        } while (!check);
    }

    public static void menuManagerProduct() {
        boolean check = true;
        String choose;

        System.out.println("=================***Quản lý Đơn Hàng***================");
        System.out.println("****              1. Thêm sản phẩm                 ****");
        System.out.println("****              2. Sửa thông tin sản phẩm        ****");
        System.out.println("****              3. Xóa sản phẩm                  ****");
        System.out.println("****              4. Hiển thị danh sách sản phẩm   ****");
        System.out.println("****              5. Tìm kiếm sản phẩm             ****");
        System.out.println("****              6. Sắp xếp sản phẩm              ****");
        System.out.println("****              0. Quay lại menu Admin           ****");
        System.out.println("=============== *** SÀI GÒN BAKERY***  ================");
        System.out.println("Chọn chức năng : ");
        System.out.print("=>");

        do {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    productView.addProduct();
                    break;
                case "2":
                    productView.editProduct();
                    break;
                case "3":
                    productView.removeProduct();
                    break;
                case "4":
                    productView.showProductListShowOutMenu();
                    break;
                case "5":
                    productView.findProduct();
                    break;
                case "6":
                    SortView.menuSort();
                    break;
                case "0":
                    Menu.menuAdmin();
                    break;
                default:
                    System.out.println("Lựa chọn không đúng vui lòng nhập lại");
                    System.out.print("⟹");
                    check = false;
            }
        } while (!check);
    }

    public static void menuManagerUsers() {
        try {
            boolean flag = true;
            String choice;
            System.out.println("=================***Quản lý Người Dùng***================");
            System.out.println("****              1. Xem danh sách User              ****");
            System.out.println("****              2. Xóa User                        ****");
            System.out.println("****              3. Set quyền truy cập User         ****");
            System.out.println("****              0. Quay lại menu Admin             ****");
            System.out.println("===============  *** SÀI GÒN BAKERY ***  ================");
            System.out.println("Chọn chức năng : ");
            System.out.println("==> ");
            do {
                choice = input.nextLine();
                switch (choice){
                    case "1":
                        UserView.showUserListChoice();
                        break;
                    case "2":
                        UserView.removeUser();
                        break;
                    case "3":
                        UserView.setRoleUser();
                        break;
                    case "0":
                        Menu.menuAdmin();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại.");
                        System.out.print("=> ");
                        flag = false;
                }
            }while (!flag);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public static void menuManagerOrder(){
        try {
            boolean flag = true;
            String choice;
            System.out.println("=================***Quản lý Đơn Hàng***================");
            System.out.println("****              1. Tạo đơn hàng                  ****");
            System.out.println("****              2. Xem danh sách Order           ****");
            System.out.println("****              0. Quay lại menu Quản lí         ****");
            System.out.println("===============  *** SÀI GÒN BAKERY *** ===============");
            System.out.println("Chọn chức năng: ");
            System.out.print("=> ");
            do {
                choice = input.nextLine();
                switch (choice){
                    case"1":
                        OrderView.addOrder();
                        break;
                    case "2":
                        OrderView.showListOrder();
                        break;
                    case "0":
                        menuAdmin();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại.");
                        System.out.print("=> ");
                        flag = false;
                }
            }while (!flag);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
