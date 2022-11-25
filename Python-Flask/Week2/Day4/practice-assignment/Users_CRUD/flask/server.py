from flask_mysql_app import app
from flask_mysql_app.controllers.books import Book

if __name__ == '__main__':
    app.run(debug=True)
