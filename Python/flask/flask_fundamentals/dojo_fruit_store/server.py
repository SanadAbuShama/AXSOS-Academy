import black
from flask import Flask, render_template, request, redirect
app = Flask(__name__)


@app.route('/')
def index():
    return render_template("index.html")


@app.route('/checkout', methods=['POST'])
def checkout():
    print(request.form)
    strawberry = request.form['strawberry']
    raspberry = request.form['raspberry']
    apple = request.form['apple']
    first_name = request.form['first_name']
    last_name = request.form['last_name']

    print(
        f'Charging {first_name} {last_name} for {int(strawberry)+int(raspberry)+int(apple)} fruits')
    return render_template("checkout.html", strawberry=strawberry, raspberry=raspberry,  apple=apple, first_name=first_name, last_name=last_name)


@app.route('/fruits')
def fruits():
    return render_template("fruits.html")


if __name__ == "__main__":
    app.run(debug=True)
