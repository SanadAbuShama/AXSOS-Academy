# Generated by Django 2.2.4 on 2022-02-11 15:26

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('login_registration_app', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='user',
            old_name='first_name',
            new_name='alias',
        ),
        migrations.RenameField(
            model_name='user',
            old_name='last_name',
            new_name='name',
        ),
    ]
