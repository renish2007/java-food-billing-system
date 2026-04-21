import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AaradhyaRestaurantFinal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Customer Details
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Table Number: ");
        int tableNo = sc.nextInt();
        sc.nextLine();

        double total = 0;
        int billNo = (int)(Math.random() * 10000);

        ArrayList<String> bill = new ArrayList<>();

        char more = 'y';

        // LOOP FOR MULTIPLE ORDERS
        while (more == 'y' || more == 'Y') {

            System.out.println("\nSelect Category:");
            System.out.println("1. Punjabi");
            System.out.println("2. Chinese");
            System.out.println("3. Gujarati");
            System.out.println("4. Dal Bati");

            int cat = sc.nextInt();
            sc.nextLine();

            // MENU DISPLAY
            if (cat == 1) {
                System.out.println("Punjabi Menu:");
                System.out.println("1. Paneer - 190");
                System.out.println("2. Dal Makhani - 220");
                System.out.println("3. Shahi Paneer - 260");
                System.out.println("4. Chole - 150");
                System.out.println("5. Mix Veg - 120");
                System.out.println("6. Butter Naan - 40");
                System.out.println("7. Roti - 20");
            } 
            else if (cat == 2) {
                System.out.println("Chinese Menu:");
                System.out.println("1. Noodles - 180");
                System.out.println("2. Manchurian - 160");
                System.out.println("3. Fried Rice - 170");
                System.out.println("4. Soup - 120");
            } 
            else if (cat == 3) {
                System.out.println("Gujarati Menu:");
                System.out.println("1. Full Thali - 200");
                System.out.println("2. Sev Tameta - 90");
                System.out.println("3. Undhiyu - 160");
                System.out.println("4. Dhokla - 80");
                System.out.println("5. Thepla(3 piece) - 50");
                System.out.println("6. Bhakhri - 40");
            } 
            else if (cat == 4) {
                System.out.println("Dal Bati Menu:");
                System.out.println("1. Dal Bati - 180");
                System.out.println("2. Bati Plate(3 piece) - 100");
            }

            // ITEM INPUT
            System.out.print("Enter Items (format 1-2,2-1): ");
            String input = sc.nextLine();
            String[] orders = input.split(",");

            for (String o : orders) {
                try {
                    String[] parts = o.split("-");
                    int choice = Integer.parseInt(parts[0].trim());
                    int qty = Integer.parseInt(parts[1].trim());

                    String item = "";
                    double price = 0;

                    if (cat == 1) {
                        if (choice == 1) { item = "Paneer"; price = 190; }
                        else if (choice == 2) { item = "Dal Makhani"; price = 220; }
                        else if (choice == 3) { item = "Shahi Paneer"; price = 260; }
                        else if (choice == 4) { item = "Chole"; price = 150; }
                        else if (choice == 5) { item = "Mix Veg"; price = 120; }
                        else if (choice == 6) { item = "Butter Naan"; price = 40; }
                        else if (choice == 7) { item = "Roti"; price = 20; }
                    } 
                    else if (cat == 2) {
                        if (choice == 1) { item = "Noodles"; price = 180; }
                        else if (choice == 2) { item = "Manchurian"; price = 160; }
                        else if (choice == 3) { item = "Fried Rice"; price = 170; }
                        else if (choice == 4) { item = "Soup"; price = 120; }
                    } 
                    else if (cat == 3) {
                        if (choice == 1) { item = "Thali"; price = 200; }
                        else if (choice == 2) { item = "Sev Tameta"; price = 90; }
                        else if (choice == 3) { item = "Undhiyu"; price = 160; }
                        else if (choice == 4) { item = "Dhokla"; price = 80; }
                        else if (choice == 5) { item = "Thepla(3 piece)"; price = 50; }
                        else if (choice == 6) { item = "Bhakhri"; price = 40; }
                    } 
                    else if (cat == 4) {
                        if (choice == 1) { item = "Dal Bati"; price = 180; }
                        else if (choice == 2) { item = "Bati Plate(3 piece)"; price = 100; }
                    }

                    double amt = price * qty;
                    total += amt;
                    bill.add(item + " x" + qty + " = " + amt);

                } catch (Exception e) {
                    System.out.println("Invalid input skipped");
                }
            }

            System.out.print("Anything else? (y/n): ");
            more = sc.next().charAt(0);
            sc.nextLine();
        }

        // DISCOUNT
        System.out.print("\nApply Discount? (y/n): ");
        char dis = sc.next().charAt(0);

        double discount = 0;

        if (dis == 'y' || dis == 'Y') {
            System.out.print("Enter Discount %: ");
            double d = sc.nextDouble();
            discount = (total * d) / 100;
            total = total - discount;
        }

        // DATE & TIME
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        double gst = total * 0.05;
        double finalAmt = total + gst;

        // FINAL BILL PRINT
        System.out.println("\n=================================");
        System.out.println("     AARADHYA RESTAURANT");
        System.out.println("=================================");
        System.out.println("Bill No  : " + billNo);
        System.out.println("Table No : " + tableNo);
        System.out.println("Customer : " + customerName);
        System.out.println("Date & Time : " + now.format(dtf));
        System.out.println("---------------------------------");

        for (String b : bill) {
            System.out.println(b);
        }

        System.out.println("---------------------------------");
        System.out.println("Total    : " + total);
        System.out.println("Discount : -" + discount);
        System.out.println("GST (5%) : " + gst);
        System.out.println("---------------------------------");
        System.out.println("Final Amt: " + finalAmt);
        System.out.println("=================================");
        System.out.println("Thank You! Visit Again ");
    }
}
