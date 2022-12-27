from flask_app import app
from flask import render_template,redirect,request , session , flash
from flask_app.models.show import Show
from flask_app.models.user import User
from flask_app.models.like import like
#
@app.route('/new/show')
def new_show():
    if 'users_id' not in session:
        return redirect('/logout')
    data = {
        "id":session['users_id']
    }
    return render_template('new_show.html',user=User.get_one_by_id(data))
#********** insert
@app.route('/create_show',methods=['POST'])
def create_show():
    if 'users_id' not in session:
        return redirect('/logout')
    if not Show.validate_show(request.form):
        return redirect('/new/show')
    data = {
        "title": request.form["title"],
        "description": request.form["description"],
        "network": request.form["network"],
        "release_date": request.form["release_date"],
        "users_id": session["users_id"]
    }
    Show.create_show(data)
    return redirect('/dashboard')
    #**********
@app.route('/dashboard')
def display_shws():
    list_shows = Show.get_all_show()
    return render_template('show_page.html',  list_shows =  list_shows)
    # get one show with his creater
@app.route('/office_show/<int:id>')
def show_prod(id):
    if 'users_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    user_data = {
        "id":session['users_id']
    }

    return render_template("office_show.html",one_show=Show.get_one_show_by_id(data),user=User.get_one_by_id(user_data))
    #edit show

@app.route('/edit/<int:id>')
def edit_show(id):
    if 'users_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    user_data = {
        "id":session['users_id']
    }
    return render_template("edit_show.html",edit=Show.get_one_show_by_id(data),user=User.get_one_by_id(user_data))

@app.route('/update',methods=['POST'])
def update_show():
    if 'users_id' not in session:
        return redirect('/logout')
    if not Show.validate_show(request.form):
        return redirect('/new/show')
    data = {
        "title": request.form["title"],
        "description": request.form["description"],
        "network": request.form["network"],
        "release_date": request.form["release_date"],
        "id": request.form['id']
    }
    Show.update(data)
    return redirect('/dashboard')



    #delet
@app.route('/delet/<int:id>')
def destroy_recipe(id):
    if 'users_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    Show.destroy(data)
    return redirect('/dashboard')




