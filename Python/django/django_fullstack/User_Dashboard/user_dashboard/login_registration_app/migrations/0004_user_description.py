# Generated by Django 2.2.4 on 2022-02-14 11:11

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('login_registration_app', '0003_auto_20220213_1542'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='description',
            field=models.TextField(null=True),
        ),
    ]