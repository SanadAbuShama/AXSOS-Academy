
import re

import bcrypt
from django.db import models


class UserManager(models.Manager):
    def register_validator(self, postData):
        errors = {}
        user = User.objects.filter(email=postData['email'])

        EMAIL_REGEX = re.compile(
            r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

        if len(postData['name']) < 2:
            errors['name'] = 'Name should be at least 2 characters'

        if len(postData['alias']) < 2:
            errors['alias'] = 'Alias should be at least 2 characters'

        if len(postData['email']) == 0:
            errors['email'] = "Invalid email address!"
        elif not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "Invalid email address!"

        if len(postData['password']) < 8:
            errors['password'] = 'Password should be at least 8 characters'

        if postData['password'] != postData['confirm_password']:
            errors['confirm_password'] = 'Passwords do not match'

        if user:
            errors['user'] = 'A user with this email already exists'
        return errors

    def login_validator(self, postData):
        errors = {}

        user = User.objects.filter(email=postData['email'])

        EMAIL_REGEX = re.compile(
            r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

        if len(postData['email']) == 0:
            errors['email'] = "Please enter an email address!"
        elif not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "Invalid email or password"

        if len(postData['password']) < 8:
            errors['password'] = 'Password should be at least 8 characters'

        if user:
            if not bcrypt.checkpw(postData['password'].encode(), user[0].password.encode()):
                errors['auth'] = 'Invalid email or password'
        elif not user:
            errors['user'] = 'No account associated with this email'

        return errors


class User(models.Model):
    name = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

    def __str__(self):
        return f"<User object: {self.name}>"