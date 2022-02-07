from django.urls import path
from . import views
urlpatterns = [
    path('', views.home),
    path('shows', views.all_shows),
    path('shows/new', views.new_show),
    path('shows/create', views.create_show),
    path('shows/<id>', views.show_details),
    path('shows/<id>/edit', views.edit_show),
    path('shows/<id>/update', views.update_show),
    path('shows/<id>/destroy', views.destroy_show),
]
