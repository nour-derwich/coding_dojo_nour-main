from flask_app import app
from flask import render_template,redirect,request , session , flash
from flask_app.models.msg import Mssage
from flask_app.models.user import User


@app.route('/post_message',methods=['post'])
def post_msg():
    if 'users_id' not in session:
        return redirect('/')
    
    Mssage.create_msg(request.form)
    return  redirect('/dashboard')


@app.route('/destroy/message/<int:id>')
def destroy_message(id):
    data = {
        "id": id
    }
    Mssage.destroy(data)
    return redirect('/dashboard')



