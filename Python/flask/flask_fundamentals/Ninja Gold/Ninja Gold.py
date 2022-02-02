
from datetime import datetime
from flask import Flask, redirect, render_template, request, session
import random

app = Flask(__name__)
app.secret_key = 'pBy0_v"h"mlUr@M'


@app.route('/')
def render_table():

    return render_template('index.html')


@app.route('/process_money', methods=['POST'])
def process_gold():

    if not 'gold' in session:
        session['gold'] = 0

    if not 'message' in session:
        session['message'] = ''

    if request.form['building'] == 'farm':
        num = random.randint(10, 20)
        session['gold'] += num
        session['message'] += f'<li style="color:green;">Earned {num} gold from the farm  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'

    elif request.form['building'] == 'cave':
        num = random.randint(5, 10)
        session['gold'] += num
        session['message'] += f'<li style="color:green;">Earned {num} gold from the cave  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
    elif request.form['building'] == 'house':
        num = random.randint(2, 5)
        session['gold'] += num
        session['message'] += f'<li style="color:green;">Earned {num} gold from the house  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
    elif request.form['building'] == 'casino':
        selection = random.randint(1, 2)
        num = random.randint(0, 50)
        if selection == 1:
            session['gold'] += num
            session['message'] += f'<li style="color:green;">Earned {num} gold from the casino  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
        else:
            session['gold'] -= num
            session['message'] += f'<li style="color:red;">Lost {num} gold from the casino  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
    print(session['message'])
    return redirect('/')


@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
