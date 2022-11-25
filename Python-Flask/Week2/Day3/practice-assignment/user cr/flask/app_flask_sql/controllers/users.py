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

# @app.route('/oneRobot/<int:id>')
# def oneRobot(id):
#     data ={ 
#         "id_robot":id
#     }
#     return render_template("show.html",)