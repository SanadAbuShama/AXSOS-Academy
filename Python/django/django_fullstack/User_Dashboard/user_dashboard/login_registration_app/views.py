

from django.shortcuts import render, redirect


from .models import User

from django.contrib import messages
import bcrypt


def home(request):
    return render(request, 'home.html')


def register_form(request):
    if not 'userid' in request.session:
        return render(request, 'register.html')
    else:
        return redirect(f'/users')


def login_form(request):
    if not 'userid' in request.session:
        return render(request, 'login.html')
    else:
        return redirect(f'/users')


def register(request):
    errors = User.objects.register_validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/register_form')
    else:
        users = User.objects.all()
        if len(users) == 0:
            isAdmin = True
        else:
            isAdmin = False
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(
            password.encode(), bcrypt.gensalt()).decode()

        User.objects.create(
            first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'], password=pw_hash, admin=isAdmin)
        user = User.objects.filter(email=request.POST['email'])
        if user:
            logged_user = user[0]
            request.session['userid'] = logged_user.id
        return redirect('/users')


def login(request):
    errors = User.objects.login_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/login_form')
    user = User.objects.filter(email=request.POST['email'])
    if len(user) != 0:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            if logged_user.admin:
                return redirect('/users/admin')
            elif not logged_user.admin:
                return redirect('/users')

    return redirect('/')


def logout(request):
    request.session.clear()
    return redirect('/login_form')
