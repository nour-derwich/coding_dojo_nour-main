from flask_app.config.mysqlconncetion import connectToMySQL
from flask import flash
from datetime import datetime
import math




class Mssage:
    db_name="msges"
    def __init__(self,data):
        self.text=data['text']
        self.id=data['id']
        self.sender_id = data["sender_id"]
        self.reciver_id = data["reciver_id"]
        self.created_at = data["created_at"]
        self.created_at = data["updated_at"]

    def time_span(self):
        now = datetime.now()
        delta = now - self.created_at
        print(delta.days)
        print(delta.total_seconds())
        if delta.days > 0:
            return f"{delta.days} days ago"
        elif (math.floor(delta.total_seconds() / 60)) >= 60:
            return f"{math.floor(math.floor(delta.total_seconds() / 60)/60)} hours ago"
        elif delta.total_seconds() >= 60:
            return f"{math.floor(delta.total_seconds() / 60)} minutes ago"
        else:
            return f"{math.floor(delta.total_seconds())} seconds ago"
#insert data
    @classmethod
    def create_msg(cls,data):
        query="INSERT INTO msges.messages(text,sender_id,reciver_id)values(%(text)s,%(sender_id)s,%(reciver_id)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)
        

        #chick email
    
    @classmethod
    def get_msgs_users(cls,data):
        query = "SELECT users.first_name as sender, users2.first_name as receiver, messages.* FROM users LEFT JOIN messages ON users.id = messages.sender_id LEFT JOIN users as users2 ON users2.id = messages.reciver_id WHERE users2.id =  %(id)s"    
        results=connectToMySQL(cls.db_name).query_db(query,data)
        msgs=[]
        for row in results:
            msgs.append(cls(row))
        return msgs
    
    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM messages WHERE messages.id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)
    

    
        