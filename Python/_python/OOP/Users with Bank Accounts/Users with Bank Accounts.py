class BankAccount:
    def __init__(self, int_rate=0.01, balance=0):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance > amount:
            self.balance -= amount
        else:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")
        return self

    def yield_interest(self):
        if self.balance > 0:
            self.balance += self.balance * self.int_rate
        return self


class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.accounts = {'Account1': BankAccount(int_rate=0.02, balance=0),
                         'Account2': BankAccount(int_rate=0.01, balance=0)
                         }

    def make_deposit(self, amount, accountNum):
        if accountNum == 1:
            self.accounts['Account1'].deposit(amount)
        else:
            self.accounts['Account2'].deposit(amount)

    def make_withdrawal(self, amount, accountNum):
        if accountNum == 1:
            self.accounts['Account1'].withdraw(amount)
        else:
            self.accounts['Account2'].withdraw(amount)

    def display_user_balance(self):
        print(
            f"User: {self.name}, Balance (Account 1): {self.accounts['Account1'].balance}, Balance (Account 2): {self.accounts['Account2'].balance}")

    def transfer_money(self, other_user, amount, accountNum, other_user_acountNum):
        if accountNum == 1 and other_user_acountNum == 1:
            self.accounts['Account1'].withdraw(amount)
            other_user.accounts['Account1'].deposit(amount)

        elif accountNum == 1 and other_user_acountNum == 2:
            self.accounts['Account1'].withdraw(amount)
            other_user.accounts['Account2'].deposit(amount)

        if accountNum == 2 and other_user_acountNum == 1:
            self.accounts['Account2'].withdraw(amount)
            other_user.accounts['Account1'].deposit(amount)

        if accountNum == 2 and other_user_acountNum == 2:
            self.accounts['Account2'].withdraw(amount)
            other_user.accounts['Account2'].deposit(amount)
