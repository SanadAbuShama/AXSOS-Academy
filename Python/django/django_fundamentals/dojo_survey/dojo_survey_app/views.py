

from xml.etree.ElementTree import Comment
from django.shortcuts import render


def index(request):
    return render(request, 'index.html')


def result(request):
    print(request.POST)
    context = {
        'name': request.POST['name'],
        'location': request.POST['location'],
        'favorite_language': request.POST['language'],
        'bootcamp_type': request.POST['bootcamp'],
        'comment': request.POST['comment']
    }
    return render(request, 'result.html', context)
