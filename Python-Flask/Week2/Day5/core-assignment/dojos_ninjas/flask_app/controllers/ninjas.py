from flask_app import app
from flask import render_template,redirect,request
from flask_app.models.ninja import Ninja

@app.route('/new_ninja')
def index1():
    list_ninjas=Ninja.get_all_ninjas()
    print(list_ninjas)
    return render_template('ninjas.html',  list_ninjas=list_ninjas)



    
@app.route('/create_ninja', methods=['post'])
def create_ninja():
    data=request.form
    Ninja.create_ninja(data)
    return  redirect('/add')
