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

    const style = document.createElement('style');
    style.textContent = `
        nav {
            background-color: #333;
            padding: 1rem;
            position: fixed;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1000;
        }
        .navbar-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
        }
        .logo {
            color: white;
            font-size: 1.5rem;
            text-decoration: none;
        }
        .nav-links {
            list-style: none;
            display: flex;
            gap: 1rem;
        }
        .nav-links li a {
            color: white;
            text-decoration: none;
        }
        .nav-links li a:hover {
            text-decoration: underline;
        }
    `;

    document.head.appendChild(style);
    document.body.prepend(navbar);
}

document.addEventListener('DOMContentLoaded', createNavbar);
