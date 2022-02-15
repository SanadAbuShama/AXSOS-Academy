from django.contrib import messages
from django.shortcuts import redirect, render
from .models import Description, Course, Comment


def index(request):
    context = {
        'courses': Course.objects.all()
    }
    return render(request, 'index.html', context)


def add_course(request):
    errors = Course.objects.course_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/')
    else:
        desc = Description.objects.create(text=request.POST['desc'])
        Course.objects.create(name=request.POST['name'], description=desc)
        return redirect('/')


def confirm(request, course_id):

    context = {
        'course': Course.objects.get(id=course_id)
    }
    return render(request, 'confirm_delete.html', context)


def destroy(request, course_id):
    course = Course.objects.get(id=course_id)
    course.delete()
    return redirect('/')
