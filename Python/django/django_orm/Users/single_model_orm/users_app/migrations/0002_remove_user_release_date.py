# Generated by Django 2.2.4 on 2022-02-05 12:42

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('users_app', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='user',
            name='release_date',
        ),
    ]
