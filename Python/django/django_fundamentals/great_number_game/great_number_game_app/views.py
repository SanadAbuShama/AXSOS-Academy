from multiprocessing import context
from django.shortcuts import redirect, render
import random


def index(request):
    if not 'number' in request.session:
        num = random.randint(1, 100)
        request.session['number'] = num
    print(request.session['number'])
    return render(request, 'index.html')


def guess(request):
    if int(request.POST['guess']) > request.session['number']:
        request.session['guess'] = 'high'
    elif int(request.POST['guess']) < request.session['number']:
        request.session['guess'] = 'low'
    else:
        request.session['guess'] = 'correct'

    if not 'tries' in request.session:
        request.session['tries'] = 1
    else:
        if request.session['tries'] > 3 and request.session['guess'] != 'correct':
            request.session['guess'] = 'wrong'
        else:
            request.session['tries'] += 1

    return redirect('/')


def reset(request):
    if 'winners' in request.session:
        winners = request.session['winners']
        request.session.clear()
        request.session['winners'] = winners
    else:
        request.session.clear()
    return redirect('/')


def winner(request):
    request.session['name'] = request.POST['name']
    if not 'winners' in request.session:
        request.session['winners'] = []
    else:
        request.session['winners'].append(
            {'name': request.session['name'], 'tries': request.session['tries']})
    return redirect('/leaderboard')


def leaderboard(request):
    context = {
        'winners_length': len(request.session['winners'])
    }
    return render(request, 'leaderboard.html', context)
