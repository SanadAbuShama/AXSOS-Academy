
from datetime import datetime

from django.db import models
from login_registration_app.models import User


class BookManager(models.Manager):
    def book_validator(self, postData):
        errors = {}

        if len(postData['title']) == 0:
            errors['title'] = "Book title is required!"

        if len(postData['desc']) < 5:
            errors['desc'] = 'Description should be at least 5 characters'
        return errors


class Book(models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField()
    uploaded_by = models.ForeignKey(
        User, related_name="books_uploaded", on_delete=models.CASCADE)
    users_who_like = models.ManyToManyField(User, related_name="liked_books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()

    def __str__(self):
        return f"<Book object: {self.title}>"
