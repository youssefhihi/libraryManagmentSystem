package main.java.com.library.ui;
import main.java.com.library.model.Member;
import main.java.com.library.service.MemberService;
import main.java.com.library.utils.database.connectDB;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class memberUI {
    private Connection connection;
    private MemberService memberService;
    public memberUI() {
        connection = connectDB.getConnection();
        memberService = new MemberService(connection);
    }
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMembers management");
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Update Member");
            System.out.println("4. get all members");
            System.out.println("5. get a member");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMember(scanner);
                    break;
                case 2:
                    deleteMember(scanner);
                    break;
                case 3:
                    updateMember(scanner);
                    break;
                case 4:
                    getAllMembers(scanner);
                    break;
                case 5:
                    getMember(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the the members management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        } while (choice != 6);
        scanner.close();
        }


    public void addMember(Scanner scanner) {
        System.out.println("Enter Member Full Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Member Address: ");
        String address = scanner.nextLine();

        Member member = new Member(0, name, address);
        try{
            memberService.addMember(member);
            System.out.println("Member added successfully");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(Scanner scanner) {
        System.out.println("Enter Member ID: ");
        int memberID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Member Full Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Member Address: ");
        String address = scanner.nextLine();
        Member member = new Member(memberID, name, address);
        try {
            memberService.updateMember(member);
            System.out.println("Member updated successfully");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMember(Scanner scanner) {
        System.out.println("Enter Member id: ");
        int id = scanner.nextInt();
        try{
           Member member = memberService.getMemberById(id);
            if(member != null) {
                System.out.println("Member found : "+ "ID: " + member.getId()+ " " + member.getFullName() + " " + member.getAddress());
            }else{
                System.out.println("Member not found with id : " + id);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getAllMembers(Scanner scanner) {
        try {
            List<Member> members = memberService.getAllMembers();
            if (members != null) {
                for (Member member : members) {
                    System.out.println("ID: " + member.getId() + " " + member.getFullName() + " " + member.getAddress());
                }
            } else {
                System.out.println("No members found");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(Scanner scanner) {
        System.out.println("Enter Member id: ");
        int id = scanner.nextInt();
        try{
            memberService.deleteMember(id);
            System.out.println("Member deleted successfully");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        memberUI app = new memberUI();
        app.display();
    }
}
