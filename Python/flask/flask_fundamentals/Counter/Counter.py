

from flask import Flask, render_template, request, redirect, session, session
app = Flask(__name__)
app.secret_key = 'pBy0_v"h"mlUr@M'
# our index route will handle rendering our form


@app.route('/')
def index():
    if 'counter' in session:
        session['counter'] += 1
    else:
        session['counter'] = 1
    if 'visits' in session:
        session['visits'] += 1
    else:
        session['visits'] = 1
    return render_template("index.html")


@app.route('/add_two')
def add_two():
    session['counter'] += 1
    return redirect('/')


@app.route('/add_multi', methods=['POST'])
def add_multi():
    increment = request.form['increment']
    session['counter'] += (int(increment)-1)
    return redirect('/')


@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)
