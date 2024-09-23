function loadCSS(filename) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = filename;
    document.head.appendChild(link);
}

function createNavbar() {
    const navbar = document.createElement('nav');
    navbar.innerHTML = `
        <header class="transparent-header">
           <div class="container">
                <a href="" class="logo">
                 <img src="../images/logo.png" alt="OTP logo">
                 </a>
            <nav class="navbar">
                <ul class="nav-menu">
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">About</a></li>
                </ul>
            </nav>
                <a href="#" class="user-icon">
                <img src="../images/user-icon.jpg" alt="User Icon">
                </a>
            </div>
        </header>
    `;

    document.body.prepend(navbar);
}

document.addEventListener('DOMContentLoaded', () => {
    loadCSS('./css/Navbar.css');
    createNavbar();
});
