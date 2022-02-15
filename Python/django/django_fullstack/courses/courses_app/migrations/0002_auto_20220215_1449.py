# Generated by Django 2.2.4 on 2022-02-15 12:49

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('courses_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='course',
            name='id',
            field=models.AutoField(auto_created=True, default=1, primary_key=True, serialize=False, verbose_name='ID'),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='course',
            name='description',
            field=models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to='courses_app.Description'),
        ),
    ]
