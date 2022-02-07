
from datetime import datetime

from django.db import models


class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) == 0 and len(postData['network']) == 0:
            errors['required'] = 'Title and network are required!'
        elif len(postData['title']) < 2:
            errors['title'] = 'The title should be at lease 2 characters'
        elif len(postData['network']) < 3:
            errors['network'] = 'The network should be at lease 3 characters'
        elif len(postData['desc']) < 10 and len(postData['desc']) > 0:
            errors['desc'] = 'The description should be at lease 10 characters'
        elif postData['date'] > datetime.now().strftime('%Y-%m-%d'):
            errors['date'] = 'The date should be in the past!'
        if len(Show.objects.filter(title=postData['title'])) != 0:
            errors['repeated'] = 'This show already exists'
        return errors


class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField(null=True)
    description = models.TextField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()

    def __str__(self):
        return f"<Show object: {self.title}>"
