function loadCSS(filename) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = filename;
    document.head.appendChild(link);
}

function createNavbar() {
    const navbar = document.createElement('nav');
    navbar.innerHTML = `
        <div class="navbar-container">
            <a href="#" class="logo">CarRental</a>
            <ul class="nav-links">
                <li><a href="#home">Home</a></li>
                <li><a href="#vehicles">Vehicles</a></li>
                <li><a href="#how-it-works">How It Works</a></li>
                <li><a href="#join">Join Now</a></li>
            </ul>
        </div>
    `;

    document.body.prepend(navbar);
}

document.addEventListener('DOMContentLoaded', () => {
    loadCSS('./css/Navbar.css');
    createNavbar();
});
