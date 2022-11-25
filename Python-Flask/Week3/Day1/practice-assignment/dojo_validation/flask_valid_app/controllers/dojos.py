from flask_valid_app import app
from flask import render_template,redirect,request
from flask_valid_app.models.dojo import Dojo





@app.route('/')
def create4():

    return render_template('/login.html')
    
@app.route('/create', methods=['post'])
def create_dojo():
    if Dojo.is_valid(request.form):
        Dojo.create(request.form)
        return  redirect('/new_dojo')
    return('/')


@app.route('/new_dojo')
def results():
    return render_template('dojo.html', one_dojo=Dojo.get_one_dojo())
    
