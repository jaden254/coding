// function validate(e) {
//     e.preventDefault();
//     const email = document.getElementById('email').value;
//     const pass = document.getElementById('password').value;
//     const age = document.getElementById('age').value;
//     const msgBox = document.getElementById('message');
//     let message = '';
//     if (email === '') {
//         message = 'Enter an email.';
//         msgBox.style.color = 'red';
//     } else if (pass === '') {
//         message = 'Enter a password.';
//         msgBox.style.color = 'red';
//     } else if (age === '') {
//         message = 'Enter your age.';
//         msgBox.style.color = 'red';
//     } else {
//         message = 'Login successful!';
//         msgBox.style.color = 'green';
//     }
//     msgBox.innerText = message;
// }
function validate(e) {
    e.preventDefault();
    const email = document.getElementById('email').value.trim();
    const pass = document.getElementById('password').value.trim();
    const age = document.getElementById('age').value.trim();
    const msgBox = document.getElementById('message');
    let message = '';
    let color = 'red';
    // Simple email pattern
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === '') {
        message = 'Enter an email.';
    } else if (!emailPattern.test(email)) {
        message = 'Enter a valid email address.';
    } else if (pass === '') {
        message = 'Enter a password.';
    } else if (age === '') {
        message = 'Enter your age.';
    } else {
        message = 'Login successful!';
        color = 'green';
    }
    msgBox.innerText = message;
    msgBox.style.color = color;
}


