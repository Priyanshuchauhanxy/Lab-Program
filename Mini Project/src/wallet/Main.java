package wallet;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        WalletService walletService = new WalletService();
        StatementExporter exporter = new StatementExporter();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt(scanner, "Choose option: ");

            switch (choice) {
                case 1 -> handleRegistration(scanner, authService);
                case 2 -> handleLoginFlow(scanner, authService, walletService, exporter);
                case 3 -> {
                    running = false;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static void handleRegistration(Scanner scanner, AuthService authService) {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("UPI ID: ");
            String upiId = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            BigDecimal openingBalance = readAmount(scanner, "Opening Balance: ");

            boolean registered = authService.register(name, upiId, password, openingBalance);
            System.out.println(registered ? "Registered successfully." : "Registration failed.");
        } catch (Exception e) {
            System.out.println("Registration error: " + e.getMessage());
        }
    }

    private static void handleLoginFlow(
            Scanner scanner,
            AuthService authService,
            WalletService walletService,
            StatementExporter exporter
    ) {
        System.out.print("UPI ID: ");
        String upiId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authService.login(upiId, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome, " + user.getName() + " (" + MaskUtil.maskUpiId(user.getUpiId()) + ")");

        boolean loggedIn = true;
        while (loggedIn) {
            printWalletMenu();
            int operation = readInt(scanner, "Choose option: ");

            switch (operation) {
                case 1 -> {
                    BigDecimal amount = readAmount(scanner, "Amount: ");
                    if (walletService.addMoney(user.getId(), amount)) {
                        System.out.println("Updated balance: " + walletService.getCurrentBalance(user.getId()));
                    }
                }
                case 2 -> {
                    int receiverId = readInt(scanner, "Receiver User ID: ");
                    BigDecimal amount = readAmount(scanner, "Amount: ");
                    try {
                        walletService.sendMoney(user.getId(), receiverId, amount);
                        System.out.println("Updated balance: " + walletService.getCurrentBalance(user.getId()));
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Transfer failed: " + e.getMessage());
                    }
                }
                case 3 -> {
                    List<TransactionRecord> history = walletService.getTransactionHistory(user.getId());
                    if (history.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (TransactionRecord record : history) {
                            System.out.println(record.toDisplayString());
                        }
                    }
                }
                case 4 -> {
                    MonthlySummary summary = walletService.getMonthlySummary(user.getId());
                    System.out.println("Monthly Summary");
                    System.out.println("Total Sent: " + summary.totalSent());
                    System.out.println("Total Received: " + summary.totalReceived());
                    System.out.println("Successful Transactions: " + summary.successfulTransactions());
                    System.out.println("Failed Transactions: " + summary.failedTransactions());
                    System.out.println("Net Change: " + summary.netChange());
                }
                case 5 -> exporter.exportToTxt(user.getId(), "statement_" + user.getId() + ".txt");
                case 6 -> exporter.exportToCsv(user.getId(), "statement_" + user.getId() + ".csv");
                case 7 -> loggedIn = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("==== UPI Wallet Menu ====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    private static void printWalletMenu() {
        System.out.println();
        System.out.println("---- Wallet Operations ----");
        System.out.println("1. Add Money");
        System.out.println("2. Send Money");
        System.out.println("3. View History");
        System.out.println("4. Monthly Summary");
        System.out.println("5. Export TXT");
        System.out.println("6. Export CSV");
        System.out.println("7. Logout");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static BigDecimal readAmount(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
                if (amount.signum() < 0) {
                    System.out.println("Amount cannot be negative.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }
}
