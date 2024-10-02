const cars = [
    {
        vehicle_reg: "AMG-101",
        vehicle_title: "Mercedes AMG GT S",
        vehicle_year: 2020,
        vehicle_people: "2 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "19.5L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 2300,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/mercedes-gts.jpg"
    },
    {
        vehicle_reg: "ÄMM-3",
        vehicle_title: "BMW M3",
        vehicle_year: 2019,
        vehicle_people: "4 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "15.0L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 1500,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/m3.jpg"
    },
    {
        vehicle_reg: "ÄMM-5",
        vehicle_title: "BMW M5",
        vehicle_year: 2021,
        vehicle_people: "4 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "20.0L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 2000,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/bmw-m5.jpg"
    },
    {
        vehicle_reg: "ÄRR-8",
        vehicle_title: "Audi R8",
        vehicle_year: 2021,
        vehicle_people: "2 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "20.0L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 2100,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/audi-r8.jpg"
    },
    {
        vehicle_reg: "ÄRS-6",
        vehicle_title: "Audi RS6",
        vehicle_year: 2019,
        vehicle_people: "5 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "20.0L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 1900,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/rs6.jpg"
    },
    {
        vehicle_reg: "ESC-4",
        vehicle_title: "Cadillac Escalade",
        vehicle_year: 2020,
        vehicle_people: "6 People",
        vehicle_fuel: "Gasoline",
        vehicle_consumption: "19.0L/100km",
        vehicle_transmission: "Automatic",
        vehicle_price: 1700,
        vehicle_available: 1,
        image: "https://raw.githubusercontent.com/umuttgti97/carRentalImages/refs/heads/main/Cadillac-Escalade.jpg"
    }

];

// Get the car ID from the URL
const urlParams = new URLSearchParams(window.location.search);
const carReg = urlParams.get('carReg');

// Find the car based on the carId
const car = cars.find(c => c.vehicle_reg == carReg);

// Populate the page with car details
if (car) {
    document.getElementById('car-image').src = `../images/${car.image}`;
    document.getElementById('car-name').textContent = car.name;
    document.getElementById('car-description').textContent = car.description;
    document.getElementById('car-price').textContent = car.price;
} else {
    alert('Car not found!');
}
