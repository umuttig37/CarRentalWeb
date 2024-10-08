document.addEventListener('DOMContentLoaded', async function () {
    // Get the car registration from the URL
    const urlParams = new URLSearchParams(window.location.search);
    const carReg = urlParams.get('carReg');
    const token = localStorage.getItem('token');
    const rentButton = document.getElementById('Rent-button');
    const LeftSideImage = document.getElementById('left-side-image');

    if (carReg) {
        try {
            const response = await fetch('/api/vehicle');
            if (!response.ok) {
                throw new Error('Failed to fetch vehicle data.');
            }
            const cars = await response.json();

            const car = cars.find(c => c.vehicleReg === carReg);

            if (car) {
                // Update the page with the car details
                document.getElementById('car-name').textContent = car.vehicleTitle;
                document.getElementById('car-price').textContent = car.vehiclePrice;

                const leftSideElement = document.querySelector('.Left-side');
                if (leftSideElement) {
                    leftSideElement.style.backgroundImage = `url(${car.image})`;
                    leftSideElement.style.backgroundSize = 'cover';
                    leftSideElement.style.backgroundPosition = 'center';
                    leftSideElement.style.backgroundRepeat = 'no-repeat';
                }

                const pickupDateInput = document.getElementById('pickup-date');
                const dropoffDateInput = document.getElementById('dropoff-date');
                const calculatedPriceElement = document.getElementById('calculated-price');

                function calculatePrice() {
                    const pickupDate = new Date(pickupDateInput.value);
                    const dropoffDate = new Date(dropoffDateInput.value);

                    if (pickupDate && dropoffDate && !isNaN(pickupDate) && !isNaN(dropoffDate) && dropoffDate > pickupDate) {
                        const timeDiff = dropoffDate.getTime() - pickupDate.getTime();
                        const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));

                        const totalPrice = daysDiff * car.vehiclePrice;

                        if (calculatedPriceElement) {
                            calculatedPriceElement.textContent = totalPrice;
                        }
                    } else {
                        if (calculatedPriceElement) {
                            calculatedPriceElement.textContent = car.vehiclePrice;
                        }
                    }
                }

                pickupDateInput.addEventListener('input', calculatePrice);
                dropoffDateInput.addEventListener('input', calculatePrice);

                rentButton.addEventListener('click', function (event) {
                    event.preventDefault();

                    // Validate the dates
                    const pickupDate = pickupDateInput.value;
                    const dropoffDate = dropoffDateInput.value;

                    if (!pickupDate || !dropoffDate) {
                        alert('Please select both pickup and drop-off dates.');
                        return;
                    }

                    if (new Date(dropoffDate) <= new Date(pickupDate)) {
                        alert('Drop-off date must be after the pickup date.');
                        return;
                    }

                    // Confirm the rental
                    const confirmed = confirm(`Are you sure you want to rent this car (${car.vehicleTitle}) from ${pickupDate} to ${dropoffDate}?`);
                    if (confirmed) {
                        const rentalData = {
                            vehicleReg: car.vehicleReg,
                            pickupDate: pickupDate,
                            dropoffDate: dropoffDate
                        };

                        fetch('/api/rent', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                                'Authorization': `Bearer ${token}`
                            },
                            body: JSON.stringify(rentalData)
                        })
                            .then(response => {
                                if (response.ok) {
                                    return response.text().then(text => {
                                        try {

                                            return JSON.parse(text);
                                        } catch (e) {
                                            return { message: text };
                                        }
                                    });
                                } else {
                                    return response.text().then(text => {
                                        throw new Error(text);
                                    });
                                }
                            })
                            .then(data => {
                                console.log(data);
                                alert('Rental confirmed successfully!');
                                window.location.href = '/Rentals';
                            })
                            .catch(error => {
                                console.error('Error confirming rental:', error);
                                alert(`Error confirming rental: ${error.message}`);
                            });
                    }
                });
            } else {
                alert('Car not found!');
            }
        } catch (error) {
            console.error('Error fetching car data:', error);
        }
    }
});
