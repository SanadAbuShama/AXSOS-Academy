from django.urls import path
from . import views


urlpatterns = [

    path('', views.books),
    path('add', views.add),
    path('favorites', views.favorites),
    path('<book_id>', views.details),
    path('favorite/<book_id>', views.favorite),
    path('update/<book_id>', views.update),
    path('delete/<book_id>', views.delete),
    path('unfavorite/<book_id>', views.unfavorite),

    #path('post_message/<userid>', views.post_message),
    #path('post_comment/<message_id>/<userid>', views.post_comment),
    #path('delete_message/<message_id>', views.delete_message)
]
