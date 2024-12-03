<%-- 
    Document   : ProductDetail
    Created on : Aug 19, 2024, 9:48:28 AM
    Author     : AnhVuNAV
--%>

<h1>${product.name}</h1>
<img src="${product.image_url}" alt="${product.name}">
<p>${product.description}</p>
<p>Price: ${product.price}</p>
<p>Available Quantity: ${product.quantity}</p>
<a href="cart?service=addToCart&productId=${product.id}">Add to Cart</a>
