// DOM Elements
const darkModeBtn = document.getElementById('darkModeBtn');
const navbar = document.getElementById('navbar');
const navLinks = document.querySelectorAll('nav ul li a');

// Dark Mode Toggle
darkModeBtn.addEventListener('click', () => {
    document.body.classList.toggle('dark');

    // Update button icon
    if (document.body.classList.contains('dark')) {
        darkModeBtn.textContent = '☀️';
    } else {
        darkModeBtn.textContent = '🌙';
    }

    // Save preference to localStorage
    localStorage.setItem('darkMode', document.body.classList.contains('dark'));
});

// Check for saved dark mode preference
if (localStorage.getItem('darkMode') === 'true') {
    document.body.classList.add('dark');
    darkModeBtn.textContent = '☀️';
}

// Navbar scroll effect
window.addEventListener('scroll', () => {
    if (window.scrollY > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

// Smooth scrolling for navigation links
navLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        e.preventDefault();

        const targetId = link.getAttribute('href');
        const targetSection = document.querySelector(targetId);

        window.scrollTo({
            top: targetSection.offsetTop - 80,
            behavior: 'smooth'
        });
    });
});

// Active navigation link based on scroll position
window.addEventListener('scroll', () => {
    let current = '';

    document.querySelectorAll('section').forEach(section => {
        const sectionTop = section.offsetTop;
        const sectionHeight = section.clientHeight;

        if (scrollY >= (sectionTop - 200)) {
            current = section.getAttribute('id');
        }
    });

    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href').substring(1) === current) {
            link.classList.add('active');
        }
    });
});

// Form submission
const contactForm = document.querySelector('.contact-form');
if (contactForm) {
    contactForm.addEventListener('submit', (e) => {
        e.preventDefault();

        // Get form values
        const name = e.target.querySelector('input[type="text"]').value;
        const email = e.target.querySelector('input[type="email"]').value;
        const subject = e.target.querySelector('input[placeholder="Subject"]').value;
        const message = e.target.querySelector('textarea').value;

        // Here you would normally send the data to a server
        // For demo purposes, we'll just show a success message
        const button = e.target.querySelector('button');
        const originalText = button.textContent;

        button.textContent = 'Message Sent!';
        button.style.background = '#4CAF50';

        // Reset form after 3 seconds
        setTimeout(() => {
            e.target.reset();
            button.textContent = originalText;
            button.style.background = '';
        }, 3000);
    });
}

// Animate skill bars when in viewport
const skillBars = document.querySelectorAll('.bar span');
const animateSkillBars = () => {
    skillBars.forEach(bar => {
        const rect = bar.getBoundingClientRect();
        if (rect.top < window.innerHeight && rect.bottom > 0) {
            bar.style.animation = 'fillBar 2s ease-in-out forwards';
        }
    });
};

// Run once on page load
animateSkillBars();

// Run on scroll
window.addEventListener('scroll', animateSkillBars);

// Add active class to current navigation link
navLinks.forEach(link => {
    link.addEventListener('click', function () {
        navLinks.forEach(item => item.classList.remove('active'));
        this.classList.add('active');
    });
});

// Set initial active link
document.querySelector('nav ul li a').classList.add('active');

// Add CSS for active link
const style = document.createElement('style');
style.textContent = `
    nav ul li a.active {
        color: var(--primary-color);
    }
    
    nav ul li a.active::after {
        width: 100%;
    }
`;
document.head.appendChild(style);

// Animate elements on scroll
const animateOnScroll = () => {
    const elements = document.querySelectorAll('.project-card, .about-text p, .contact-info');

    elements.forEach(element => {
        const elementTop = element.getBoundingClientRect().top;
        const elementBottom = element.getBoundingClientRect().bottom;

        if (elementTop < window.innerHeight && elementBottom > 0) {
            element.style.opacity = '1';
            element.style.transform = 'translateY(0)';
        }
    });
};

// Initial setup for animation
document.querySelectorAll('.project-card, .about-text p, .contact-info').forEach(element => {
    element.style.opacity = '0';
    element.style.transform = 'translateY(20px)';
    element.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
});

// Run on scroll
window.addEventListener('scroll', animateOnScroll);

// Run once on page load
animateOnScroll();

// Add typing effect to the home section
const homeTitle = document.querySelector('.content h1');
if (homeTitle) {
    const text = homeTitle.textContent;
    homeTitle.textContent = '';

    let i = 0;
    const typeWriter = () => {
        if (i < text.length) {
            homeTitle.textContent += text.charAt(i);
            i++;
            setTimeout(typeWriter, 50);
        }
    };

    // Start typing effect after page loads
    setTimeout(typeWriter, 500);
}