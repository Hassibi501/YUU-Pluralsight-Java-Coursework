package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.Valuable;

/**
 * Workbook 6a - Exercise - Portfolio
 * EXERCISE 1 - pg 29
 */

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        Valuable account2 = new BankAccount("Gary", "456", 1500);

        System.out.printf("""
                Original Account Balance:
                Account 1: $%.2f
                Account 2: $%.2f
                
                """, account1.getValue(), account2.getValue());

        account1.deposit(100);
        //account2.deposit(100);

        System.out.printf("""
                After Deposit Account Balance:
                Account 1: $%.2f
                Account 2: $%.2f
                """, account1.getValue(), account2.getValue());
      /*
        Did the deposit work for both accounts? Why or why not?
            No, only for account1. In Java, the compiler checks method calls using a variable's
            declared (compile-time) type: the type on the left side of "=" (e.g., List, String).
            The compiler only allows access to public members declared on that compile-time type.
            account1 has a compile-time type of BankAccount, so deposit() is allowed because
            BankAccount declares deposit() as public. account2 has a compile-time type of Valuable,
            which does not declare deposit(), even though its runtime type (the actual object created
            in memory, such as new BankAccount() or new StringBuilder()) is BankAccount, the same
            as account1. Because BankAccount implements Valuable, the compiler only exposes methods
            declared in Valuable (getValue()) through an account2 reference.

        What methods are available for account1?
            All public methods declared in BankAccount (such as deposit(), withdraw(), getValue(),
            and any getters you added), plus inherited methods from Object.

        What methods are available for account2?
            Only methods declared in the Valuable interface (getValue()), plus inherited methods
            from Object.

        Why?
            account2 has a compile-time type of Valuable, while account1 has a compile-time type
            of BankAccount. Valuable is an interface that only declares getValue(), whereas
            BankAccount is a class that declares additional methods like deposit() and overrides
            getValue() because it implements Valuable. This makes getValue() a shared contract across
            finance types so each object can report its value consistently.

            You cannot instantiate an interface directly (e.g., new Valuable()). Instead, you create
            an instance of a class that implements the interface (such as new BankAccount(...)) and
            assign it to a reference variable. When the reference type is an interface, you can only
            call methods declared on that interface at compile time, whereas when the compile-time
            and runtime types match, you can call everything declared on that class.
         */

        System.out.println("End of Program");
    }
}