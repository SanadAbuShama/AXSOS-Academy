from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('courses/add', views.add_course),
    path('courses/confirm/<course_id>', views.confirm),
    path('courses/destroy/<course_id>', views.destroy),
]
