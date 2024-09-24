'use strict';

document.addEventListener('DOMContentLoaded', function () {

    const overlay = document.querySelector("[data-overlay]");
    const navbar = document.querySelector("[data-navbar]");
    const navToggleBtn = document.querySelector("[data-nav-toggle-btn]");
    const navbarLinks = document.querySelectorAll("[data-nav-link]");

    const navToggleFunc = function () {
        navToggleBtn.classList.toggle("active");
        navbar.classList.toggle("active");
        overlay.classList.toggle("active");
    }

    if (navToggleBtn) {
        navToggleBtn.addEventListener("click", navToggleFunc);
        overlay.addEventListener("click", navToggleFunc);

        for (let i = 0; i < navbarLinks.length; i++) {
            navbarLinks[i].addEventListener("click", navToggleFunc);
        }
    }

    const header = document.querySelector("[data-header]");

    if (header) {
        window.addEventListener("scroll", function () {
            window.scrollY >= 10 ? header.classList.add("active")
                : header.classList.remove("active");
        });
    }

    const searchForm = document.querySelector('.hero-form');

    if (searchForm) {
        searchForm.addEventListener('submit', function (event) {
            event.preventDefault();

            const carModel = document.getElementById('input-1').value;
            const monthlyPay = document.getElementById('input-2').value;
            const year = document.getElementById('input-3').value;

            // Store search values in localStorage (or pass as query params)
            const searchCriteria = {
                carModel: carModel,
                monthlyPay: monthlyPay,
                year: year
            };

            localStorage.setItem('carSearch', JSON.stringify(searchCriteria));

            window.location.href = 'search';
        });
    }
});