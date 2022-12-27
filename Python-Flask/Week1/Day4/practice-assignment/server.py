from flask import Flask, render_template 
app = Flask(__name__)   




# @app.route('/')         
# def hello_world():
#     return 'Hello World!'  

# @app.route('/dojo')         
# def dojo():
#     return 'Dojo!'  

# @app.route('/say/<name>')
# def say(name):
   
#     return f'hi {name}'

# @app.route('/repeat/<int:HINT>/<string:name>')
# def repeat(HINT, name):
#     return f'{name * HINT }'
# @app.errorhandler(404)
# def page_not_found(e):
#     # note that we set the 404 status explicitly
#     return render_template('404.html'), 404

#playground >>>>>>>
# @app.route('/<int:HINT>/<string:color>')         
# def index(HINT,color):
#     return render_template("index.html", times=HINT,color=color)  

#checkeboard





















if __name__=="__main__":  
    app.run(debug=True)    