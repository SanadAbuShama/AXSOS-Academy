from multiprocessing import context
import re
from django.shortcuts import render, redirect
from datetime import datetime
import random


def welcome(request):
    return render(request, 'welcome.html')


def start(request):
    request.session['target_gold'] = int(request.POST['target_gold'])
    request.session['target_moves'] = int(request.POST['target_moves'])
    return redirect('/player/play')


def index(request):
    return render(request, 'index.html')


def process_money(request, location):
    if not 'gold' in request.session:
        request.session['gold'] = 0

    if not 'message' in request.session:
        request.session['message'] = ''
    if not 'moves' in request.session:
        request.session['moves'] = 1
    else:
        request.session['moves'] += 1

    if location == 'farm':
        num = random.randint(10, 20)
        request.session['gold'] += num
        request.session[
            'message'] += f'<li style="color:green;">Earned {num} gold from the farm  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'

    elif location == 'cave':
        num = random.randint(5, 10)
        request.session['gold'] += num
        request.session[
            'message'] += f'<li style="color:green;">Earned {num} gold from the cave  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
    elif location == 'house':
        num = random.randint(2, 5)
        request.session['gold'] += num
        request.session[
            'message'] += f'<li style="color:green;">Earned {num} gold from the house  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
    elif location == 'casino':
        selection = random.randint(1, 2)
        num = random.randint(0, 50)
        if selection == 1:
            request.session['gold'] += num
            request.session[
                'message'] += f'<li style="color:green;">Earned {num} gold from the casino  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'
        else:
            request.session['gold'] -= num
            request.session[
                'message'] += f'<li style="color:red;">Lost {num} gold from the casino  ({datetime.now().strftime("%Y/%m/%d %I:%M %p")})</li>'

    if request.session['gold'] < request.session['target_gold'] and request.session['moves'] >= request.session['target_moves']:
        request.session['win_or_lose'] = 'You Lost'
    elif request.session['gold'] >= request.session['target_gold'] and request.session['moves'] <= request.session['target_moves']:
        request.session['win_or_lose'] = 'You Won'

    return redirect('/player/play')


def reset(request):
    request.session.clear()
    return redirect('/')
