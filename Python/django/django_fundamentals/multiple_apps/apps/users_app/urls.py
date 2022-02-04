
from django.urls import path
from . import views
from ..blogs_app import views as blogs_app_views

urlpatterns = [
    path('', blogs_app_views.index),
    path('register', views.register),
    path('login', views.login),
    path('users', views.index),
    path('users/new', views.register),
]
