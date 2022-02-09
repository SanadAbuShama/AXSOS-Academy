
from django.shortcuts import render, redirect


from .models import User
from wall_app.models import Message, Comment
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
        return redirect('/dojo_wall/wall')


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
            return redirect('/dojo_wall/wall')

    return redirect('/')


def logout(request):
    request.session.clear()
    return redirect('/')


def post_message(request, userid):
    user_id = int(userid)
    this_user = User.objects.get(id=user_id)
    Message.objects.create(
        message=request.POST['message'], user=this_user)
    return redirect('/dojo_wall/wall')


def post_comment(request, message_id, userid):
    user_id = int(userid)
    message_ID = int(message_id)
    this_message = Message.objects.get(id=message_ID)
    this_user = User.objects.get(id=user_id)
    Comment.objects.create(
        comment=request.POST['comment'], user=this_user, message=this_message)
    return redirect('/dojo_wall/wall')
