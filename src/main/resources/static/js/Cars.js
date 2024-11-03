document.addEventListener('DOMContentLoaded', async function () {
    const carList = document.getElementById('car-list');

    // Fetch car data from the backend
    try {
        const response = await fetch('/api/vehicle');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const cars = await response.json();

        // Fetch translations for the selected language
        const languageCode = localStorage.getItem('selectedLanguageCode') || 'en';
        const countryCode = localStorage.getItem('selectedCountryCode') || 'UK';
        const page = 'car';
        const translations = await fetchTranslations(languageCode, countryCode, page);
        cars.forEach(car => {
            const li = document.createElement('li');
            li.innerHTML = `
                <div class="featured-car-card">
                    <figure class="card-banner">
                        <img src="${car.image}" alt="${car.vehicleTitle}" loading="lazy" width="440" height="300" class="w-100">
                    </figure>
                    <div class="card-content">
                        <div class="card-title-wrapper">
                            <h3 class="h3 card-title">
                                <a href="#">${car.vehicleTitle}</a>
                            </h3>
                            <data class="year" value="${car.vehicleYear}">${car.vehicleYear}</data>
                        </div>
                        <ul class="card-list">
                            <li class="card-list-item">
                                <ion-icon name="people-outline"></ion-icon>
                                <span class="card-item-text">${car.vehiclePeople} ${translations['car.people']}</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="flash-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleFuel} ${translations['car.fuel']}</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="speedometer-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleConsumption} ${translations['car.consumption']}</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="hardware-chip-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleTransmission} ${translations['car.transmission']}</span>
                            </li>
                        </ul>
                        <div class="card-price-wrapper">
                            <p class="card-price"><strong>${car.vehiclePrice}€</strong> ${translations['car.price']}</p>
                            <a href="renting?carReg=${car.vehicleReg}" class="rent-now-btn">${translations['car.rent.now']}</a>
                        </div>
                    </div>
                </div>
            `;
            carList.appendChild(li);
        });
    } catch (error) {
        console.error('There was a problem fetching the car data:', error);
        carList.innerHTML = `<p>${translations['car-list.error']}</p>`;
    }
});

// Function to fetch translations dynamically based on language code
async function fetchTranslations(languageCode, countryCode, page) {
    try {
        const response = await fetch(`/api/localization/messages?lang=${languageCode}&country=${countryCode}&page=${page}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return await response.json();
    } catch (error) {
        console.error('Failed to fetch translations:', error);s
    }
}
