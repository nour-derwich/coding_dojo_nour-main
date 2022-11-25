from flask_valid_app.config.mysqlconnection import connectToMySQL
from flask import flash
class Dojo:
    db_name="dojo_survey"
    def __init__(self,data):
        self.name=data['name']
        self.id=data['id']
        self.location = data["location"]
        self.language = data["language"]
        self.comment=data['comment']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
#insert data
    @classmethod
    def create(cls,data):
        query="insert into dojo_survey.dojos(name,location,language,comment)values(%(name)s,%(location)s,%(language)s,%(comment)s);"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        return result
#display one user
    @classmethod
    def get_one_dojo(cls):
        query = "SELECT * FROM dojo_survey.dojos ORDER BY dojos.id DESC LIMIT 1;"
        result1 = connectToMySQL(cls.db_name).query_db(query)
        return cls(result1[0])
    @staticmethod
    def is_valid(dojo):
        is_valid= True
        if len(dojo['name']) < 3:
            is_valid = False
            flash("Name must be at least 3 characters.")
        if len(dojo['location']) < 1:
            is_valid = False
            flash("Must choose a dojo location.")
        if len(dojo['language']) < 1:
            is_valid = False
            flash("Must choose a favorite language.")
        if len(dojo['comment']) < 3:
            is_valid = False
            flash("Comments must be at least 3 characters.")
        return is_valid