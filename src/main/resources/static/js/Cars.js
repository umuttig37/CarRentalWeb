document.addEventListener('DOMContentLoaded', async function () {
    const carList = document.getElementById('car-list');

    // Fetch car data from the backend
    try {
        const response = await fetch('/api/vehicle');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        if (cars.length === 0) {
            carList.innerHTML = '<p>No cars available at the moment.</p>';
            return;
        }
        const cars = await response.json();

        // Populate the list with car data
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
                                <span class="card-item-text">${car.vehiclePeople} People</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="flash-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleFuel}</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="speedometer-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleConsumption}</span>
                            </li>
                            <li class="card-list-item">
                                <ion-icon name="hardware-chip-outline"></ion-icon>
                                <span class="card-item-text">${car.vehicleTransmission}</span>
                            </li>
                        </ul>
                        <div class="card-price-wrapper">
                            <p class="card-price"><strong>${car.vehiclePrice}€</strong> / month</p>
                        <button class="rent-now-btn" onclick="openRentPage(car)">Rent Now</button>
                        </div>
                    </div>
                </div>
            `;
            carList.appendChild(li);
        });
    } catch (error) {
        console.error('There was a problem fetching the car data:', error);
        carList.innerHTML = '<p>Sorry, we couldn’t load the car data. Please try again later.</p>';
    }
});
