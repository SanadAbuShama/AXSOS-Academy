from django.urls import path
from . import views
urlpatterns = [
    path('', views.books),
    path('authors', views.authors),
    path('new/book', views.new_book),
    path('new/author', views.new_author),
    path('add/book/<id>', views.add_book),
    path('add/author/<id>', views.add_author),
    path('books/<id>', views.book_details),
    path('authors/<id>', views.author_details),

]
