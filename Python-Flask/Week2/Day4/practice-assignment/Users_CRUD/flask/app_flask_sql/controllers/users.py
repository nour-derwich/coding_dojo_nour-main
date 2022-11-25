from app_flask_sql import app
from flask import render_template,redirect,request
from app_flask_sql.models.user import User

@app.route('/')
def index():
    list_users = User.get_all()
    return render_template('index.html', list_users = list_users)
    #add new user
@app.route('/new')
def new_user():
    return render_template('page1.html')

@app.route('/create', methods=['post'])
def create_user():
    print(request.form)
    data = {
        "first_name": request.form["first_name"],
        "last_name" : request.form["last_name"],
    }
    User.crearte(data)
    return  redirect('/')
#get on user
@app.route('/show/<int:id>')
def get_one(id):
    data = {'id':id}
    one_user=User.get_one(data)
    return render_template("show.html",one_user=one_user)
    #edit user
@app.route('/edit/<int:id>')
def edit_action(id):
    data = {'id':id}
    edit_user1=User.get_one(data)

    return render_template("edit.html", edit_user1=edit_user1)

@app.route('/editing/<int:id>',methods=['post'])
def edit_user(id):
    data={
        'id':id,
        "first_name" :request.form["first_name"],
        "last_name":request.form["last_name"]
    }
    User.edit_user(data)
    return redirect('/')
#delete user
@app.route('/delete/<int:id>')
def delete_user(id):
    data ={
        'id': id
    }
    User.destroy(data)
    return redirect('/')