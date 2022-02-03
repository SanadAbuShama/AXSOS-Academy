from django.urls import path
from . import views
urlpatterns = [
    path('', views.welcome),
    path('player/play', views.index),
    path('<str:location>', views.process_money),
    path('gold/reset', views.reset),
    path('player/start', views.start)
]
