document.addEventListener('DOMContentLoaded', function () {
    const carListItems = [
        {
            model: 'BMW M5',
            year: 2021,
            price: 2000,
            image: '../images/bmw-m5.jpg',
            people: 4,
            fuel: 'Gasoline',
            consumption: '20.0L/100km',
            transmission: 'Automatic'
        },
        {
            model: 'BMW M3',
            year: 2019,
            price: 1500,
            image: '../images/m3.jpg',
            people: 4,
            fuel: 'Gasoline',
            consumption: '15.0L/100km',
            transmission: 'Automatic'
        },
        {
            model: 'Mercedes AMG GT S',
            year: 2020,
            price: 2300,
            image: '../images/mercedes-gts.jpg',
            people: 2,
            fuel: 'Gasoline',
            consumption: '19.5L/100km',
            transmission: 'Automatic'
        },
    ];
    
    const searchCriteria = JSON.parse(localStorage.getItem('carSearch'));

    if (searchCriteria) {
        const {carModel, monthlyPay, year} = searchCriteria;

        const resultsList = document.getElementById('results-list');

        // Filter cars based on search criteria
        const filteredCars = carListItems.filter(car => {
            const matchesModel = !carModel || car.model.toLowerCase().includes(carModel.toLowerCase());
            const matchesYear = !year || car.year >= parseInt(year);
            const matchesPrice = !monthlyPay || car.price <= parseInt(monthlyPay);
            return matchesModel && matchesYear && matchesPrice;
        });

        filteredCars.forEach(car => {
            const carItem = `
                <li>
                    <div class="featured-car-card">
                        <figure class="card-banner">
                            <img src="${car.image}" alt="${car.model}" loading="lazy" width="440" height="300" class="w-100">
                        </figure>
                        <div class="card-content">
                            <div class="card-title-wrapper">
                                <h3 class="h3 card-title">
                                    <a href="#">${car.model}</a>
                                </h3>
                                <data class="year" value="${car.year}">${car.year}</data>
                            </div>
                            <ul class="card-list">
                                <li class="card-list-item"><ion-icon name="people-outline"></ion-icon><span class="card-item-text">${car.people} People</span></li>
                                <li class="card-list-item"><ion-icon name="flash-outline"></ion-icon><span class="card-item-text">${car.fuel}</span></li>
                                <li class="card-list-item"><ion-icon name="speedometer-outline"></ion-icon><span class="card-item-text">${car.consumption}</span></li>
                                <li class="card-list-item"><ion-icon name="hardware-chip-outline"></ion-icon><span class="card-item-text">${car.transmission}</span></li>
                            </ul>
                            <div class="card-price-wrapper">
                                <p class="card-price"><strong>${car.price}€</strong> / month</p>
                                <button class="btn">Rent now</button>
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
    }
});