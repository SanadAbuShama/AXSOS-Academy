from django.shortcuts import redirect, render
from .models import Book, Author

# All books


def books(request):
    context = {
        'books': Book.objects.all()
    }
    return render(request, 'books.html', context)


# Single book details

def book_details(request, id):
    context = {
        'book': Book.objects.get(id=int(id)),
        'authors': Author.objects.all()
    }
    return render(request, 'book_details.html', context)


# Single author details

def author_details(request, id):
    context = {
        'author': Author.objects.get(id=int(id)),
        'books': Book.objects.all()
    }
    return render(request, 'author_details.html', context)

# All authors


def authors(request):
    context = {
        'authors': Author.objects.all()
    }
    return render(request, 'authors.html', context)


# Adding a book to the database

def new_book(request):
    Book.objects.create(
        title=request.POST['title'], desc=request.POST['description'])

    return redirect('/')


# Add an author to the database

def new_author(request):

    Author.objects.create(
        first_name=request.POST['first_name'], last_name=request.POST['last_name'], notes=request.POST['notes'])
    return redirect('/authors')

# Add an author to a book


def add_author(request, id):

    book = Book.objects.get(id=int(id))
    author = Author.objects.get(id=int(request.POST['author']))
    book.authors.add(author)
    return redirect(f'/books/{id}')


# Add a book to an author

def add_book(request, id):

    author = Author.objects.get(id=int(id))
    book = Book.objects.get(id=int(request.POST['book']))
    author.books.add(book)
    return redirect(f'/authors/{id}')
