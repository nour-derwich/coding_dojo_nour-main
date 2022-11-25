from flask_app import app
from flask import render_template,redirect,request , session , flash
from flask_app.models.user import User
from flask_app.models.show import Show
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/register',methods=['post'])
def register():
    if User.validate_user(request.form) == False:
        return redirect('/')
    pw_hash = bcrypt.generate_password_hash(request.form['password'])
    print(pw_hash)
    data ={
            'first_name':request.form['first_name'],
            'last_name':request.form['last_name'],
            'email':request.form['email'],
            'password':pw_hash
    }
    return_form_db=User.create(data)
    session['users_id']=return_form_db
    print("-"*20, return_form_db ,"-"*20)
    return  redirect('/')
@app.route('/login',methods=['POST'])
def login():
    user = User.get_one_by_email(request.form)

    if not user:
        flash("Invalid Email","login")
        return redirect('/')
    if not bcrypt.check_password_hash(user.password, request.form['password']):
        flash("Invalid Password","login")
        return redirect('/')
    session['users_id'] = user.id
    return redirect('/dashboard')

@app.route('/dashboard')
def dashboard():
    if 'users_id' not in session:
        return redirect('/logout')
    data ={
        'id': session['users_id']
    }
    return render_template("shows_page.html",user=User.get_one_by_id(data),list_shows=Show.get_all_show())

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')
