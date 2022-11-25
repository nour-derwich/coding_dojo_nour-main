from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")


@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    Raspberry=request.form['Raspberry']
    last_name=request.form['last_name']


   

    return render_template("checkout.html",Raspberry=Raspberry,last_name=last_name)


@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    