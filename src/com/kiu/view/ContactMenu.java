package com.kiu.view;
import com.kiu.controller.ContactController;
import com.kiu.model.Contact;

import java.util.Scanner;

public class ContactMenu {
    ContactController contactController = new ContactController();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice = -1;
        do {
            menu();
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showAllContacts(contactController);
                    break;
                }
                case 2: {
                    addNewContact(contactController);
                    break;
                }
                case 3: {
                    updateContact(contactController);
                    break;
                }
                case 4: {
                    deleteContact(contactController);
                    break;
                }
                case 5: {
                    showFindContact(contactController);
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
            }
        } while (choice != 8);
    }

    public void menu() {
        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        System.out.println("Chọn chức năng theo số (để tiếp tục");
        System.out.println("1. Xem danh bạ");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
    }

    public void showAllContacts(ContactController contactController) {
        int size = contactController.arraySize();
        if (size == 0) {
            System.out.println("Danh bạ trống");
        } else {
            System.out.println("Hiển thị toàn bộ danh bạ: ");
            contactController.displayAll();
        }
    }

    public Contact inputContactDetails() {
        System.out.println("Nhập tên: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Nhập nhóm liên lạc");
        String phoneGroup = scanner.nextLine();

        Contact contact = new Contact(name, gender, phoneNumber,address, email, phoneGroup);
        return contact;
    }

    public void addNewContact(ContactController contactController) {
        System.out.println("Thêm mới vào danh bạ: ");
        Contact contact = inputContactDetails();
        contactController.addNew(contact);
    }

    public void deleteContact(ContactController contactController) {
        System.out.println("Xóa: ");
        System.out.println("Nhập vào số điện thoại để tìm xóa: ");
        String phoneNumber = scanner.nextLine();
        boolean isDeleted = contactController.confirmDelete(phoneNumber);
        if (isDeleted) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tồn tại");
        }
    }

    public void showFindContact(ContactController contactController) {
        scanner.nextLine();
        System.out.println("Tìm kiếm: ");
        System.out.println("Nhập tên người cần ");
        String name = scanner.nextLine();
        int contactIndex = contactController.findContactByName(name);
        if (contactIndex != -1) {
            System.out.println("Thông tin cần tìm: ");
            System.out.println(contactController.getByIndex(contactIndex));
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public void updateContact(ContactController contactController) {
        System.out.println("Chỉnh sửa thông tin: ");
        System.out.println("Nhập tên");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        int contactIndex = contactController.findContactByPhone(phoneNumber);
        if (contactIndex != -1) {
            Contact contact = inputContactDetails();
            contactController.udpateByPhone(phoneNumber, contact);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tồn tại");
        }
    }
}
