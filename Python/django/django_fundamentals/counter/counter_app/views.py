from multiprocessing import context
from django.shortcuts import redirect, render


def index(request):
    if 'visits' in request.session:
        request.session['visits'] += 1
    else:
        request.session['visits'] = 1

    if 'counter' in request.session:
        request.session['counter'] += 1
    else:
        request.session['counter'] = 1

    return render(request, 'index.html')


def destroy_session(request):
    request.session.clear()
    return redirect('/')


def add_two(request):
    request.session['counter'] += 1
    return redirect('/')


def add_multi(request):
    request.session['counter'] += (int(request.POST['increment'])-1)
    return redirect('/')
