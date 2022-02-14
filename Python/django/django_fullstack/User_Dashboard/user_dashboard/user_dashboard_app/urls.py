from django.urls import path
from . import views


urlpatterns = [
    path('', views.user_dashboard),
    path('show/<user_id>', views.show_profile),
    path('edit', views.edit_profile),
    path('post_message/<user_id>', views.post_message),
    path('post_reply/<message_id>/<user_id>', views.post_reply),
    path('update_profile', views.update_profile),
    path('admin', views.admin_dashboard),
    path('new', views.new_user),
    path('create', views.create_user),
    path('edit/<user_id>', views.edit_user),
    path('update/<user_id>', views.update_user),
    path('delete/<user_id>', views.delete_user),
]
