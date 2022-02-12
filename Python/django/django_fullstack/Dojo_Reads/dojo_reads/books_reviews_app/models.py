from django.db import models
from login_registration_app.models import User


class BookManager(models.Manager):
    def book_validator(self, postData):
        errors = {}

        if len(postData['title']) < 2:
            errors['title'] = 'Title should be at least 2 characters'

        if len(postData['review']) < 10:
            errors['review'] = 'Review should be at least 10 characters'

        return errors


class Book(models.Model):
    title = models.CharField(max_length=255)
    author = models.CharField(max_length=255)
    uploaded_by = models.ForeignKey(
        User, related_name="books_uploaded", on_delete=models.CASCADE)
    users_who_reviewed = models.ManyToManyField(
        User, related_name="books_reviewed")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()

    def __str__(self):
        return f"<Book object: {self.title}>"


class Review(models.Model):
    review = models.TextField()
    rating = models.IntegerField()
    posted_by = models.ForeignKey(
        User, related_name="reviews", on_delete=models.CASCADE)
    book_reviewed = models.ForeignKey(
        Book, related_name="reviews", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"<Review object: {self.review}>"
