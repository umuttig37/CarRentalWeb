function loadCSS(filename) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = filename;
    document.head.appendChild(link);
}

function createFooter() {
    const footer = document.createElement('footer');
    footer.classList.add('footer');

    footer.innerHTML = `
        <div class="container">
            <div class="footer-top">
                <div class="footer-brand">
                    <a href="#" class="logo">
                        <img src="../images/logo.png" alt="OTP logo">
                    </a>
                    <p class="footer-text">
                        Get the best experience with our supercars in Finland Metropolia. We are here to help you to get the
                        best experience.
                    </p>
                </div>
                <ul class="footer-list">
                    <li><p class="footer-list-title">Company</p></li>
                    <li><a href="#" class="footer-link">About us</a></li>
                    <li><a href="#" class="footer-link">Pricing plans</a></li>
                    <li><a href="#" class="footer-link">Our blog</a></li>
                    <li><a href="#" class="footer-link">Contacts</a></li>
                </ul>
                <ul class="footer-list">
                    <li><p class="footer-list-title">Support</p></li>
                    <li><a href="#" class="footer-link">Help center</a></li>
                    <li><a href="#" class="footer-link">Ask a question</a></li>
                    <li><a href="#" class="footer-link">Privacy policy</a></li>
                    <li><a href="#" class="footer-link">Terms & conditions</a></li>
                </ul>
            </div>
        </div>
    `;

    document.body.appendChild(footer);
}

document.addEventListener('DOMContentLoaded', () => {
    loadCSS('./css/Footer.css');
    createFooter();
});
