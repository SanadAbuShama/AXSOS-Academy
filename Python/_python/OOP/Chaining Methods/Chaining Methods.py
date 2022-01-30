class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount
        return self

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: {self.account_balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        return self


sanad = User('Sanad Abu Shama', 'sanad@gmail.com')
ahmad = User('Ahmad Salem', 'ahmad@gmail.com')
jamal = User('Jamal Hamed', 'jamal@gmail.com')


sanad.make_deposit(1000).make_deposit(1000).make_deposit(
    1000).make_withdrawal(500).display_user_balance()


ahmad.make_deposit(300).make_deposit(500).make_withdrawal(
    200).make_withdrawal(50).display_user_balance()


jamal.make_deposit(1000).make_withdrawal(300).make_withdrawal(
    300).make_withdrawal(300).display_user_balance()


sanad.transfer_money(jamal, 300).display_user_balance()


jamal.display_user_balance()
