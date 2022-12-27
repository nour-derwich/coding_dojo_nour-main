from flask_mysql_app.config.mysqlconnection import connectToMySQL
class Book:
    db_name="books"
    def __init__(self,data):
        self.id=data['id']
        self.title=data['title']
        self.num_of_pages=data['num_of_pages']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
#insert data
    @classmethod
    def create_book(cls,data):
        query="insert into books.books(title,num_of_pages)values(%(title)s,%(num_of_pages)s);"
        resultb=connectToMySQL(cls.db_name).query_db(query,data)
        return resultb
#display aall books
    @classmethod
    def get_all_books(cls):
        query="select * from books.books ;"
        results1=connectToMySQL(cls.db_name).query_db(query)
        list_books_from_db = []
        for row in results1:
            list_books_from_db.append(cls(row))
            
        return list_books_from_db
#get one 
    @classmethod
    def get_books_by_id(cls,data):
        query = "SELECT * FROM books.books WHERE id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        return cls(results[0])
