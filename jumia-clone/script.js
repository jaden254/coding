// Jumia Clone JavaScript

// Sample Products Data
const products = [
    { id: 1, name: 'Smartphone', price: 299.99, image: 'https://via.placeholder.com/300x300', category: 'Electronics', description: 'Latest smartphone with advanced features.' },
    { id: 2, name: 'Laptop', price: 899.99, image: 'https://via.placeholder.com/300x300', category: 'Electronics', description: 'Powerful laptop for work and gaming.' },
    { id: 3, name: 'T-Shirt', price: 19.99, image: 'https://via.placeholder.com/300x300', category: 'Fashion', description: 'Comfortable cotton t-shirt.' },
    { id: 4, name: 'Sneakers', price: 79.99, image: 'https://via.placeholder.com/300x300', category: 'Fashion', description: 'Stylish sneakers for everyday wear.' },
    { id: 5, name: 'Blender', price: 49.99, image: 'https://via.placeholder.com/300x300', category: 'Home & Garden', description: 'High-speed blender for smoothies.' },
    { id: 6, name: 'Garden Hose', price: 29.99, image: 'https://via.placeholder.com/300x300', category: 'Home & Garden', description: 'Durable garden hose.' },
    { id: 7, name: 'Basketball', price: 24.99, image: 'https://via.placeholder.com/300x300', category: 'Sports', description: 'Official size basketball.' },
    { id: 8, name: 'Dumbbells', price: 39.99, image: 'https://via.placeholder.com/300x300', category: 'Sports', description: 'Set of adjustable dumbbells.' }
];

// Cart Management
let cart = JSON.parse(localStorage.getItem('cart')) || [];

// Update cart count in navigation
function updateCartCount() {
    const cartCount = document.getElementById('cart-count');
    if (cartCount) {
        cartCount.textContent = cart.reduce((total, item) => total + item.quantity, 0);
    }
}

// Add item to cart
function addToCart(productId) {
    const product = products.find(p => p.id === productId);
    if (product) {
        const existingItem = cart.find(item => item.id === productId);
        if (existingItem) {
            existingItem.quantity += 1;
        } else {
            cart.push({ ...product, quantity: 1 });
        }
        saveCart();
        updateCartCount();
        alert('Item added to cart!');
    }
}

// Remove item from cart
function removeFromCart(productId) {
    cart = cart.filter(item => item.id !== productId);
    saveCart();
    updateCartCount();
    displayCart();
}

// Update item quantity in cart
function updateQuantity(productId, newQuantity) {
    const item = cart.find(item => item.id === productId);
    if (item && newQuantity > 0) {
        item.quantity = newQuantity;
        saveCart();
        displayCart();
    }
}

// Save cart to localStorage
function saveCart() {
    localStorage.setItem('cart', JSON.stringify(cart));
}

// Calculate cart total
function getCartTotal() {
    return cart.reduce((total, item) => total + (item.price * item.quantity), 0).toFixed(2);
}

// Display featured products on home page
function displayFeaturedProducts() {
    const container = document.getElementById('featured-products');
    if (container) {
        container.innerHTML = products.slice(0, 4).map(product => `
            <div class="col-md-3">
                <div class="product-card">
                    <img src="${product.image}" alt="${product.name}">
                    <h5>${product.name}</h5>
                    <p class="price">$${product.price}</p>
                    <button class="btn btn-primary" onclick="addToCart(${product.id})">Add to Cart</button>
                </div>
            </div>
        `).join('');
    }
}

// Display all products on products page
function displayProducts(filter = '') {
    const container = document.getElementById('products-container');
    if (container) {
        let filteredProducts = products;
        if (filter) {
            filteredProducts = products.filter(product => 
                product.name.toLowerCase().includes(filter.toLowerCase()) ||
                product.category.toLowerCase().includes(filter.toLowerCase())
            );
        }
        container.innerHTML = filteredProducts.map(product => `
            <div class="col-md-4">
                <div class="product-card">
                    <img src="${product.image}" alt="${product.name}">
                    <h5><a href="product-details.html?id=${product.id}">${product.name}</a></h5>
                    <p class="price">$${product.price}</p>
                    <button class="btn btn-primary" onclick="addToCart(${product.id})">Add to Cart</button>
                </div>
            </div>
        `).join('');
    }
}

// Display product details
function displayProductDetails() {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = parseInt(urlParams.get('id'));
    const product = products.find(p => p.id === productId);
    
    if (product) {
        document.getElementById('product-image').src = product.image;
        document.getElementById('product-name').textContent = product.name;
        document.getElementById('product-price').textContent = `$${product.price}`;
        document.getElementById('product-description').textContent = product.description;
        document.getElementById('add-to-cart-btn').onclick = () => addToCart(product.id);
    }
}

// Display cart items
function displayCart() {
    const container = document.getElementById('cart-items');
    const totalElement = document.getElementById('cart-total');
    
    if (container) {
        if (cart.length === 0) {
            container.innerHTML = '<p>Your cart is empty.</p>';
        } else {
            container.innerHTML = cart.map(item => `
                <div class="cart-item row">
                    <div class="col-md-2">
                        <img src="${item.image}" alt="${item.name}">
                    </div>
                    <div class="col-md-4">
                        <h5>${item.name}</h5>
                    </div>
                    <div class="col-md-2">
                        <input type="number" class="form-control" value="${item.quantity}" min="1" onchange="updateQuantity(${item.id}, this.value)">
                    </div>
                    <div class="col-md-2">
                        <p class="price">$${(item.price * item.quantity).toFixed(2)}</p>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-danger" onclick="removeFromCart(${item.id})">Remove</button>
                    </div>
                </div>
            `).join('');
        }
    }
    
    if (totalElement) {
        totalElement.textContent = `$${getCartTotal()}`;
    }
}

// Search functionality
function searchProducts() {
    const searchTerm = document.getElementById('search-input').value;
    displayProducts(searchTerm);
}

// Form validation
function validateForm(formId) {
    const form = document.getElementById(formId);
    const inputs = form.querySelectorAll('input[required]');
    let isValid = true;
    
    inputs.forEach(input => {
        if (!input.value.trim()) {
            input.classList.add('is-invalid');
            isValid = false;
        } else {
            input.classList.remove('is-invalid');
        }
    });
    
    // Special validation for register form
    if (formId === 'register-form') {
        const password = document.getElementById('registerPassword').value;
        const confirmPassword = document.getElementById('registerConfirmPassword').value;
        if (password !== confirmPassword) {
            document.getElementById('registerConfirmPassword').classList.add('is-invalid');
            isValid = false;
            alert('Passwords do not match.');
        } else {
            document.getElementById('registerConfirmPassword').classList.remove('is-invalid');
        }
    }
    
    return isValid;
}

// Initialize on page load
document.addEventListener('DOMContentLoaded', function() {
    updateCartCount();
    displayFeaturedProducts();
    displayProducts();
    displayProductDetails();
    displayCart();
    
    // Search event listener
    const searchInput = document.getElementById('search-input');
    if (searchInput) {
        searchInput.addEventListener('input', searchProducts);
    }
    
    // Checkout form validation and submission
    const checkoutForm = document.getElementById('checkout-form');
    if (checkoutForm) {
        checkoutForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateForm('checkout-form')) {
                // Simulate order placement
                cart = [];
                saveCart();
                updateCartCount();
                alert('Order placed successfully!');
                window.location.href = 'index.html';
            }
        });
    }
    
    // Login form submission
    const loginForm = document.getElementById('login-form');
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateForm('login-form')) {
                // Simulate login (in a real app, this would authenticate with a server)
                alert('Login successful!');
                // Redirect to home or user dashboard
            }
        });
    }
    
    // Register form submission
    const registerForm = document.getElementById('register-form');
    if (registerForm) {
        registerForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateForm('register-form')) {
                // Simulate registration (in a real app, this would send data to a server)
                alert('Registration successful! Please login.');
                window.location.href = 'login.html';
            }
        });
    }
});