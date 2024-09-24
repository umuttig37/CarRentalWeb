const cars = [
    {
        image: "../images/bmw-m5.jpg",
        title: "BMW M5",
        year: 2021,
        people: "4 People",
        fuel: "Gasoline",
        consumption: "20.0L/100km",
        transmission: "Automatic",
        price: "2000€"
    },
    {
        image: "../images/m3.jpg",
        title: "BMW M3",
        year: 2019,
        people: "4 People",
        fuel: "Gasoline",
        consumption: "15.0L/100km",
        transmission: "Automatic",
        price: "1500€"
    },
    {
        image: "../images/mercedes-gts.jpg",
        title: "Mercedes AMG GT S",
        year: 2020,
        people: "2 People",
        fuel: "Gasoline",
        consumption: "19.5L/100km",
        transmission: "Automatic",
        price: "2300€"
    },
    {
        image: "../images/Cadillac-Escalade.jpg",
        title: "Cadillac Escalade",
        year: 2020,
        people: "6 People",
        fuel: "Gasoline",
        consumption: "19.0L/100km",
        transmission: "Automatic",
        price: "1700€"
    },
    {
        image: "../images/audi-r8.jpg",
        title: "Audi R8",
        year: 2021,
        people: "2 People",
        fuel: "Gasoline",
        consumption: "20.0L/100km",
        transmission: "Automatic",
        price: "2100€"
    },
    {
        image: "../images/rs6.jpg",
        title: "Audi RS6",
        year: 2019,
        people: "5 People",
        fuel: "Gasoline",
        consumption: "20.0L/100km",
        transmission: "Automatic",
        price: "1900€"
    },
];

const carList = document.getElementById('car-list');

cars.forEach(car => {
    const li = document.createElement('li');
    li.innerHTML = `
        <div class="featured-car-card">
            <figure class="card-banner">
                <img src="${car.image}" alt="${car.title}" loading="lazy" width="440" height="300" class="w-100">
            </figure>
            <div class="card-content">
                <div class="card-title-wrapper">
                    <h3 class="h3 card-title">
                        <a href="#">${car.title}</a>
                    </h3>
                    <data class="year" value="${car.year}">${car.year}</data>
                </div>
                <ul class="card-list">
                    <li class="card-list-item">
                        <ion-icon name="people-outline"></ion-icon>
                        <span class="card-item-text">${car.people}</span>
                    </li>
                    <li class="card-list-item">
                        <ion-icon name="flash-outline"></ion-icon>
                        <span class="card-item-text">${car.fuel}</span>
                    </li>
                    <li class="card-list-item">
                        <ion-icon name="speedometer-outline"></ion-icon>
                        <span class="card-item-text">${car.consumption}</span>
                    </li>
                    <li class="card-list-item">
                        <ion-icon name="hardware-chip-outline"></ion-icon>
                        <span class="card-item-text">${car.transmission}</span>
                    </li>
                </ul>
                <div class="card-price-wrapper">
                    <p class="card-price">
                        <strong>${car.price}</strong> / month
                    </p>
                    <button class="btn fav-btn" aria-label="Add to favourite list">
                        <ion-icon name="heart-outline"></ion-icon>
                    </button>
                    <button class="btn">Rent now</button>
                </div>
            </div>
        </div>
    `;
    carList.appendChild(li);
});