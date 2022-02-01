
from flask import Flask, render_template, request, redirect
app = Flask(__name__)
# our index route will handle rendering our form


@app.route('/')
def index():
    return render_template("index.html")


@app.route('/result', methods=['POST'])
def get_info():
    print("Got Post Info")
    print(request.form)
    name = request.form['name']
    location = request.form['location']
    language = request.form['language']
    bootcamp = request.form['bootcamp']

    comment = request.form['comment']
    return render_template("result.html",
                           name=name,
                           location=location,
                           language=language,
                           bootcamp=bootcamp,
                           comment=comment)


if __name__ == "__main__":
    app.run(debug=True)
