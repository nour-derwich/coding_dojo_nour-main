class User:
    def init(self,name):
        self.name =name
        self.account_balance = 0
    def make_deposit(self,amount):
        self.account_balance += amount
    def make_withdrawal(self,amount): 
        self.account_balance -= amount
    def display_user_balance(self):
        print(f"User : {self.name} , Balance : {self.account_balance}$")
    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        self.display_user_balance()
        other_user.display_user_balance()

salma = User('salma')
nour = User('nour')
guido = User('guido')
# print(guido.name)

salma.make_deposit(500)
salma.make_deposit(500)
salma.make_deposit(500)
nour.make_deposit(500)
nour.make_deposit(500)
guido.make_deposit(500)


# print(guido.account_balance)

salma.make_withdrawal(175)
salma.make_withdrawal(175)
salma.make_withdrawal(175)
nour.make_withdrawal(175)
nour.make_withdrawal(175)
guido.make_withdrawal(175)
guido.make_withdrawal(175)
guido.make_withdrawal(175)
# print(guido.account_balance)


guido.display_user_balance()
salma.display_user_balance()
nour.display_user_balance()

salma.transfer_money(nour,100)