from flask_mysql_app.config.mysqlconnection import connectToMySQL
class Author:
    db_name="books"
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
#insert data
    @classmethod
    def create(cls,data):
        query="insert into books.authors(name)values(%(name)s);"
        result=connectToMySQL(cls.db_name).query_db(query,data)
        return result
#display aall users
    @classmethod
    def get_all_authors(cls):
        query="select * from books.authors;"
        results=connectToMySQL(cls.db_name).query_db(query)
        list_authors_from_db = []
        for row in results:
            list_authors_from_db.append(cls(row))
            
        return list_authors_from_db
#get one
    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM books.authors WHERE id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        return cls(results[0])
