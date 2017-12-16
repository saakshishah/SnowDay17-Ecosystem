from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

@app.route('/home')
def hello_world():
    return 'Hello, World!'

@app.route('/test')
def whatever():
    return render_template('index.html', input1 = buttonsPressed)

@app.route('/add',methods=['GET'])
def addButton():
    return jsonify(request.args.to_dict())

    
buttonsPressed = 11
