document.addEventListener('DOMContentLoaded', async function () {
    const searchCriteria = JSON.parse(localStorage.getItem('carSearch'));

    if (searchCriteria) {
        const { carModel, monthlyPay, year } = searchCriteria;
        const resultsList = document.getElementById('results-list');

        const selectedLanguageCode = localStorage.getItem('selectedLanguageCode') || 'en';
        const selectedCountryCode = localStorage.getItem('selectedCountryCode') || 'UK';
        const page = 'search-results';
        const translations = await fetchTranslations(selectedLanguageCode, selectedCountryCode, page);
        try {
            const response = await fetch('/api/vehicle');
            if (!response.ok) {
                throw new Error('Failed to fetch vehicle data.');
            }
            const cars = await response.json();

            const filteredCars = cars.filter(car => {
                const matchesModel = !carModel || car.vehicleTitle.toLowerCase().includes(carModel.toLowerCase());
                const matchesYear = !year || car.vehicleYear >= parseInt(year);
                const matchesPrice = !monthlyPay || car.vehiclePrice <= parseInt(monthlyPay);
                return matchesModel && matchesYear && matchesPrice;
            });

            // Display the filtered cars
            filteredCars.forEach(car => {
                const carItem = `
                    <li>
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
                                    <li class="card-list-item"><ion-icon name="people-outline"></ion-icon><span class="card-item-text">${car.vehiclePeople} ${translations['search-results.people']}</span></li>
                                    <li class="card-list-item"><ion-icon name="flash-outline"></ion-icon><span class="card-item-text">${car.vehicleFuel}</span></li>
                                    <li class="card-list-item"><ion-icon name="speedometer-outline"></ion-icon><span class="card-item-text">${car.vehicleConsumption} L/100km</span></li>
                                    <li class="card-list-item"><ion-icon name="hardware-chip-outline"></ion-icon><span class="card-item-text">${car.vehicleTransmission}</span></li>
                                </ul>
                                <div class="card-price-wrapper">
                                    <p class="card-price"><strong>${car.vehiclePrice}€</strong> ${translations['search-results.price']}</p>
                                    <a href="renting?carReg=${car.vehicleReg}" class="btn">${translations['search-results.rent.now']}</a>
                                </div>
                            </div>
                        </div>
                    </li>
                `;
                resultsList.insertAdjacentHTML('beforeend', carItem);
            });

            if (filteredCars.length === 0) {
                resultsList.innerHTML = '<p>No cars match your search criteria.</p>';
            }
        } catch (error) {
            console.error('Error fetching cars:', error);
            resultsList.innerHTML = '<p>Sorry, we couldn’t load the car data. Please try again later.</p>';
        }
    }});
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