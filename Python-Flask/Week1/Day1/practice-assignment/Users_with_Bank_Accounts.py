class User:
 
   def __init__(self,name,email):
        self.name =name
        self.email =email
        self.amount =0
    
    
    
   def make_deposit(self, amount):	
        self.amount += amount	
      
   def make_withdrawal(self,amount):
      self.amount=self.amount -amount
     
   def display_user_balance(self):
      print(f"user:{ self.name}\n account:$ {self.amount}")
   def transfer_money(self,amount,user):
      self.amount+=amount
      user.amount-=amount
      self.display_user_balance()
      user.display_user_balance()



messi = User("Lionel Messi","messi@gmail.com")
beyonce = User("beyonce","beyonce@gmail.com")
bob = User("bob marley","marley@gmail.com")
messi.make_deposit(100)
messi.make_deposit(500)
bob.make_deposit(200)
bob.make_deposit(20)

messi.make_withdrawal(10)
messi.make_withdrawal(100)
bob.make_withdrawal(15)
bob.make_withdrawal(150)
messi.display_user_balance()

bob.display_user_balance()

bob.transfer_money(5,beyonce)

