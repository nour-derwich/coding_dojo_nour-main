


from flask import Flask, render_template, request, redirect,session
app = Flask(__name__) 
app.secret_key="erre"

@app.route('/', methods=['POST'])         
def index():

    if 'count' not in session:
        session['count']=0
    session['count'] +=1
    return render_template("index.html", count=session['count'])

@app.route('/reset')
def reset():
   session['count'] = 0
   return redirect('/')

@app.route('/plus2')
def plus2():
   session['count'] += 1
   return redirect('/')




















if __name__=="__main__":   
    app.run(debug=True)    