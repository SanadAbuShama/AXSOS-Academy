from django.urls import path
from . import views


urlpatterns = [
    path('', views.books),
    path('add', views.add_book),
    path('create', views.create_book),
    path('<book_id>', views.book_details),
    path('<book_id>/add_review', views.add_review),
    path('delete_review/<review_id>/<book_id>', views.delete_review),
]
