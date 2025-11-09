// Function definition that will be called by the HTML button's 'onclick' event
function displayCityValue() {
    // 1. Select the input element
    const cityInput = document.getElementById('city-input');
    
    // 2. Access the value property
    const cityValue = cityInput.value;
    
    // 3. Select the output paragraph element
    const outputParagraph = document.getElementById('output-message');
    
    // 4. Update the text content of the output element
    if (cityValue) {
        outputParagraph.textContent = `You entered: ${cityValue}`;
    } else {
        outputParagraph.textContent = `Please enter a city name.`;
    }

    // Optional: Clear the input field after reading
    cityInput.value = '';
}
