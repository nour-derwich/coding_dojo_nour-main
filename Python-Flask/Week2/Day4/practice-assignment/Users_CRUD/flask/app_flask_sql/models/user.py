from app_flask_sql.config.mysqlconnection import connectToMySQL
class User:
    db_name="uesrs_app"
    def __init__(self,data): #data is obj
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
#CRUD
    @classmethod
    def crearte(cls,data):
        query="insert into  uesrs_app.user (first_name,last_name)values(%(first_name)s,%(last_name)s);"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        return result
        
#display aall users
    @classmethod
    def get_all(cls):
        query="select * from uesrs_app.user;"
        results=connectToMySQL(cls.db_name).query_db(query)
        list_users_from_db = []
        for row in results:
            list_users_from_db.append(cls(row))
            
        return list_users_from_db
#get one

    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM uesrs_app.user  where id=%(id)s;"
        result1 = connectToMySQL(cls.db_name).query_db(query,data)
        return cls(result1[0])
#edit user
    @classmethod
    def edit_user(cls,data):
        query = "UPDATE uesrs_app.user SET first_name=%(first_name)s, last_name=%(last_name)s ,updated_at = NOW() WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)
# delete
    @classmethod
    def destroy(cls,data):
        query  = "DELETE FROM uesrs_app.user WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)