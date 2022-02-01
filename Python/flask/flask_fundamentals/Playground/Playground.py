from flask import Flask, render_template

app = Flask(__name__)


@app.route('/play')
def renderPageOne():
    return render_template('index.html')


@app.route('/play/<x>')
def renderPageTwo(x):
    return render_template('index.html', num_boxes=int(x))


@app.route('/play/<x>/<color>')
def renderPageThree(x, color):
    return render_template('index.html', num_boxes=int(x), box_color=color)


if __name__ == '__main__':
    app.run(debug=True)
