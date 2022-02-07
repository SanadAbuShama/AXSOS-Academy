
from django.shortcuts import redirect, render
from .models import Order, Product


def index(request):
    if not 'total_quantity' in request.session:
        request.session['total_quantity'] = 0
    if not 'total_price' in request.session:
        request.session['total_price'] = 0
    context = {
        "all_products": Product.objects.all()
    }
    return render(request, "store/index.html", context)


def checkout(request):
    quantity_from_form = int(request.POST["quantity"])
    product = Product.objects.get(id=int(request.POST["product_id"]))
    price_from_form = float(product.price)
    total_charge = quantity_from_form * price_from_form
    print("Charging credit card...")
    request.session['total_quantity'] += quantity_from_form
    request.session['total_price'] += total_charge
    request.session['total'] = total_charge

    Order.objects.create(quantity_ordered=quantity_from_form,
                         total_price=total_charge)
    return redirect('/thankyou')


def thank_you(request):
    return render(request, "store/checkout.html")
