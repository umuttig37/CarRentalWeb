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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/mercedes-gts.jpg"
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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/m3.jpg"
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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/bmw-m5.jpg"
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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/audi-r8.jpg"
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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/rs6.jpg"
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
        image: "https://raw.githubusercontent.com/umuttig37/carRentalImages/refs/heads/main/Cadillac-Escalade.jpg"
    }

];

const urlParams = new URLSearchParams(window.location.search);
const carReg = urlParams.get('carReg');

// Find the car based on the carReg
const car = cars.find(c => c.vehicle_reg === carReg);

// Populate the page with car details
if (car) {
    document.getElementById('car-image').src = car.image;
    document.getElementById('car-name').textContent = car.vehicle_title;
    document.getElementById('car-price').textContent = car.vehicle_price;

    // Get input elements for dates
    const pickupDateInput = document.getElementById('pickup-date');
    const dropoffDateInput = document.getElementById('dropoff-date');
    const calculatedPriceElement = document.getElementById('calculated-price');

    // Function to calculate the price
    function calculatePrice() {
        const pickupDate = new Date(pickupDateInput.value);
        const dropoffDate = new Date(dropoffDateInput.value);

        // Check if both dates are selected and the drop-off date is after the pickup date
        if (pickupDate && dropoffDate && !isNaN(pickupDate) && !isNaN(dropoffDate) && dropoffDate > pickupDate) {
            const timeDiff = dropoffDate.getTime() - pickupDate.getTime();
            const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24)); // Number of days

            const totalPrice = daysDiff * car.vehicle_price;

            // Check if calculatedPriceElement exists before setting its value
            if (calculatedPriceElement) {
                calculatedPriceElement.textContent = totalPrice;
            }
        } else {
            // If the dates are invalid or not selected, show the price per day
            if (calculatedPriceElement) {
                calculatedPriceElement.textContent = car.vehicle_price;
            }
        }
    }

    // Add event listeners to calculate price when either date changes
    pickupDateInput.addEventListener('input', calculatePrice);
    dropoffDateInput.addEventListener('input', calculatePrice);
} else {
    alert('Car not found!');
}
