from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash

class like:
    db_name="tv_shows"
    def __init__(self,data):
        self.action=data['action']
        self.id=data['id']
        self.users_id=data['users_id']
        self.tv_shows_id = data["tv_shows_id"]
        self.tv_shows_users_id = data["tv_shows_users_id"]
    
#insert data
    @classmethod
    def save_like(cls,data):
        query="INSERT INTO tv_shows.likes(action,users_id,tv_shows_id,tv_shows_users_id)values(%(action)s,%(users_id)s,%(tv_shows_id)s,%(tv_shows_users_id)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)
        

        #like sum
    
    @classmethod
    def get_one_like_by_id(cls,data):
        query="SELECT * FROM tv_shows.likes ORDER BY likes.id DESC LIMIT 1  tv_shows_id=%(id)s"
        result_id=connectToMySQL(cls.db_name).query_db(query,data)
        return cls(result_id[0])
    @classmethod
    def get_all_likes(cls):
        query="SELECT * FROM tv_shows.likes ;"
        results=connectToMySQL(cls.db_name).query_db(query)
        users=[]
        for row in results:
            users.append(cls(row))
        return users


    
        