package org.example;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseDAO dao = new DatabaseDAO();
            // Test adding a client
            Client client = new Client();
            client.setFirstName("Alice");
            client.setLastName("Smith");
            client.setEmail("alice.smith@example.com");
            client.setPhone("555-1234");
            client.setAddress("456 Elm St");
            client.addClient();
            System.out.println("Client added: " + client.toJson());

            // Test retrieving all clients
//            List<Client> clients = Client.getAllClients();
//            System.out.println("All Clients:");
//            for (Client c : clients) {
//                System.out.println(c.toJson());
//            }

            // Test adding a bank
            Bank bank = new Bank();
            bank.setBankName("Example Bank");
            bank.setCountry("USA");
            bank.addBank();
            System.out.println("Bank added: " + bank.toJson());
//
//            // Test retrieving all banks
//            List<Bank> banks = Bank.getAllBanks();
//            System.out.println("All Banks:");
//            for (Bank b : banks) {
//                System.out.println(b.toJson());
//            }
//
            // Test adding an account
            Account account = new Account();
            account.setDate_creation(new Date(System.currentTimeMillis()));
            account.setDate_update(new Date(System.currentTimeMillis()));
            account.setAccount_type("Savings");
            account.setClient(client); // Set the client
            account.setBank(bank); // Set the bank
            // to add the balance to the account
            account.addAccount();
            dao.addBalancetoAccount(account,1000);
            System.out.println("Account added: " + account.toJson());
            System.out.println(account.getAccountinfosByid());

//
//            // Test retrieving all accounts
//            List<Account> accounts = Account.getAllAccounts();
//            System.out.println("All Accounts:");
//            for (Account a : accounts) {
//                System.out.println(a.toJson());
//            }
//
//            // Test adding a transaction
            Transaction transaction = new Transaction();
            transaction.setAmount(1000);
            transaction.setDate_transaction(new Date(System.currentTimeMillis()));
            transaction.setDescription("Initial deposit");
            transaction.setAccount_debit(account); // Assuming this is the debit account
            transaction.setAccount_credit(account); // Assuming this is the credit account (same account for simplicity)
            transaction.addTransaction();
            System.out.println("Transaction added: " + transaction.toJson());

//            // Test retrieving all transactions
//            List<Transaction> transactions = Transaction.getAllTransactions();
//            System.out.println("All Transactions:");
//            for (Transaction t : transactions) {
//                System.out.println(t.toJson());
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
