

from django.shortcuts import redirect, render
from login_registration_app.models import User
import bcrypt
from django.contrib import messages
from user_dashboard_app.models import Message, Reply


def show_profile(request, user_id):
    context = {
        'user': User.objects.get(id=user_id)
    }
    return render(request, 'user_profile.html', context)


def user_dashboard(request):
    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        if not user.admin:
            context = {
                'other_users': User.objects.exclude(id=user.id),
                'logged_user':user
            }
            return render(request, 'user_dashboard.html', context)
        else:
            return redirect('/users/admin')
    else:
        return redirect('/login_form')


def admin_dashboard(request):

    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        if user.admin:
            context = {
                'other_users': User.objects.exclude(id=user.id),
                'logged_user':user
            }
            return render(request, 'admin_dashboard.html', context)
        else:
            return redirect('/users')
    else:
        return redirect('/login_form')


def new_user(request):
    user = User.objects.get(id=request.session['userid'])
    if user.admin:
        return render(request, 'new_user.html')
    else:
        return redirect('/users')


def create_user(request):
    errors = User.objects.register_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/users/new')
    else:
        user = User.objects.get(id=request.session['userid'])
        if user.admin:
            password = request.POST['password']
            pw_hash = bcrypt.hashpw(
                password.encode(), bcrypt.gensalt()).decode()
            User.objects.create(
                first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'], password=pw_hash)
            return redirect('/users/admin')
        else:
            return redirect('/users')


def edit_user(request, user_id):
    user = User.objects.get(id=request.session['userid'])
    if user.admin:
        context = {
            'user_to_edit': User.objects.get(id=user_id)
        }
        return render(request, 'edit_user.html', context)
    else:
        return redirect('/users')


def edit_profile(request):

    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        context = {
            'user_to_edit': user
        }
        return render(request, 'edit_profile.html', context)
    else:
        return redirect('/login_form')


def update_user(request, user_id):
    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        if user.admin:
            request.session['which_form'] = request.POST['which_form']
            user_to_update = User.objects.get(id=user_id)
            if request.POST['which_form'] == 'update':
                errors = User.objects.update_user_validator(request.POST)
                if len(errors) > 0:
                    for key, value in errors.items():
                        messages.error(request, value)
                    return redirect(f'/users/edit/{user_id}')
                else:
                    user_to_update.email = request.POST['email']
                    user_to_update.first_name = request.POST['first_name']
                    user_to_update.last_name = request.POST['last_name']
                    user_to_update.admin = request.POST['user_level']
                    user_to_update.save()
                    return redirect('/users/admin')
            elif request.POST['which_form'] == 'update_password':
                errors = User.objects.update_password_validator(request.POST)
                if len(errors) > 0:
                    for key, value in errors.items():
                        messages.error(request, value)
                    return redirect(f'/users/edit/{user_id}')
                else:
                    password = request.POST['password']
                    pw_hash = bcrypt.hashpw(
                        password.encode(), bcrypt.gensalt()).decode()

                    user_to_update.password = pw_hash
                    user_to_update.save()
                    return redirect('/users/admin')
        else:
            return redirect('/users')
    else:
        return redirect('/login_form')


def update_profile(request):
    if 'userid' in request.session:
        request.session['which_form'] = request.POST['which_form']
        user = User.objects.get(id=request.session['userid'])
        if request.POST['which_form'] == 'update':
            errors = User.objects.update_user_validator(request.POST)
            if len(errors) > 0:
                for key, value in errors.items():
                    messages.error(request, value)
                return redirect(f'/users/edit')
            else:
                user.email = request.POST['email']
                user.first_name = request.POST['first_name']
                user.last_name = request.POST['last_name']
                user.save()
                return redirect(f'/users/show/{user.id}')
        elif request.POST['which_form'] == 'update_password':
            errors = User.objects.update_password_validator(request.POST)
            if len(errors) > 0:
                for key, value in errors.items():
                    messages.error(request, value)
                return redirect(f'/users/edit')
            else:
                password = request.POST['password']
                pw_hash = bcrypt.hashpw(
                    password.encode(), bcrypt.gensalt()).decode()
                user.password = pw_hash
                user.save()
                return redirect(f'/users/show/{user.id}')
        elif request.POST['which_form'] == 'update_desc':
            errors = User.objects.description_validator(request.POST)
            if len(errors) > 0:
                for key, value in errors.items():
                    messages.error(request, value)
                return redirect(f'/users/edit')
            else:
                user.description = request.POST['desc']
                user.save()
                return redirect(f'/users/show/{user.id}')
    else:
        return redirect('/login_form')


def delete_user(request, user_id):
    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        if user.admin:
            print('I am here')
            user_to_delete = User.objects.get(id=user_id)
            user_to_delete.delete()
            return redirect('/users/admin')
        else:
            return redirect('/users')
    else:
        return redirect('/login_form')


def post_message(request, user_id):
    if 'userid' in request.session:
        if len(request.POST['message']) > 0:
            Message.objects.create(message=request.POST['message'], posted_by=User.objects.get(
                id=request.session['userid']), posted_to=User.objects.get(id=user_id))
            return redirect(f'/users/show/{user_id}')
        else:
            return redirect(f'/users/show/{user_id}')
    else:
        return redirect('/login_form')


def post_reply(request, message_id, user_id):
    if 'userid' in request.session:
        if len(request.POST['reply']) > 0:
            Reply.objects.create(reply=request.POST['reply'], posted_by=User.objects.get(
                id=request.session['userid']), message=Message.objects.get(id=message_id))
            return redirect(f'/users/show/{user_id}')
        else:
            return redirect(f'/users/show/{user_id}')
    else:
        return redirect('/login_form')
