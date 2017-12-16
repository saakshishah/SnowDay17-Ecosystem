from flask import Flask



app = Flask(__name__)

@app.route('/home')
def hello_world():
    return 'Hello, World!'

@app.route('/test')
def whatever():
    return 'ssadsdvdsv'

if __name__ == '__main__':
    app.run(debug = True, port=50000)
