from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.ninja import Ninja
class Dojo:
    db_name="dojos_and_ninjas"
    def __init__(self,data):
        self.id=data['id']
        self.naame=data['naame']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.ninjas=[]
#insert data
    @classmethod
    def create(cls,data):
        query="insert into dojos(naame)values(%(naame)s);"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        return result
#display aall users
    @classmethod
    def get_all_dojos(cls):
        query="select * from dojos ;"
        results=connectToMySQL(cls.db_name).query_db(query)
        list_dojos_from_db = []
        for row in results:
            list_dojos_from_db.append(cls(row))
            
        return list_dojos_from_db

    @classmethod
    def get_one_ninjas_dojo(cls, data):
        query="SELECT * FROM dojos Where id = %(id)s;"
        resultsd = connectToMySQL(cls.db_name).query_db(query,data)
        return cls(resultsd[0])
