from django.urls import path
from . import views


urlpatterns = [
    path('', views.home),
    path('register_form', views.register_form),
    path('login_form', views.login_form),
    path('register', views.register),
    path('login', views.login),
    path('logout', views.logout),
    

]
