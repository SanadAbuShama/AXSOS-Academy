# Generated by Django 2.2.4 on 2022-02-06 18:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tv_shows_app', '0002_show_description'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='release_date',
            field=models.DateField(null=True),
        ),
    ]
