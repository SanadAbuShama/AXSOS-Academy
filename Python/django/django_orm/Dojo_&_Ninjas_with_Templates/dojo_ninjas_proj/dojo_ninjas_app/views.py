from django.shortcuts import redirect, render
from .models import Dojo, Ninja


def index(request):
    context = {
        'all_dojos': Dojo.objects.all()
    }
    return render(request, 'index.html', context)


def new(request):
    if request.POST['which_form'] == 'new_dojo':
        Dojo.objects.create(
            name=request.POST['name'], city=request.POST['city'], state=request.POST['state'])
    elif request.POST['which_form'] == 'new_ninja':
        Ninja.objects.create(
            first_name=request.POST['first_name'], last_name=request.POST['last_name'], dojo=Dojo.objects.get(id=int(request.POST['dojo'])))
    return redirect('/')


def delete(request):
    dojo_to_delete = Dojo.objects.get(id=int(request.POST['dojo_id']))
    for ninja in dojo_to_delete.ninjas.all():
        ninja.delete()
    dojo_to_delete.delete()
    return redirect('/')
