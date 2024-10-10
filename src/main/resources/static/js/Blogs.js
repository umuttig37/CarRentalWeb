const blogs = [
    {
        image: "../images/Bugatti-Chiron.jpg",
        title: "more Supercars are coming!",
        date: "20. September, 2024",
        comments: 114,
        link: "#"
    },
    {
        image: "../images/Autobahn.jpg",
        title: "'The autobahn.'",
        date: "20. September, 2024",
        comments: 114,
        link: "#"
    },
    {
        image: "../images/car-find.jpg",
        title: "All luxury cars, from us!",
        date: "20 September, 2024",
        comments: 114,
        link: "#"
    },
    {
        image: "../images/Ferrari-Engine.jpg",
        title: "Contact us to find out which car will suit you the most!",
        date: "20. September, 2024",
        comments: 114,
        link: "#"
    }
];

const blogList = document.getElementById('blog-list');

blogs.forEach(blog => {
    const li = document.createElement('li');
    li.innerHTML = `
        <div class="blog-card">
            <figure class="card-banner">
                <a href="${blog.link}">
                    <img src="${blog.image}" alt="${blog.title}" loading="lazy" class="w-100">
                </a>
            </figure>
            <div class="card-content">
                <h3 class="h3 card-title">
                    <a href="${blog.link}">${blog.title}</a>
                </h3>
                <div class="card-meta">
                    <div class="publish-date">
                        <ion-icon name="time-outline"></ion-icon>
                        <time datetime="2022-01-14">${blog.date}</time>
                    </div>
                    <div class="comments">
                        <ion-icon name="chatbubble-ellipses-outline"></ion-icon>
                        <data value="${blog.comments}">${blog.comments}</data>
                    </div>
                </div>
            </div>
        </div>
    `;
    blogList.appendChild(li);
});