from flask_mysql_app import app
from flask_mysql_app.controllers import authors,books


if __name__ == '__main__':
    app.run(debug=True)
