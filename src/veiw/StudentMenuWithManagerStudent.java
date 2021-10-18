package veiw;

import control.ManagerStudent;
import model.Student;

import java.io.IOException;
import java.util.Scanner;

public class StudentMenuWithManagerStudent {
    public void runStudent(){
        Scanner number = new Scanner(System.in);
        ManagerStudent managerStudent = ManagerStudent.getInstance();

        int choice = -1;

        while (choice != 0){
            System.out.println("--------Quản lý sinh viên--------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm theo mã sinh viên");
            System.out.println("5. Dách sách sinh viên");
            System.out.println("0. Quay lại");

            choice = number.nextInt();

            switch (choice){
                case 1:
                    inputStudent(managerStudent);
                    break;
                case 2:
                    editStudent(managerStudent);
                    break;
                case 3:
                    removeStudent(managerStudent);
                    break;
                case 4:
                    System.out.println(managerStudent.searchStudentByCode(inputCode()));
                    break;
                case 5:
                    managerStudent.showAllStudent();
                    break;
                case 0:
            }
        }
    }

    //xóa sinh viên
    private void removeStudent(ManagerStudent managerStudent) {
            managerStudent.removeStudent(inputCode());
    }


    //sửa thông tin
    private void editStudent(ManagerStudent managerStudent) {
            managerStudent.editStudent(inputCode());

    }

    //tạo mới sinh viên
    private void inputStudent(ManagerStudent managerStudent) {
            managerStudent.addStudent(addStudent());

    }

    public static Student addStudent() {
        Scanner string = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String nameStudent;
        String yearOfBirth;
        String codeStudent;
        String class1;
        double balance;
        System.out.print("Nhập tên sinh viên: ");
        nameStudent = string.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        codeStudent = string.nextLine();
        System.out.print("Nhập năm sinh: ");
        yearOfBirth = string.nextLine();
        System.out.print("Nhập tên lớp: ");
        class1 = string.nextLine();
        System.out.print("Nhập số tiền hiện có: ");
        balance = sc.nextDouble();
        return new Student(nameStudent,codeStudent,yearOfBirth,class1,balance);
    }

    //nhập code sinh viên
    private String inputCode() {
        System.out.print("Nhập code sinh viên: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();

    }
}
