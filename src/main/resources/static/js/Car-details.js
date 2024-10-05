document.addEventListener('DOMContentLoaded', async function () {
    // Get the car registration from the URL
    const urlParams = new URLSearchParams(window.location.search);
    const carReg = urlParams.get('carReg');

    if (carReg) {
        try {
            // Fetch car data from the backend API
            const response = await fetch('/api/vehicle');
            if (!response.ok) {
                throw new Error('Failed to fetch vehicle data.');
            }
            const cars = await response.json();

            // Find the car by its registration number
            const car = cars.find(c => c.vehicleReg === carReg);

            if (car) {
                // Update the page with the car details
                document.getElementById('car-image').src = car.image;
                document.getElementById('car-name').textContent = car.vehicleTitle;
                document.getElementById('car-price').textContent = car.vehiclePrice;

                // Get input elements for dates
                const pickupDateInput = document.getElementById('pickup-date');
                const dropoffDateInput = document.getElementById('dropoff-date');
                const calculatedPriceElement = document.getElementById('calculated-price');

                function calculatePrice() {
                    const pickupDate = new Date(pickupDateInput.value);
                    const dropoffDate = new Date(dropoffDateInput.value);

                    // Check if both dates are selected and the drop-off date is after the pickup date
                    if (pickupDate && dropoffDate && !isNaN(pickupDate) && !isNaN(dropoffDate) && dropoffDate > pickupDate) {
                        const timeDiff = dropoffDate.getTime() - pickupDate.getTime();
                        const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));

                        const totalPrice = daysDiff * car.vehiclePrice;

                        // Check if calculatedPriceElement exists before setting its value
                        if (calculatedPriceElement) {
                            calculatedPriceElement.textContent = totalPrice;
                        }
                    } else {
                        // If the dates are invalid or not selected, show the price per day
                        if (calculatedPriceElement) {
                            calculatedPriceElement.textContent = car.vehiclePrice;
                        }
                    }
                }
                pickupDateInput.addEventListener('input', calculatePrice);
                dropoffDateInput.addEventListener('input', calculatePrice);

            } else {
                alert('Car not found!');
            }
        } catch (error) {
            console.error('Error fetching car data:', error);
        }
    }
    // Function to calculate the price
});