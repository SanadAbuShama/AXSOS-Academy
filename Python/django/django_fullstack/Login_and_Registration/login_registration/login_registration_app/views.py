from django.shortcuts import render


from django.shortcuts import render, redirect
from .models import User
from django.contrib import messages
import bcrypt


def index(request):
    return render(request, 'index.html')


def register(request):
    errors = User.objects.register_validator(request.POST)
    request.session['which_form'] = request.POST['which_form']
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/')
    else:

        password = request.POST['password']
        pw_hash = bcrypt.hashpw(
            password.encode(), bcrypt.gensalt()).decode()
        User.objects.create(
            first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'], password=pw_hash, birthday=request.POST['birthday'])
        user = User.objects.filter(email=request.POST['email'])
        if user:
            logged_user = user[0]
            request.session['userid'] = logged_user.id
        return redirect('/success')


def login(request):
    errors = User.objects.login_validator(request.POST)
    request.session['which_form'] = request.POST['which_form']
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/')
    user = User.objects.filter(email=request.POST['email'])
    if len(user) != 0:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            return redirect('/success')

    return redirect('/')


def success(request):
    if 'userid' in request.session:
        user = User.objects.get(id=int(request.session['userid']))
        if user:
            context = {
                'first_name': user.first_name
            }
            return render(request, 'success.html', context)
        else:
            return redirect('/')
    else:
        return redirect('/')


def logout(request):
    request.session.clear()
    return redirect('/')
