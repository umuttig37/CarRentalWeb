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
                <div class="Dropdown">
                    <button class="dropdown-button">
                        <img src="../Languages/UK-Flag.png" class="flag-icon">
                    </button>
                    <ul class="dropdown-content">
                        <li data-value="en" data-flag="../Languages/UK-Flag.png">
                            <img src="../Languages/UK-Flag.png" alt="English" class="flag-icon">
                            <span>English</span>
                        </li>
                        <li data-value="fi" data-flag="../Languages/Finland-Flag.png">
                            <img src="../Languages/Finland-Flag.png" alt="Finnish" class="flag-icon">
                            <span>Finnish</span>
                        </li>
                        <li data-value="fr" data-flag="../Languages/France-Flag.png">
                            <img src="../Languages/France-Flag.png" alt="French" class="flag-icon">
                            <span>French</span>
                        </li>
                        <li data-value="ja" data-flag="../Languages/Japan-Flag.png">
                            <img src="../Languages/Japan-Flag.png" alt="Japanese" class="flag-icon">
                            <span>Japanese</span>
                        </li>
                        <li data-value="zh" data-flag="../Languages/ChinaFlag.png">
                            <img src="../Languages/ChinaFlag.png" alt="Chinese" class="flag-icon">
                            <span>Chinese</span>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
    `;

    document.body.prepend(navbar);


    const profileIcon = document.getElementById('profileIcon');
    profileIcon.addEventListener('click', () => {
        const isLoggedIn = !!localStorage.getItem('token');
        if (isLoggedIn) {
            window.location.href = '/profile';
        } else {
            window.location.href = '/login';
        }
    });

    // Retrieve saved flag and country code from localStorage
    const savedFlag = localStorage.getItem('selectedFlag') || '../Languages/UK-Flag.png'; // Default to UK flag
    const savedCountryCode = localStorage.getItem('selectedCountryCode') || 'en'; // Default to English

    // Set the default flag and language in the dropdown button
    const dropdownButton = document.querySelector('.dropdown-button');
    dropdownButton.innerHTML = `<img src="${savedFlag}" class="flag-icon">`;

    const dropdownContent = document.querySelector('.dropdown-content');

    dropdownButton.addEventListener('click', () => {
        dropdownContent.classList.toggle('show'); // Toggle show class on click
    });

    const dropdownItems = document.querySelectorAll('.dropdown-content li');
    dropdownItems.forEach(item => {
        item.addEventListener('click', () => {
            const selectedFlag = item.querySelector('img').src;
            const selectedLanguage = item.querySelector('span').textContent;
            const selectedCountryCode = item.getAttribute('data-value');

            // Update button content with selected option
            dropdownButton.innerHTML = `<img src="${selectedFlag}" class="flag-icon">`;

            // Save the selected flag and country code to localStorage
            localStorage.setItem('selectedFlag', selectedFlag);
            localStorage.setItem('selectedCountryCode', selectedCountryCode);
            dropdownContent.classList.remove('show');
        });
    });

    document.addEventListener('click', (event) => {
        if (!dropdownButton.contains(event.target) && !dropdownContent.contains(event.target)) {
            dropdownContent.classList.remove('show');
        }
    });
}

document.addEventListener('DOMContentLoaded', () => {
    loadCSS('./css/Navbar.css');
    createNavbar();
});