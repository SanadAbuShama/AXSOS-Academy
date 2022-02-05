from statistics import mode
from django.db import models

# Create your models here.
from django.db import models

from django.db import models


class Dojo(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=2)
    desc = models.TextField(null=True)

    def __str__(self):
        return f"<Dojo object: {self.name}>"


class Ninja(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    dojo = models.ForeignKey(
        Dojo, related_name="ninjas", on_delete=models.CASCADE)

    def __str__(self):
        return f"<Ninja object: {self.first_name} {self.last_name}>"
