// Navbar.js
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
                <a href="/" class="logo">
                    <img src="../images/logo.png" alt="OTP logo">
                </a>
                <nav class="navbar">
                    <ul class="nav-menu">
                        <li><a href="/rental">Rent a car</a></li>
                    </ul>
                </nav>
                <div class="user-icon" id="profileIcon">
                   <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                     <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm4-3a4 4 0 1 1-8 0 4 4 0 0 1 8 0zM8 9a7 7 0 0 0-5.468 2.625C1.92 13.068 2.805 14 4 14h8c1.195 0 2.08-.932 1.468-2.375A7 7 0 0 0 8 9zm-6.533 4.022A8 8 0 0 1 8 8a8 8 0 0 1 6.533 5.022C14.89 14.634 13.418 16 12 16H4c-1.418 0-2.89-1.366-2.533-2.978z"/>
                    </svg>  
                </div>
            </div>
        </header>
    `;

    document.body.prepend(navbar);

    const profileIcon = document.getElementById('profileIcon');
    if (profileIcon) {
        profileIcon.addEventListener('click', () => {
            window.location.href = '/profile';
        });
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadCSS('./css/Navbar.css');
    createNavbar();
});
