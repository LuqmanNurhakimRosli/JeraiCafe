import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JeraiCafeApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<JeraiCafe> orderQueue = new LinkedList<>();
        LinkedList<JeraiCafe> orderHistory = new LinkedList<>();

        int choice = 0;
        System.out.print("Name: ");
        String customerName = in.next();
        System.out.println("\t\t\t======= Hi " + customerName + "! =======\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("*******************  THE PROGRAM IS RUNNING  *******************");
        System.out.println("----------------------------------------------------------------");
        System.out.println("===================  WELCOME TO JERAI CAFE  ====================\n");
        System.out.println("\t\tPlease select your order below:");
        System.out.println("================================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("\t1) Cappuccino :\tRM5.00 (HOT)\tRM5.50(COLD)");
        System.out.println("\t2) Espresso   :\tRM4.00 (HOT)\tRM4.50(COLD)");
        System.out.println("\t3) Latte      :\tRM6.00 (HOT)\tRM6.50(COLD)");
        System.out.print("\tChoose your drink: ");
        String drinkId = in.next();
        System.out.print("\tHot or Cold? (H/C): ");
        char preparationType = in.next().charAt(0);

        if (preparationType == 'H'||  preparationType == 'C') {
            System.out.print("\tEnter Amount: ");
            int drinkAmount = in.nextInt();
            System.out.print("\tYour contact number: ");
            String customerContactNumber = in.next();
            System.out.print("\tPayment Type (C - Cash, B - Bank): ");
            char paymentType = in.next().charAt(0);
            
            JeraiCafe order = new JeraiCafe(drinkId, customerName, paymentType, preparationType, customerContactNumber, drinkAmount, 0.00);
            orderQueue.add(order);
            orderHistory.addLast(order);
            
            if (paymentType == 'C' || paymentType == 'B') {
                while (choice != 4) {
                    System.out.println("============================================================");
                    System.out.println("\t1) Add order");
                    System.out.println("\t2) Delete your last order");
                    System.out.println("\t3) Modify order");
                    System.out.println("\t4) Exit and display receipt");
                    System.out.println("------------------------------------------------------------");
                    System.out.print("Any changes?: ");
                    choice = in.nextInt();

                    if (choice == 1) {
                        // Allow the user to input another order
                        System.out.println("\t1) Cappuccino :\tRM5.00 (HOT)\tRM5.50(COLD)");
                        System.out.println("\t2) Espresso   :\tRM4.00 (HOT)\tRM4.50(COLD)");
                        System.out.println("\t3) Latte      :\tRM6.00 (HOT)\tRM6.50(COLD)");
                        System.out.print("\tChoose your drink: ");
                        drinkId = in.next();
                        System.out.print("\tHot or Cold? (H/C): ");
                        preparationType = in.next().charAt(0);
                        System.out.print("\tEnter Amount: ");
                        drinkAmount = in.nextInt();
                        orderQueue.add(new JeraiCafe(drinkId, customerName, paymentType, preparationType, customerContactNumber, drinkAmount, 0.00));
                        orderHistory.addLast(new JeraiCafe(drinkId, customerName, paymentType, preparationType, customerContactNumber, drinkAmount, 0.00));
                    } else if (choice == 2) {
                        // Additional code for handling choice 2
                        if (!orderQueue.isEmpty()) {
                            orderQueue.poll(); // Remove the first order from the queue
                            if (!orderHistory.isEmpty()) {
                                orderHistory.removeLast(); // Remove the last order from the history
                            }
                            System.out.println("Last order deleted successfully!");
                        } else {
                            System.out.println("No orders to delete.");
                        }
                    } else if (choice == 3) {
                        // Additional code for handling choice 3
                        if (!orderHistory.isEmpty()) {
                            JeraiCafe lastOrder = orderHistory.removeLast(); // Remove the first order from the queue
                            System.out.println("Modifying the last order: " + lastOrder.toString());

                            System.out.println("\t1) Cappuccino :\tRM5.00 (HOT)\tRM5.50(COLD)");
                            System.out.println("\t2) Espresso   :\tRM4.00 (HOT)\tRM4.50(COLD)");
                            System.out.println("\t3) Latte      :\tRM6.00 (HOT)\tRM6.50(COLD)");
                            System.out.print("\tModify your last ordered drink: ");
                            drinkId = in.next();
                            System.out.print("\tHot or Cold? (H/C): ");
                            preparationType = in.next().charAt(0);
                            System.out.print("\tEnter Amount: ");
                            drinkAmount = in.nextInt();

                            orderQueue.add(new JeraiCafe(drinkId, customerName, paymentType, preparationType, customerContactNumber, drinkAmount, 0.00));
                            orderHistory.addLast(new JeraiCafe(drinkId, customerName, paymentType, preparationType, customerContactNumber, drinkAmount, 0.00));
                        } else {
                            System.out.println("No orders to modify.");
                        }
                    }
                }

                // Display receipt or additional processing after the loop
                System.out.println("Receipt:");
                String formatTemplate = "\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t\t%s";
                System.out.println(String.format(formatTemplate, "Drink ID", "Name", "Payment type", "Preparation type", "Amount", "Contact", "Price"));
                double totalReceiptAmount = 0.00;
                for (JeraiCafe order1 : orderHistory) {
                    System.out.println(order1.toString());
                    totalReceiptAmount += order1.calculateTotalPrice();
                }
                System.out.println("Total Receipt Amount: RM" + totalReceiptAmount);
            } else
                System.out.println("Invalid input, Please restart the system!");
        } else
            System.out.println("Invalid input, Please restart the system!");
    }
}