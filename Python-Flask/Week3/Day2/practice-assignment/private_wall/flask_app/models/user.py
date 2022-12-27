from flask_app.config.mysqlconncetion import connectToMySQL
from flask import flash
import re

EMAIL_REGEX=re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    db_name="msges"
    def __init__(self,data):
        self.first_name=data['first_name']
        self.id=data['id']
        self.last_name = data["last_name"]
        self.email = data["email"]
        self.password=data['password']
        self.created_at = data["created_at"]
        self.created_at = data["updated_at"]

    
#insert data
    @classmethod
    def create(cls,data):
        query="INSERT INTO msges.users(first_name,last_name,email,password)values(%(first_name)s,%(last_name)s,%(email)s,%(password)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)
        

        #chick email
    @classmethod
    def get_one_by_email(cls,data):
        query="SELECT * FROM msges.users WHERE email=%(email)s;"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        if len(result)<1:
            return False
        return cls(result[0])
    @classmethod
    def get_one_by_id(cls,data):
        query="SELECT * FROM msges.users WHERE id=%(id)s;"
        result_id=connectToMySQL(cls.db_name).query_db(query,data)
        if len(result_id) < 1:
            return False
        return cls(result_id[0])
    @classmethod
    def get_all_users(cls):
        query="SELECT * FROM msges.users ;"
        results=connectToMySQL(cls.db_name).query_db(query)
        users=[]
        for user in results:
            users.append(cls(user))
        return users

    @staticmethod
    def validate_user(data):
        is_valid=True
        query="SELECT * FROM msges.users WHERE email=%(email)s;"
        result = connectToMySQL(User.db_name).query_db(query,data)
        if len(result)>= 1:
            flash("Email Aleady Exists")
            is_valid=False
        if not EMAIL_REGEX.match(data['email']): 
            flash("Invalid email address!")
            is_valid = False
        if len(data['first_name'])<2:
            flash("first name must be at least 2 characters","register")
            is_valid=False
        if len(data['last_name'])<2:
            flash("last name must be at least 2 characters","register")
            is_valid=False
            #psswi=ord.vlalidations
        if len(data['password'])<8:
            flash("password must be at least 8 characters","register")
            is_valid=False
        if data['password']!=data['confirm_password']:
            flash("password Don't match","register")
            is_valid=False
        return is_valid

    
        