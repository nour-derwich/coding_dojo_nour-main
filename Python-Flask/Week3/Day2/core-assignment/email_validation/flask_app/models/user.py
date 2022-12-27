from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re
EMAIL_REGEX=re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    db_name="players"
    def __init__(self,data):
        self.id=data['id']
        self.email = data["email"]

        self.created_t = data["created_t"]
#insert data
    @classmethod
    def create(cls,data):
        query="INSERT INTO players.piayer(email)values(%(email)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)
        #chick the validaation email
    @classmethod
    def get_one_by_email(cls,data):
        query="SELECT * FROM players.piayer WHERE email=%(email)s;"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        if len(result)<1:
            return False
        return cls(result[0])
    # class method to delete an email from the database based on the PK.
    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM players.piayer WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)
    @classmethod
    def get_all_users(cls):
        query="SELECT * FROM players.piayer ;"
        results=connectToMySQL(cls.db_name).query_db(query)
        users=[]
        for row in results:
            users.append(cls(row))
        return users

    @staticmethod
    def validate_email(data):
        is_valid=True
        query="SELECT * FROM players.piayer WHERE email=%(email)s;"
        resultm = connectToMySQL(User.db_name).query_db(query,data)
        if len(resultm)>= 1:
            flash("Email Aleady Exists")
            is_valid=False
        if not EMAIL_REGEX.match(data['email']): 
            flash("Invalid email address!")
            is_valid = False
        return is_valid