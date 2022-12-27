from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash


class Show:
    db_name="tv_shows"
    def __init__(self,data):
        self.title=data['title']
        self.id=data['id']
        self.network = data["network"]
        self.description = data["description"]
        self.release_date=data["release_date"]
        self.users_id = data['users_id']

#insert data
    @classmethod
    def create_show(cls,data):
        query="INSERT INTO tv_shows.tv_shows(title,network,description,release_date,users_id)values(%(title)s,%(network)s,%(description)s,%(release_date)s,%(users_id)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)
        
    @classmethod
    def get_one_show_by_id(cls,data):
        query="SELECT * FROM tv_shows.tv_shows WHERE id=%(id)s;"
        result_id=connectToMySQL(cls.db_name).query_db(query,data)
        return cls(result_id[0])
        #get all show
    @classmethod
    def get_all_show(cls):
        query="SELECT * FROM tv_shows.tv_shows ;"
        results=connectToMySQL(cls.db_name).query_db(query)
        shows=[]
        for row in results:
            shows.append(cls(row))
        return shows
        #edit show
    @classmethod
    def update(cls, data):
        query = "UPDATE tv_shows.tv_shows SET title=%(title)s, network=%(network)s, description=%(description)s, release_date=%(release_date)s WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)
    

    #delet show
    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM tv_shows WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)


    @staticmethod
    def validate_show(data):
        is_valid=True
        
        if len(data['title'])<3:
            flash("title must be at least 3 characters","show")
            is_valid=False
        if len(data['network'])<2:
            flash("network must be at least 3 characters","show")
            is_valid=False
        if len(data['description'])=="":
            flash("description must not be blank","show")
            is_valid=False
        if data['release_date'] == "":
            is_valid = False
            flash("Please enter a date","show")
            
        return is_valid

    
        