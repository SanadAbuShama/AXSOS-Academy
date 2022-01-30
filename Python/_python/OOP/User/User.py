class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount

    def make_withdrawal(self, amount):
        self.account_balance -= amount

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: {self.account_balance}")

    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount


sanad = User('Sanad Abu Shama', 'sanad@gmail.com')
ahmad = User('Ahmad Salem', 'ahmad@gmail.com')
jamal = User('Jamal Hamed', 'jamal@gmail.com')


sanad.make_deposit(1000)
sanad.make_deposit(1000)
sanad.make_deposit(1000)
sanad.make_withdrawal(500)
sanad.display_user_balance()


ahmad.make_deposit(300)
ahmad.make_deposit(500)
ahmad.make_withdrawal(200)
ahmad.make_withdrawal(50)
ahmad.display_user_balance()


jamal.make_deposit(1000)
jamal.make_withdrawal(300)
jamal.make_withdrawal(300)
jamal.make_withdrawal(300)
jamal.display_user_balance()


sanad.transfer_money(jamal, 300)
sanad.display_user_balance()
jamal.display_user_balance()
