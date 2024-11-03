function loadCSS(filename) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = filename;
    document.head.appendChild(link);
}

function createFooter(translations) {
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
                        ${translations['footer.brand.text'] || 'Get the best experience with our supercars in Finland Metropolia. We are here to help you to get the best experience.'}
                    </p>
                </div>
                <ul class="footer-list">
                    <li><p class="footer-list-title">${translations['footer.company.title'] || 'Company'}</p></li>
                    <li><a href="#" class="footer-link">${translations['footer.company.about'] || 'About us'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.company.pricing'] || 'Pricing plans'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.company.blog'] || 'Our blog'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.company.contacts'] || 'Contacts'}</a></li>
                </ul>
                <ul class="footer-list">
                    <li><p class="footer-list-title">${translations['footer.support.title'] || 'Support'}</p></li>
                    <li><a href="#" class="footer-link">${translations['footer.support.help'] || 'Help center'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.support.question'] || 'Ask a question'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.support.privacy'] || 'Privacy policy'}</a></li>
                    <li><a href="#" class="footer-link">${translations['footer.support.terms'] || 'Terms & conditions'}</a></li>
                </ul>
            </div>
        </div>
    `;

    document.body.appendChild(footer);
}

async function fetchTranslations(languageCode, countryCode, page) {
    try {
        const response = await fetch(`/api/localization/messages?lang=${languageCode}&country=${countryCode}&page=${page}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return await response.json();
    } catch (error) {
        console.error('Failed to fetch translations:', error);
        return null;
    }
}

document.addEventListener('DOMContentLoaded', async () => {
    loadCSS('./css/Footer.css');
    const languageCode = localStorage.getItem('selectedLanguageCode') || 'en';
    const countryCode = localStorage.getItem('selectedCountryCode') || 'UK';
    const page = 'footer';

    const translations = await fetchTranslations(languageCode, countryCode, page);
    createFooter(translations || {});
});