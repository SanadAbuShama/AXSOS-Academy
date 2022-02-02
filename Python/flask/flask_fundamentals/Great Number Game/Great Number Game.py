
import random
from flask import Flask, render_template, request, redirect, session, session
app = Flask(__name__)
app.secret_key = 'pBy0_v"h"mlUr@M'
# our index route will handle rendering our form


@app.route('/')
def index():
    if not 'number' in session:
        num = random.randint(1, 100)
        session['number'] = num
        print(session)

    return render_template('index.html')


@app.route('/guess', methods=['POST'])
def guess():

    if int(request.form['guess']) > session['number']:
        session['guess'] = 'high'

    elif int(request.form['guess']) < session['number']:
        session['guess'] = 'low'

    else:

        session['guess'] = 'correct'

    if not 'tries' in session:
        session['tries'] = 1
    else:
        if session['tries'] > 3 and session['guess'] != 'correct':
            session['guess'] = 'wrong'
        else:
            session['tries'] += 1
    return redirect('/')


@app.route('/reset')
def reset():
    winners = session['winners']
    session.clear()
    session['winners'] = winners
    return redirect('/')


@app.route('/winner', methods=['POST'])
def winner():
    print(request.form)
    session['name'] = request.form['name']
    if not 'winners' in session:
        session['winners'] = []
    else:
        session['winners'].append(
            {'name': session['name'], 'tries': session['tries']})
    print(session['winners'])
    return redirect('/leaderboard')


@app.route('/leaderboard')
def leader_board():
    return render_template('leaderboard.html')


if __name__ == "__main__":
    app.run(debug=True)
