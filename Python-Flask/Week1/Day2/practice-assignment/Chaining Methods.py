class User:
    def __init__(self,name):
        self.name =name
        self.account_balance = 0
    def make_deposit(self,amount):  
        self.account_balance += amount
        return self
    def make_withdrawal(self,amount): 
        self.account_balance -= amount
        return self
    def display_user_balance(self):
        print(f"User : {self.name} , Balance : {self.account_balance}$")
        return self
    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        self.display_user_balance()
        other_user.display_user_balance()
        return self

salma = User('salma')
nour = User('nour')
guido = User('guido')
# print(guido.name)

salma.make_deposit(500).make_deposit(500).make_deposit(500).make_withdrawal(175).make_withdrawal(175).make_withdrawal(175).display_user_balance()
nour.make_deposit(500).make_deposit(500).make_withdrawal(175).make_withdrawal(175).display_user_balance()
guido.make_deposit(500).make_withdrawal(175).make_withdrawal(175).make_withdrawal(175).display_user_balance()


