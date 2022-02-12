from django.shortcuts import redirect, render
from books_reviews_app.models import Book, Review
from login_registration_app.models import User
from django.contrib import messages


def books(request):
    if 'userid' in request.session:
        user = User.objects.get(id=request.session['userid'])
        name = user.name.split()[0]
        reviews = Review.objects.all().order_by('-created_at')[:3]

        context = {
            'reviews': reviews,
            'name': name,
            'other_books': Book.objects.all().order_by('-created_at')[3:]
        }
        return render(request, 'books.html', context)
    else:
        return redirect('/')


def add_book(request):
    return render(request, 'add_book.html')


def create_book(request):
    errors = Book.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
            return redirect('/books/add')

    user = User.objects.get(id=request.session['userid'])
    if user:
        if len(request.POST['new_author']) == 0:
            author = request.POST['author']
        else:
            author = request.POST['new_author']

        book = Book.objects.create(
            title=request.POST['title'], author=author, uploaded_by=user)
        book.users_who_reviewed.add(user)

        Review.objects.create(
            review=request.POST['review'], rating=request.POST['rating'], posted_by=user, book_reviewed=book)
        return redirect(f'/books/{book.id}')

    return redirect('/')


def add_review(request, book_id):
    user = User.objects.get(id=request.session['userid'])
    if user:
        book = Book.objects.get(id=book_id)
        Review.objects.create(
            review=request.POST['review'], rating=request.POST['rating'], posted_by=user, book_reviewed=book)
        return redirect(f'/books/{book_id}')


def delete_review(request, review_id, book_id):
    review = Review.objects.get(id=review_id)
    user = User.objects.get(id=request.session['userid'])
    book = Book.objects.get(id=book_id)
    user.books_reviewed.remove(book)
    if review.posted_by.id == request.session['userid']:
        review.delete()
        return redirect(f'/books/{book_id}')
    else:
        return redirect(f'/books/{book_id}')


def book_details(request, book_id):
    context = {
        'book': Book.objects.get(id=book_id)
    }
    return render(request, 'book_details.html', context)
