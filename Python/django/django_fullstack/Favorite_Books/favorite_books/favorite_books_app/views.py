from multiprocessing import context
from django.shortcuts import render, redirect
from favorite_books_app.models import Book
from django.contrib import messages
from login_registration_app.models import User


def books(request):
    context = {
        'books': Book.objects.all(),
        'logged_user': User.objects.get(id=request.session['userid'])
    }
    return render(request, 'profile.html', context)


def add(request):
    errors = Book.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    else:
        user_id = request.session['userid']
        user = User.objects.get(id=user_id)
        book = Book.objects.create(
            title=request.POST['title'], description=request.POST['desc'], uploaded_by=user)
        book.users_who_like.add(user)

        return redirect('/books')


def favorite(request, book_id):
    user = User.objects.get(id=request.session['userid'])
    book = Book.objects.get(id=book_id)
    user.liked_books.add(book)
    return redirect('/books')


def details(request, book_id):
    book = Book.objects.get(id=book_id)
    user = User.objects.get(id=request.session['userid'])
    context = {
        'book': book,
        'logged_user': user
    }
    if book.uploaded_by.id == request.session['userid']:
        return render(request, 'book_owner.html', context)
    else:
        return render(request, 'book_visitor.html', context)


def update(request, book_id):
    errors = Book.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/books/{book_id}')
    else:
        book = Book.objects.get(id=book_id)
        book.title = request.POST['title']
        book.description = request.POST['desc']
        book.save()
        return redirect('/books')


def delete(request, book_id):
    book = Book.objects.get(id=book_id)
    book.delete()
    return redirect('/books')


def unfavorite(request, book_id):
    user = User.objects.get(id=request.session['userid'])
    book = Book.objects.get(id=book_id)
    book.users_who_like.remove(user)
    return redirect('/books')


def favorites(request):
    context = {
        'logged_user': User.objects.get(id=request.session['userid'])
    }
    return render(request, 'favorite_books.html', context)
