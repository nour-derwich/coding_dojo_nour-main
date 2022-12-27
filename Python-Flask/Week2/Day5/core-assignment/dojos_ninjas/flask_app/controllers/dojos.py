from flask_app import app
from flask import render_template,redirect,request
from flask_app.models.dojo import Dojo
from flask_app.models.ninja import Ninja

@app.route('/new_dojo')
def index():
    list_dojos=Dojo.get_all_dojos()
    print(list_dojos)
    return render_template('dojo.html',  list_dojos=list_dojos)


@app.route('/')
def create4():

    return render_template('/dojo.html')
    
@app.route('/create', methods=['post'])
def create_dojo():
    print(request.form)
    data= {
        "naame":request.form["naame"]
        
    }
    Dojo.create(data)
    return  redirect('/new_dojo')
@app.route('/add')
def create1():

    return render_template('/ninjas.html', list_dojos=Dojo.get_all_dojos())


# @app.route('/show/<int:id>')
# def show(id):
#     data={
#         'id':id
#         }
#     ninjas=Ninja.get_ninjas_dojos(data)
#     list_ninjas_dojo=Ninja.get_one_ninjas_dojo(data)
#     return render_template("table_ninja.html",ninjas=ninjas,list_ninjas_dojo=list_ninjas_dojo)
    
@app.route('/show/<int:id>')
def show_dojo(id):
    data = {
        'id':id
    }
    print("*-"*20 , data)
    one_dojo = Dojo.get_one_ninjas_dojo(data)
    ninjas = Ninja.get_dojo_ninjas(data)
    print("-"*25,ninjas)
    return render_template('table_ninja.html', dojo = one_dojo , ninjas=ninjas)