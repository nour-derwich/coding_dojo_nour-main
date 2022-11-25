from flask_mysql_app import app
from flask import render_template,redirect,request
from flask_mysql_app.models.book import Book




@app.route('/book')
def create_book1():
    list_books = Book.get_all_books()
    return render_template('books.html',  list_books =  list_books)

    
@app.route('/create_book1', methods=['post'])
def book():
    print(request.form)
    Book.create_book(request.form)
    return  redirect('/book')

@app.route('/show_books/<int:id>')
def show_books(id):
    data={
        'id':id
    }
    one_books= Book.get_books_by_id(data)
    return render_template('show_book.html', one_books= one_books)