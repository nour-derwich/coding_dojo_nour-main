from flask_app import app
from flask import render_template,redirect,request , session
from flask_app.models.user import User


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/create',methods=['post'])
def create():
    if User.validate_email(request.form) == False:
        return redirect('/')
    data ={
            'email':request.form['email']
            
    }
    return_form_db=User.create(data)
    session['user_id']=return_form_db
    print("-"*20, return_form_db ,"-"*20)
    return  redirect('/results')

@app.route('/results')
def results():
    return render_template('success.html', all_emails=User.get_all_users())
@app.route('/destroy/<int:id>')
def destroy_email(id):
    data = {
        "id": id
    }
    User.destroy(data)
    return redirect('/results')
    