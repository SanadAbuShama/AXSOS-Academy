
from django.shortcuts import redirect, render
from .models import Show

from django.contrib import messages


def home(request):
    return redirect('/shows')


def new_show(request):
    return render(request, 'new_show.html')


def create_show(request):
    errors = Show.objects.basic_validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/shows/new')

    else:
        show = Show.objects.create(
            title=request.POST['title'], network=request.POST['network'], release_date=request.POST['date'], description=request.POST['desc'])

        return redirect(f'/shows/{show.id}')


def show_details(request, id):
    context = {
        'show': Show.objects.get(id=int(id))
    }
    return render(request, 'show_details.html', context)


def all_shows(request):
    context = {
        'shows': Show.objects.all()
    }
    return render(request, 'shows.html', context)


def edit_show(request, id):
    show = Show.objects.get(id=int(id))
    print(show.release_date)
    context = {
        'show': show,
        'release_date': show.release_date.isoformat()
    }
    return render(request, 'edit_show.html', context)


def update_show(request, id):
    errors = Show.objects.basic_validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect(f'/shows/{id}/edit')
    else:
        show = Show.objects.get(id=int(id))
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.description = request.POST['desc']
        show.release_date = request.POST['date']
        show.save()
        return redirect(f'/shows/{id}')


def destroy_show(request, id):
    show = Show.objects.get(id=int(id))
    show.delete()
    return redirect('/shows')
