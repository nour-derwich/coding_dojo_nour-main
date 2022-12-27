from flask_mysql_app import app
from flask import render_template,redirect,request
from flask_mysql_app.models.author import Author

@app.route('/new_author')
def index():
    list_authors = Author.get_all_authors()
    return render_template('author.html', list_authors = list_authors)


@app.route('/')
def create4():
    return render_template('/author.html')
    
@app.route('/create', methods=['post'])
def create_Author():
    print(request.form)
    data = {
        "name": request.form["name"]
        
    }
    Author.create(data)
    return  redirect('/')
@app.route('/book')
def new_user():
    return render_template('books.html')

@app.route('/show_author/<int:id>')
def show_author(id):
    data={
        'id':id
    }
    one_authors = Author.get_by_id(data)
    return render_template('show_author.html', one_authors = one_authors)